package com.igormartinssilverio.aluraexpenses.repository

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView
import com.igormartinssilverio.aluraexpenses.model.view.TotalByCategoryView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

interface ExpenseRepository : JpaRepository<Expense, Long> {
    fun findByDescriptionContaining(description: String): Optional<List<ExpenseView>>

    fun findByPaymentDayBetween(year: LocalDate, month: LocalDate): Optional<List<ExpenseView>>

    @Query("select SUM(value) from Expense where paymentDay between :startDate and :endDate")
    fun findTotalValueByYearAndMonth(startDate: LocalDate, endDate: LocalDate): BigDecimal

    @Query("select new com.igormartinssilverio.aluraexpenses.model.view.TotalByCategoryView(e.category, SUM(e.value)) from Expense e where e.paymentDay between :startDate and :endDate group by e.category")
    fun findTotalByCategoryAndMonth(startDate: LocalDate, endDate: LocalDate) : List<TotalByCategoryView>
}
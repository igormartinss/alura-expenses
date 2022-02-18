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

    fun findByPaymentDayBetween(startDate: LocalDate, endDate: LocalDate): Optional<List<ExpenseView>>

    @Query("SELECT SUM(e.value) FROM Expense e WHERE e.paymentDay BETWEEN :startDate and :endDate")
    fun findTotalValueByYearAndMonth(startDate: LocalDate, endDate: LocalDate) : BigDecimal

    @Query("SELECT new com.igormartinssilverio.aluraexpenses.model.view.TotalByCategoryView(e.category, SUM(e.value)) " +
            "FROM Expense e WHERE e.paymentDay BETWEEN :startDate AND :endDate GROUP BY e.category")
    fun findTotalByCategoryAndMonth(startDate: LocalDate, endDate: LocalDate) : Optional<List<TotalByCategoryView>>
}
package com.igormartinssilverio.aluraexpenses.repository

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

interface IncomeRepository : JpaRepository<Income, Long> {
    fun findByDescriptionContaining(description: String) : Optional<List<IncomeView>>

    fun findByPaymentDayBetween(start: LocalDate, end: LocalDate) : Optional<List<IncomeView>>

    @Query("SELECT SUM(i.value) FROM Income i WHERE i.paymentDay BETWEEN :startDate and :endDate")
    fun findTotalValueByYearAndMonth(startDate: LocalDate, endDate: LocalDate) : BigDecimal
}
package com.igormartinssilverio.aluraexpenses.repository

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface ExpenseRepository : JpaRepository<Expense, Long> {
    fun findByDescriptionContaining(description: String): Optional<List<ExpenseView>>
    fun findByPaymentDayBetween(year: LocalDate, month: LocalDate): Optional<List<ExpenseView>>
}
package com.igormartinssilverio.aluraexpenses.model.view

import com.igormartinssilverio.aluraexpenses.model.enum.ExpenseCategoryEnum
import java.math.BigDecimal
import java.time.LocalDate

data class ExpenseView (
    val description: String,
    val value: BigDecimal,
    val paymentDay: LocalDate,
    val category: ExpenseCategoryEnum
)
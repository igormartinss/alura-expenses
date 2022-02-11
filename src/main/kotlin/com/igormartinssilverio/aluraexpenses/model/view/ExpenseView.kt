package com.igormartinssilverio.aluraexpenses.model.view

import java.math.BigDecimal
import java.time.LocalDate

data class ExpenseView (
    val description: String,
    val value: BigDecimal,
    val paymentDay: LocalDate
)
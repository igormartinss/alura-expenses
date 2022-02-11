package com.igormartinssilverio.aluraexpenses.model.form

import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.NotEmpty

data class ExpenseCreateForm (
    @field:NotEmpty(message = "Description should not be empty!")
    val description: String,
    @field:NotNull(message = "Value field is required!")
    val value: BigDecimal,
    @field:NotNull(message = "Payment day field is required!")
    val paymentDay: LocalDate
)
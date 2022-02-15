package com.igormartinssilverio.aluraexpenses.model.form

import com.igormartinssilverio.aluraexpenses.model.enum.ExpenseCategoryEnum
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class ExpenseForm (
    @field:NotEmpty(message = "Description should not be empty!")
    val description: String,
    @field:NotNull(message = "Value field is required!")
    val value: BigDecimal,
    @field:NotNull(message = "Payment day field is required!")
    val paymentDay: LocalDate,
    val category: ExpenseCategoryEnum = ExpenseCategoryEnum.OTHERS
)
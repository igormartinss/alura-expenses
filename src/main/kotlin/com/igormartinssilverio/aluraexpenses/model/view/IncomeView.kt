package com.igormartinssilverio.aluraexpenses.model.view

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column

data class IncomeView (
    val description: String,
    val value: BigDecimal,
    @Column(name="payment_day")
    val paymentDay: LocalDate
)

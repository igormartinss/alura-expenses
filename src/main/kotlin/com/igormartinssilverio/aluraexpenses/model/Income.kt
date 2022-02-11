package com.igormartinssilverio.aluraexpenses.model

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "incomes")
data class Income (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String = "",
    val value: BigDecimal = BigDecimal.ZERO,
    val paymentDay: LocalDate = LocalDate.now()
)
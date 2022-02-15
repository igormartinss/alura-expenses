package com.igormartinssilverio.aluraexpenses.model

import com.igormartinssilverio.aluraexpenses.model.enum.ExpenseCategoryEnum
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "expenses")
data class Expense (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String = "",
    val value: BigDecimal = BigDecimal.ZERO,
    val paymentDay: LocalDate = LocalDate.now(),
    @Enumerated(EnumType.STRING)
    val category: ExpenseCategoryEnum = ExpenseCategoryEnum.OTHERS
)

package com.igormartinssilverio.aluraexpenses.model.view

import com.igormartinssilverio.aluraexpenses.model.enum.ExpenseCategoryEnum
import java.math.BigDecimal

data class TotalByCategoryView (
    val category: ExpenseCategoryEnum,
    val amount: BigDecimal
)
package com.igormartinssilverio.aluraexpenses.model.view

import java.math.BigDecimal

data class SummaryView (
    val incomesTotal: BigDecimal,
    val expensesTotal: BigDecimal,
    val balance: BigDecimal,
    val categoriesBalances: List<TotalByCategoryView>
        )
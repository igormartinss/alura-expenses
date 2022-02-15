package com.igormartinssilverio.aluraexpenses.service.impl

import com.igormartinssilverio.aluraexpenses.model.view.SummaryView
import com.igormartinssilverio.aluraexpenses.model.view.TotalByCategoryView
import com.igormartinssilverio.aluraexpenses.repository.ExpenseRepository
import com.igormartinssilverio.aluraexpenses.repository.IncomeRepository
import com.igormartinssilverio.aluraexpenses.service.SummaryService
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.YearMonth

@Service
class SummaryServiceImpl(val expenseRepository: ExpenseRepository, val incomeRepository: IncomeRepository) : SummaryService {
    override fun findSummaryByMonth(year: Int, month: Int): SummaryView {
        val yearMonth = YearMonth.of(year, month)
        val startDate = yearMonth.atDay(1)
        val endDate = yearMonth.atEndOfMonth()

        val expenseTotal: BigDecimal = expenseRepository.findTotalValueByYearAndMonth(startDate, endDate)
        val incomeTotal: BigDecimal = incomeRepository.findTotalValueByYearAndMonth(startDate, endDate)
        val totalByCategory: List<TotalByCategoryView> = expenseRepository.findTotalByCategoryAndMonth(startDate, endDate)

        return SummaryView(
            expensesTotal = expenseTotal,
            incomesTotal = incomeTotal,
            balance = incomeTotal.subtract(expenseTotal),
            categoriesBalances = totalByCategory
        )
    }
}
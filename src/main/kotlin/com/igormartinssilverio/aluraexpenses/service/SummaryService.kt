package com.igormartinssilverio.aluraexpenses.service

import com.igormartinssilverio.aluraexpenses.model.view.SummaryView

interface SummaryService {
    fun findSummaryByMonth(year: Int, month: Int): SummaryView
}
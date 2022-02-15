package com.igormartinssilverio.aluraexpenses.repository

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface IncomeRepository : JpaRepository<Income, Long> {
    fun findByDescriptionContaining(description: String) : Optional<List<IncomeView>>
    fun findByPaymentDayBetween(start: LocalDate, end: LocalDate) : Optional<List<IncomeView>>
}
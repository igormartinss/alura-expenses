package com.igormartinssilverio.aluraexpenses.service

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeForm
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView

interface IncomeService {
    fun findAll(): List<IncomeView>
    fun create(incomeToCreate: IncomeForm) : Income
    fun findById(id: Long): IncomeView
    fun edit(id: Long, incomeToEdit: IncomeForm) : Income
    fun delete(id: Long) : Income
    fun findByDescriptionContaining(description: String): List<IncomeView>
    fun findByYearAndMonth(year: Int, month: Int): List<IncomeView>
}
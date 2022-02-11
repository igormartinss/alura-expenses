package com.igormartinssilverio.aluraexpenses.service

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeCreateForm
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView

interface IncomeService {
    fun getAll(): List<IncomeView>
    fun create(incomeToCreate: IncomeCreateForm): Income
}
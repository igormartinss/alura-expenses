package com.igormartinssilverio.aluraexpenses.service

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseCreateForm
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView

interface ExpenseService {
    fun getAll(): List<ExpenseView>
    fun create(expenseToCreate: ExpenseCreateForm): Expense
}
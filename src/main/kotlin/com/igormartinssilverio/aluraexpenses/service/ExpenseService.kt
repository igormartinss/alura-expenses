package com.igormartinssilverio.aluraexpenses.service

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseForm
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView

interface ExpenseService {
    fun findAll(): List<ExpenseView>
    fun findById(id: Long): ExpenseView
    fun create(expenseToCreate: ExpenseForm): Expense
    fun edit(id: Long, expenseToEdit: ExpenseForm): Expense
    fun delete(id: Long): Expense
}
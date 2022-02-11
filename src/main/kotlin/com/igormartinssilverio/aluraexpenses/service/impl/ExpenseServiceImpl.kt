package com.igormartinssilverio.aluraexpenses.service.impl

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseCreateForm
import com.igormartinssilverio.aluraexpenses.model.mapper.ExpenseFormToModelMapper
import com.igormartinssilverio.aluraexpenses.model.mapper.ExpenseModelToView
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView
import com.igormartinssilverio.aluraexpenses.repository.ExpenseRepository
import com.igormartinssilverio.aluraexpenses.service.ExpenseService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ExpenseServiceImpl(
    val repository: ExpenseRepository,
    val formToModelMapper: ExpenseFormToModelMapper,
    val modelToViewMapper: ExpenseModelToView
) : ExpenseService {
    override fun getAll(): List<ExpenseView> {
        return repository.findAll().map { expense ->
            modelToViewMapper.map(expense)
        }
    }

    override fun create(expenseToCreate: ExpenseCreateForm): Expense {
        return repository.save(formToModelMapper.map(expenseToCreate))
    }
}
package com.igormartinssilverio.aluraexpenses.service.impl

import com.igormartinssilverio.aluraexpenses.exception.NotFoundException
import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseForm
import com.igormartinssilverio.aluraexpenses.model.mapper.ExpenseFormToModelMapper
import com.igormartinssilverio.aluraexpenses.model.mapper.ExpenseModelToView
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView
import com.igormartinssilverio.aluraexpenses.repository.ExpenseRepository
import com.igormartinssilverio.aluraexpenses.service.ExpenseService
import org.springframework.stereotype.Service

@Service
class ExpenseServiceImpl(
    val repository: ExpenseRepository,
    val formToModelMapper: ExpenseFormToModelMapper,
    val modelToViewMapper: ExpenseModelToView
) : ExpenseService {
    override fun findAll(): List<ExpenseView> {
        return repository.findAll().map { expense ->
            modelToViewMapper.map(expense)
        }
    }

    override fun findById(id: Long): ExpenseView {
        return modelToViewMapper.map(findByIdOrThrowException(id))
    }

    override fun create(expenseToCreate: ExpenseForm): Expense {
        return repository.save(formToModelMapper.map(expenseToCreate))
    }

    override fun edit(id: Long, expenseToEdit: ExpenseForm): Expense {
        val expense = findByIdOrThrowException(id)
        val expenseEdited = Expense(
            id = expense.id,
            value = expenseToEdit.value,
            description = expenseToEdit.description,
            paymentDay = expenseToEdit.paymentDay
        )
        return repository.save(expenseEdited)
    }

    override fun delete(id: Long): Expense {
        val expense = findByIdOrThrowException(id)
        repository.delete(expense)
        return expense
    }

    override fun findByDescriptionContaining(description: String): List<ExpenseView> {
        return repository.findByDescriptionContaining(description).orElseThrow { NotFoundException("Expense not found for this description: $description") }
    }

    fun findByIdOrThrowException(id: Long) : Expense {
        return repository.findById(id).orElseThrow { NotFoundException("Expense not found for id $id") }
    }
}
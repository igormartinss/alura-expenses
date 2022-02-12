package com.igormartinssilverio.aluraexpenses.model.mapper

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseForm
import org.springframework.stereotype.Component

@Component
class ExpenseFormToModelMapper : Mapper<ExpenseForm, Expense> {

    override fun map(form: ExpenseForm) : Expense  {
        return Expense(
            description = form.description,
            value = form.value,
            paymentDay = form.paymentDay
        )
    }

}
package com.igormartinssilverio.aluraexpenses.model.mapper

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseCreateForm
import org.springframework.stereotype.Component

@Component
class ExpenseFormToModelMapper : Mapper<ExpenseCreateForm, Expense> {

    override fun map(form: ExpenseCreateForm) : Expense  {
        return Expense(
            description = form.description,
            value = form.value,
            paymentDay = form.paymentDay
        )
    }

}
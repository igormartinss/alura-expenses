package com.igormartinssilverio.aluraexpenses.model.mapper

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView
import org.springframework.stereotype.Component

@Component
class ExpenseModelToView : Mapper<Expense, ExpenseView>{
    override fun map(model: Expense): ExpenseView {
        return ExpenseView(
            description = model.description,
            value = model.value,
            paymentDay = model.paymentDay
        )
    }
}
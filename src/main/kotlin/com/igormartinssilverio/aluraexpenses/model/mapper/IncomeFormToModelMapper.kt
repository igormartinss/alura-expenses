package com.igormartinssilverio.aluraexpenses.model.mapper

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeForm
import org.springframework.stereotype.Component

@Component
class IncomeFormToModelMapper : Mapper<IncomeForm, Income> {
    override fun map(form: IncomeForm): Income {
        return(
                Income(
                    description = form.description,
                    value = form.value,
                    paymentDay = form.paymentDay
                )
        )
    }
}
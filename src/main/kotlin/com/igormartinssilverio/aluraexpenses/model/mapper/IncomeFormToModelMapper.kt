package com.igormartinssilverio.aluraexpenses.model.mapper

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeCreateForm
import org.springframework.stereotype.Component

@Component
class IncomeFormToModelMapper : Mapper<IncomeCreateForm, Income> {
    override fun map(form: IncomeCreateForm): Income {
        return(
                Income(
                    description = form.description,
                    value = form.value,
                    paymentDay = form.paymentDay
                )
        )
    }
}
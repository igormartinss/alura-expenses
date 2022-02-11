package com.igormartinssilverio.aluraexpenses.model.mapper

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView
import org.springframework.stereotype.Component

@Component
class IncomeModelToViewMapper : Mapper<Income, IncomeView> {
    override fun map(model: Income): IncomeView {
        return IncomeView(
            description = model.description,
            value = model.value,
            paymentDay = model.paymentDay
        )
    }

}

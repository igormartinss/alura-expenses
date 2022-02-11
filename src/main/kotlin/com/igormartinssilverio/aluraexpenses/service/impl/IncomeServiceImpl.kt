package com.igormartinssilverio.aluraexpenses.service.impl

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeCreateForm
import com.igormartinssilverio.aluraexpenses.model.mapper.IncomeFormToModelMapper
import com.igormartinssilverio.aluraexpenses.model.mapper.IncomeModelToViewMapper
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView
import com.igormartinssilverio.aluraexpenses.repository.IncomeRepository
import com.igormartinssilverio.aluraexpenses.service.IncomeService
import org.springframework.stereotype.Service

@Service
class IncomeServiceImpl(
    val repository: IncomeRepository,
    val formToModelMapper: IncomeFormToModelMapper,
    val modelToViewMapper: IncomeModelToViewMapper
) : IncomeService {

    override fun getAll(): List<IncomeView> {
        return repository.findAll().map { income ->
            modelToViewMapper.map(income)
        }
    }

    override fun create(incomeToCreate: IncomeCreateForm): Income {
        return repository.save(formToModelMapper.map(incomeToCreate))
    }
}
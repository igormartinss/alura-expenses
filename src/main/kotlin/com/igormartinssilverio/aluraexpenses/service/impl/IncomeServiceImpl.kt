package com.igormartinssilverio.aluraexpenses.service.impl

import com.igormartinssilverio.aluraexpenses.exception.NotFoundException
import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeForm
import com.igormartinssilverio.aluraexpenses.model.mapper.IncomeFormToModelMapper
import com.igormartinssilverio.aluraexpenses.model.mapper.IncomeModelToViewMapper
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView
import com.igormartinssilverio.aluraexpenses.repository.IncomeRepository
import com.igormartinssilverio.aluraexpenses.service.IncomeService
import org.springframework.stereotype.Service
import java.time.YearMonth

@Service
class IncomeServiceImpl(
    val repository: IncomeRepository,
    val formToModelMapper: IncomeFormToModelMapper,
    val modelToViewMapper: IncomeModelToViewMapper
) : IncomeService {

    override fun findAll(): List<IncomeView> {
        return repository.findAll().map { income ->
            modelToViewMapper.map(income)
        }
    }

    override fun create(incomeToCreate: IncomeForm): Income {
        return repository.save(formToModelMapper.map(incomeToCreate))
    }

    override fun findById(id: Long): IncomeView {
        return modelToViewMapper.map(findByIdOrElseThrow(id))
    }

    override fun edit(id: Long, incomeToEdit: IncomeForm): Income {
        val income: Income = findByIdOrElseThrow(id)
        return repository.save(Income(
            id = income.id,
            description = incomeToEdit.description,
            value = incomeToEdit.value,
            paymentDay = incomeToEdit.paymentDay
        ))
    }

    override fun delete(id: Long): Income {
        val income: Income = findByIdOrElseThrow(id)
        repository.delete(income)
        return income
    }

    override fun findByDescriptionContaining(description: String): List<IncomeView> {
        return repository.findByDescriptionContaining(description).orElseThrow {NotFoundException("Income not found containing this description: $description") }
    }

    override fun findByYearAndMonth(year: Int, month: Int): List<IncomeView> {
        val yearMonth: YearMonth = YearMonth.of(year, month)
        val startDate = yearMonth.atDay(1)
        val endDate = yearMonth.atEndOfMonth()
        return repository.findByPaymentDayBetween(startDate,endDate).orElseThrow { NotFoundException("Income not found for year $year and month $month") }
    }

    fun findByIdOrElseThrow(id: Long) : Income {
       return repository.findById(id).orElseThrow { NotFoundException("Income not found for id $id") }
    }
}
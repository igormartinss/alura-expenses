package com.igormartinssilverio.aluraexpenses.controller

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeForm
import com.igormartinssilverio.aluraexpenses.model.view.IncomeView
import com.igormartinssilverio.aluraexpenses.service.IncomeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/v1/incomes")
class IncomeController(val service: IncomeService) {

    @GetMapping
    fun findAll(@RequestParam(value = "description", required = false) description: String): ResponseEntity<List<IncomeView>> {
        return if (description.isNullOrEmpty()) {
            ResponseEntity.ok(service.findAll())
        } else {
            ResponseEntity.ok(service.findByDescriptionContaining(description))
        }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<IncomeView> {
        return ResponseEntity.ok(service.findById(id))
    }

    @GetMapping("/{year}/{month}")
    fun findByYearAndMonth(@PathVariable year: Int, @PathVariable month: Int): ResponseEntity<List<IncomeView>> {
        return ResponseEntity.ok(service.findByYearAndMonth(year, month))
    }

    @PostMapping
    fun create(
        @Valid @RequestBody incomeToCreate: IncomeForm,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Income> {
        val incomeCreated: Income = service.create(incomeToCreate)
        val uri = uriComponentsBuilder.path("v1/incomes/${incomeCreated.id}").build().toUri()

        return ResponseEntity.created(uri).body(incomeCreated)
    }

    @PutMapping("/{id}")
    fun edit(@PathVariable id: Long, @RequestBody @Valid incomeToEdit: IncomeForm) : ResponseEntity<Income> {
        return ResponseEntity.ok(service.edit(id, incomeToEdit))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Income> {
        return ResponseEntity.ok(service.delete(id))
    }

}
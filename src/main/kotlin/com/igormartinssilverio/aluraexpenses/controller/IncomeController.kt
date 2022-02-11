package com.igormartinssilverio.aluraexpenses.controller

import com.igormartinssilverio.aluraexpenses.model.Income
import com.igormartinssilverio.aluraexpenses.model.form.IncomeCreateForm
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
    fun getAll(): ResponseEntity<List<IncomeView>> {
        return ResponseEntity.ok(service.getAll())
    }

    @PostMapping
    fun create(
        @Valid @RequestBody incomeToCreate: IncomeCreateForm,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Income> {
        val incomeCreated: Income = service.create(incomeToCreate)
        val uri = uriComponentsBuilder.path("v1/incomes/${incomeCreated.id}").build().toUri()

        return ResponseEntity.created(uri).body(incomeCreated)
    }

}
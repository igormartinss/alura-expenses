package com.igormartinssilverio.aluraexpenses.controller

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseCreateForm
import com.igormartinssilverio.aluraexpenses.model.view.ExpenseView
import com.igormartinssilverio.aluraexpenses.service.ExpenseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/v1/expenses")
class ExpenseController(val service: ExpenseService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<ExpenseView>> {
        return ResponseEntity.ok(service.getAll())
    }

    @PostMapping
    fun create(
        @RequestBody @Valid expenseToCreate: ExpenseCreateForm,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Expense> {
        val expenseCreated: Expense = service.create(expenseToCreate)
        val uri = uriComponentsBuilder.path("v1/expenses/${expenseCreated.id}").build().toUri()

        return ResponseEntity.created(uri).body(expenseCreated)
    }
}
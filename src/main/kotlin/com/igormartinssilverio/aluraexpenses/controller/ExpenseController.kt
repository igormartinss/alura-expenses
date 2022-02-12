package com.igormartinssilverio.aluraexpenses.controller

import com.igormartinssilverio.aluraexpenses.model.Expense
import com.igormartinssilverio.aluraexpenses.model.form.ExpenseForm
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
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<ExpenseView> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PostMapping
    fun create(
        @RequestBody @Valid expenseToCreate: ExpenseForm,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Expense> {
        val expenseCreated: Expense = service.create(expenseToCreate)
        val uri = uriComponentsBuilder.path("v1/expenses/${expenseCreated.id}").build().toUri()

        return ResponseEntity.created(uri).body(expenseCreated)
    }

    @PutMapping("/{id}")
    fun edit(@PathVariable id: Long, @RequestBody @Valid expenseToEdit: ExpenseForm) : ResponseEntity<Expense> {
        return ResponseEntity.ok(service.edit(id, expenseToEdit))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Expense> {
        return ResponseEntity.ok(service.delete(id))
    }

}
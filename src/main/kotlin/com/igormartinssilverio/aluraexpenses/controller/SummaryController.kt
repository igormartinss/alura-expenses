package com.igormartinssilverio.aluraexpenses.controller

import com.igormartinssilverio.aluraexpenses.model.view.SummaryView
import com.igormartinssilverio.aluraexpenses.service.SummaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/summary")
class SummaryController(val service: SummaryService) {

    @GetMapping("/{year}/{month}")
    fun findMonthSummary(@PathVariable year: Int, @PathVariable month: Int) : ResponseEntity<SummaryView>?{
        return ResponseEntity.ok(service.findSummaryByMonth(year, month))
    }
}
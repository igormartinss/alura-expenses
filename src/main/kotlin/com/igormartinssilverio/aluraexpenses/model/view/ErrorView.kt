package com.igormartinssilverio.aluraexpenses.model.view

import java.time.LocalDateTime

data class ErrorView (
    val status: Int,
    val error: String,
    val message: String?,
    val path: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

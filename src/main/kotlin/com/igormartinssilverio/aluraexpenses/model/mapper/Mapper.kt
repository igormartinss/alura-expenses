package com.igormartinssilverio.aluraexpenses.model.mapper

import org.springframework.stereotype.Component

@Component
interface Mapper <T, U> {
    fun map(t: T): U
}
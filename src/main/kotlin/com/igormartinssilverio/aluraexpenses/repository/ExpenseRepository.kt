package com.igormartinssilverio.aluraexpenses.repository

import com.igormartinssilverio.aluraexpenses.model.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository : JpaRepository<Expense, Long>
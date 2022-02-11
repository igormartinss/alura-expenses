package com.igormartinssilverio.aluraexpenses.repository

import com.igormartinssilverio.aluraexpenses.model.Income
import org.springframework.data.jpa.repository.JpaRepository

interface IncomeRepository : JpaRepository<Income, Long>
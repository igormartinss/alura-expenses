package com.igormartinssilverio.aluraexpenses.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val username: String = "",
    val email: String = "",
    val password: String = ""
)
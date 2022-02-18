package com.igormartinssilverio.aluraexpenses.service.impl

import com.igormartinssilverio.aluraexpenses.exception.NotFoundException
import com.igormartinssilverio.aluraexpenses.repository.UserRepository
import com.igormartinssilverio.aluraexpenses.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val repository: UserRepository) : UserService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByUsername(username) ?: throw NotFoundException("User not found")
        return UserDetailsServiceImpl(user)
    }
}
package com.ceph.jwtTokens.repository

import com.ceph.jwtTokens.model.Role
import com.ceph.jwtTokens.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepository(
    private val encoder: PasswordEncoder
) {
    private val users = mutableListOf(
        User(
            id = UUID.randomUUID(),
            password = encoder.encode("User 1"),
            email = "email1@gmail.com",
            role = Role.ADMIN
        ),
        User(
            id = UUID.randomUUID(),
            password = encoder.encode("User 2"),
            email = "email2@gmail.com",
            role = Role.USER
        ), User(
            id = UUID.randomUUID(),
            password = encoder.encode("User 3"),
            email = "email3@gmail.com",
            role = Role.USER
        )
    )

    fun addUser(user: User): Boolean {
        val updated = user.copy(password = encoder.encode(user.password))
        return users.add(updated)
    }


    fun findByEmail(email: String): User? =
        users.firstOrNull { it.email == email }

    fun findByUUID(uuid: UUID): User? =
        users.firstOrNull { it.id == uuid }

    fun findAll(): List<User> =
        users

    fun deleteUser(uuid: UUID): Boolean {
        val foundUser = findByUUID(uuid)
        return foundUser?.let {
            users.remove(it)
        } ?: false
    }


}
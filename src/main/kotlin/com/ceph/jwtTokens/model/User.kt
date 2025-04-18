package com.ceph.jwtTokens.model

import java.util.UUID

data class User(
    val id: UUID,
    val password: String,
    val email: String,
    val role : Role
)

enum class Role {
    USER, ADMIN
}
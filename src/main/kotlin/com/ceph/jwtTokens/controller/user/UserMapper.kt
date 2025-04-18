package com.ceph.jwtTokens.controller.user

import com.ceph.jwtTokens.model.Role
import com.ceph.jwtTokens.model.User
import java.util.*

fun UserRequest.toUser(): User {
    return User(
        id = UUID.randomUUID(),
        email = this.email,
        password = this.password,
        role = Role.USER
    )
}

fun User.toUserResponse(): UserResponse {
    return UserResponse(
        id = this.id,
        email = this.email
    )
}
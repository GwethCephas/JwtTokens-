package com.ceph.jwtTokens.controller.user

data class UserRequest(
    val email: String,
    val password: String
)

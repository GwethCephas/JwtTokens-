package com.ceph.jwtTokens.controller.auth

data class AuthRequest(
    val email: String,
    val password: String
)

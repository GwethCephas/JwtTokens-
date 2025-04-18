package com.ceph.jwtTokens.controller.user

import com.ceph.jwtTokens.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody userRequest: UserRequest): UserResponse =
        userService.createUser(userRequest.toUser())
            ?.toUserResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create the user")


    @GetMapping
    fun getAllUsers(): List<UserResponse> =
        userService.findAll()
            .map { it.toUserResponse() }


    @GetMapping("/{uuid}")
    fun getUserByUUID(@PathVariable uuid: UUID): UserResponse =
        userService.findUserByUUID(uuid)
            ?.toUserResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find the user")

    @DeleteMapping("/{uuid}")
    fun deleteUser(@PathVariable uuid: UUID): ResponseEntity<Boolean> {
        val successfulDelete = userService.deleteUser(uuid)
        return if (successfulDelete)
            ResponseEntity.noContent()
                .build()
        else throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find the user")
    }
}
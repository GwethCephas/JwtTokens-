package com.ceph.jwtTokens.service

import com.ceph.jwtTokens.model.User
import com.ceph.jwtTokens.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): List<User> = userRepository.findAll()

    fun createUser(user: User): User? {
        val foundUser = userRepository.findByEmail(user.email)
        return if (foundUser == null) {
            userRepository.addUser(user)
            return user
        } else null
    }

    fun findUserByUUID(uuid: UUID): User? = userRepository.findByUUID(uuid)

    fun deleteUser(uuid: UUID): Boolean = userRepository.deleteUser(uuid)
}
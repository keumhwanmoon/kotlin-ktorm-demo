package com.demo.ktorm.user.controller

import com.demo.ktorm.user.models.UserRes
import com.demo.ktorm.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/api/users")
    fun getUsers(): List<UserRes> {
        return userService.getAllUsers()
    }
}
package com.demo.ktorm.user.controller

import com.demo.ktorm.user.models.UserReq
import com.demo.ktorm.user.models.UserRes
import com.demo.ktorm.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/api/users")
    fun getUsers(): List<UserRes> {
        return userService.getAllUsers()
    }

    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerUser(@RequestBody request: UserReq): UserRes {
        return userService.createUser(request)
    }
}
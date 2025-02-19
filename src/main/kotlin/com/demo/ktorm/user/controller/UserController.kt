package com.demo.ktorm.user.controller

import com.demo.ktorm.user.models.UserReq
import com.demo.ktorm.user.models.UserRes
import com.demo.ktorm.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * Controller class to handle REST API endpoints for users.
 */
@RestController
class UserController(
    private val userService: UserService
) {

    /**
     * Retrieves all users.
     *
     * @return a list of user response objects.
     */
    @GetMapping("/api/users")
    fun getUsers(): List<UserRes> {
        return userService.getAllUsers()
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the user response object.
     */
    @GetMapping("/api/users/{id}")
    fun getUser(@PathVariable id: Long): UserRes {
        return userService.getUser(id)
    }

    /**
     * Registers a new user.
     *
     * @param request the user request object containing user details.
     * @return the created user response object.
     */
    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerUser(@RequestBody request: UserReq): UserRes {
        return userService.createUser(request)
    }
}
package com.demo.ktorm.user.service

import com.demo.ktorm.user.domain.entity.Users
import com.demo.ktorm.user.models.UserReq
import com.demo.ktorm.user.models.UserRes
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

/**
 * Service class responsible for user-related operations such as retrieving, creating, updating,
 * and deleting users from the database.
 *
 * This class interacts with a database object and performs transactions to manage user records.
 */
@Service
class UserService(
    private val database: Database
) {
    /**
     * Retrieves all users from the database.
     *
     * @return a list of user response objects.
     */
    @Transactional
    fun getAllUsers(): List<UserRes> {
        return database
            .from(Users)
            .select(
                Users.id,
                Users.loginId,
                Users.userName,
                Users.picture,
                Users.phoneNumber,
                Users.mobilePhoneNumber,
                Users.email
            )
            .map { row ->
                UserRes(
                    id = row[Users.id],
                    loginId = row[Users.loginId]!!,
                    userName = row[Users.userName],
                    picture = row[Users.picture],
                    phoneNumber = row[Users.phoneNumber],
                    mobilePhoneNumber = row[Users.mobilePhoneNumber],
                    email = row[Users.email]
                )
            }
    }

    /**
     * Retrieves a single user by their ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the user response object.
     */
    fun getUser(id: Long): UserRes {
        return userById(id)
    }

    /**
     * Creates a new user in the database.
     *
     * @param request the user request object containing user details.
     * @return the created user response object.
     */
    @Transactional
    fun createUser(request: UserReq): UserRes {
        val now = LocalDateTime.now()

        val id = database.insertAndGenerateKey(Users) {
            set(Users.loginId, request.loginId)
            set(Users.userName, request.userName)
            set(Users.picture, request.picture)
            set(Users.phoneNumber, request.phoneNumber)
            set(Users.mobilePhoneNumber, request.mobilePhoneNumber)
            set(Users.email, request.email)
            set(Users.createdAt, now)
            set(Users.lastUpdatedAt, now)
        } as Long

        return userById(id)
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete.
     */
    fun deleteUser(id: Long) {
        val userExists = database
            .from(Users)
            .select()
            .where { Users.id eq id }
            .totalRecordsInAllPages > 0

        if (!userExists) {
            throw IllegalArgumentException("BadRequestException: User with ID $id does not exist.")
        }

        database.delete(Users) { it.id eq id }
    }


    /**
     * Updates the details of an existing user in the database.
     * Throws an exception if the user with the specified ID does not exist.
     *
     * @param id the ID of the user to update.
     * @param request the user request object containing updated user details.
     * @return the updated user response object.
     */
    fun updateUser(id: Long, request: UserReq): UserRes {
        val now = LocalDateTime.now()

        val affectedRows = database.update(Users) {
            set(Users.loginId, request.loginId)
            set(Users.userName, request.userName)
            set(Users.picture, request.picture)
            set(Users.phoneNumber, request.phoneNumber)
            set(Users.mobilePhoneNumber, request.mobilePhoneNumber)
            set(Users.email, request.email)
            set(Users.lastUpdatedAt, now)
            where { Users.id eq id }
        }

        if (affectedRows == 0) {
            throw IllegalArgumentException("BadRequestException: User with ID $id does not exist.")
        }

        return userById(id)
    }

    /**
     * Helper method to fetch a user by their ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the user response object.
     */
    private fun userById(id: Long) = database.from(Users)
        .select(
            Users.id,
            Users.loginId,
            Users.userName,
            Users.picture,
            Users.phoneNumber,
            Users.mobilePhoneNumber,
            Users.email
        ).where { Users.id eq id }
        .map { row ->
            UserRes(
                id = row[Users.id],
                loginId = row[Users.loginId]!!,
                userName = row[Users.userName],
                picture = row[Users.picture],
                phoneNumber = row[Users.phoneNumber],
                mobilePhoneNumber = row[Users.mobilePhoneNumber],
                email = row[Users.email]
            )
        }.first()
}
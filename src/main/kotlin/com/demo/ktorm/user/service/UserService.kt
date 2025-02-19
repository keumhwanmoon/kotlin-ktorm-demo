package com.demo.ktorm.user.service

import com.demo.ktorm.user.domain.entity.Users
import com.demo.ktorm.user.models.UserReq
import com.demo.ktorm.user.models.UserRes
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class UserService(
    private val database: Database
) {
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

        return database.from(Users)
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
}
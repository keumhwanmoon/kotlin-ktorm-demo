package com.demo.ktorm.user.service

import com.demo.ktorm.user.domain.entity.Users
import com.demo.ktorm.user.models.UserRes
import org.ktorm.database.Database
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
}
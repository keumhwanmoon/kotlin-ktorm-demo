package com.demo.ktorm.user.models

data class UserRes(
    val id: Long?,
    val loginId: String,
    val userName: String?,
    val picture: String?,
    val phoneNumber: String?,
    val mobilePhoneNumber: String?,
    val email: String?
)

package com.demo.ktorm.user.domain.entity

import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object Users : Table<Nothing>("USERS") {
    val id = long("ID").primaryKey()
    val loginId = varchar("LOGIN_ID")
    val userName = varchar("USER_NAME")
    val picture = varchar("PICTURE")
    val phoneNumber = varchar("PHONE_NUMBER")
    val mobilePhoneNumber = varchar("MOBILE_PHONE_NUMBER")
    val email = varchar("EMAIL")
}

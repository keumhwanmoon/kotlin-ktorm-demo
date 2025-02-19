package com.demo.ktorm.code.models

import java.time.LocalDateTime

data class CodeRes(
    val seq: Long,
    val codeId: String,
    val parCodeId: String?,
    val codeName: String?,
    val codeValue: String?,
    val codeExplanation: String?,
    val useYn: String?,
    val sortNumber: Int?,
    val createdAt: LocalDateTime?,
    val lastUpdatedAt: LocalDateTime?
)
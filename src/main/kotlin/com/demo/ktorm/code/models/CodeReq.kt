package com.demo.ktorm.code.models

data class CodeReq(
    val codeId: String,
    val parCodeId: String?,
    val codeName: String?,
    val codeValue: String?,
    val codeExplanation: String?,
    val useYn: String? = "Y",
    val sortNumber: Int?
)
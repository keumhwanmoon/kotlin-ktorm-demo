package com.demo.ktorm.code.domain.entity

import com.demo.ktorm.code.models.CodeRes
import org.ktorm.entity.Entity
import java.time.LocalDateTime

interface Code : Entity<Code> {
    fun toCodeRes(): CodeRes {
        return CodeRes(
            seq = this.seq,
            codeId = this.codeId,
            parCodeId = this.parCodeId,
            codeName = this.codeName,
            codeValue = this.codeValue,
            codeExplanation = this.codeExplanation,
            useYn = this.useYn,
            sortNumber = this.sortNumber,
            createdAt = this.createdAt,
            lastUpdatedAt = this.lastUpdatedAt
        )
    }

    companion object : Entity.Factory<Code>()

    var seq: Long
    var codeId: String
    var parCodeId: String?
    var codeName: String?
    var codeValue: String?
    var codeExplanation: String?
    var useYn: String?
    var sortNumber: Int?
    var createdAt: LocalDateTime?
    var lastUpdatedAt: LocalDateTime?
}

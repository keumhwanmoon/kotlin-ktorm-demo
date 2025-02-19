package com.demo.ktorm.code.service

import com.demo.ktorm.code.domain.entity.Code
import com.demo.ktorm.code.domain.entity.Codes
import com.demo.ktorm.code.models.CodeRes
import com.demo.ktorm.code.models.CodeReq
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CodeService(
    private val database: Database
) {
    private val codes get() = database.sequenceOf(Codes)

    @Transactional(readOnly = true)
    fun getAllCodes(): List<CodeRes> {
        return codes
            .sortedBy { it.sortNumber }
            .map { it.toCodeRes() }
            .toList()
    }

    @Transactional(readOnly = true)
    fun getCode(codeId: String): CodeRes {
        return codes
            .find { it.codeId eq codeId }
            ?.toCodeRes()
            ?: throw IllegalArgumentException("Code not found with ID: $codeId")
    }

    @Transactional
    fun createCode(request: CodeReq): CodeRes {
        if (codes.any { it.codeId eq request.codeId }) {
            throw IllegalArgumentException("Code already exists with ID: ${request.codeId}")
        }

        val code = Code {
            this.codeId = request.codeId
            this.parCodeId = request.parCodeId
            this.codeName = request.codeName
            this.codeValue = request.codeValue
            this.codeExplanation = request.codeExplanation
            this.useYn = request.useYn
            this.sortNumber = request.sortNumber
            this.createdAt = LocalDateTime.now()
        }

        codes.add(code)
        return getCode(code.codeId)
    }

    @Transactional
    fun updateCode(codeId: String, request: CodeReq): CodeRes {
        val code = codes
            .find { it.codeId eq codeId }
            ?: throw IllegalArgumentException("Code not found with ID: $codeId")

        code.apply {
            this.parCodeId = request.parCodeId
            this.codeName = request.codeName
            this.codeValue = request.codeValue
            this.codeExplanation = request.codeExplanation
            this.useYn = request.useYn
            this.sortNumber = request.sortNumber
            this.lastUpdatedAt = LocalDateTime.now()
        }

        codes.update(code)
        return getCode(codeId)
    }

    @Transactional
    fun deleteCode(codeId: String) {
        val code = codes
            .find { it.codeId eq codeId }
            ?: throw IllegalArgumentException("Code not found with ID: $codeId")

        codes.removeIf { it.codeId eq codeId }
    }
}

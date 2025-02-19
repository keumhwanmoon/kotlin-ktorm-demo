package com.demo.ktorm.code.domain.entity.sequence

import com.demo.ktorm.code.domain.entity.Code
import org.ktorm.schema.Table
import org.ktorm.schema.*

object Codes : Table<Code>("CODE") {
    val seq = long("SEQ").primaryKey().bindTo { it.seq }
    var codeId = varchar("CODE_ID").bindTo { it.codeId }
    val parCodeId = varchar("PAR_CODE_ID").bindTo { it.parCodeId }
    val codeName = varchar("CODE_NAME").bindTo { it.codeName }
    val codeValue = varchar("CODE_VALUE").bindTo { it.codeValue }
    val codeExplanation = varchar("CODE_EXPLANATION").bindTo { it.codeExplanation }
    val useYn = varchar("USE_YN").bindTo { it.useYn.toString() }
    val sortNumber = int("SORT_NUMBER").bindTo { it.sortNumber }
    val createdAt = datetime("CREATED_AT").bindTo { it.createdAt }
    val lastUpdatedAt = datetime("LAST_UPDATED_AT").bindTo { it.lastUpdatedAt }
}

package com.demo.ktorm.code.domain.entity

import com.demo.ktorm.code.models.CodeRes
import org.ktorm.entity.Entity
import java.time.LocalDateTime

/**
 * 공통 코드 테이블을 표현하는 Ktorm DSL 클래스입니다.
 * Ktorm의 시퀀스 API를 활용하여 타입 안전한 엔티티 기반의 데이터 접근을 제공합니다.
 *
 * Ktorm의 시퀀스 API는 컬렉션과 유사한 방식으로 데이터를 다룰 수 있게 해주며,
 * Entity 객체를 통한 ORM 스타일의 작업을 가능하게 합니다.
 *
 * @property seq 코드의 고유 식별자 (Primary Key) - 자동 생성되는 시퀀스 값
 * @property codeId 코드 ID - 고유한 코드 식별자
 * @property parCodeId 상위 코드 ID - 계층 구조를 표현하기 위한 상위 코드 참조
 * @property codeName 코드명 - 사용자가 이해할 수 있는 코드의 이름
 * @property codeValue 코드값 - 실제 시스템에서 사용되는 코드의 값
 * @property codeExplanation 코드 설명 - 해당 코드에 대한 상세 설명
 * @property useYn 사용 여부 - 코드의 활성화/비활성화 상태 ('Y'/'N')
 * @property sortNumber 정렬 순서 - 같은 레벨의 코드들 간의 표시 순서
 * @property createdAt 생성일시
 * @property lastUpdatedAt 최종 수정일시
 *
 * 시퀀스 API 사용 예시:
 * ```kotlin
 * // 1. 시퀀스로 전체 코드 조회
 * val codes = database.sequenceOf(Codes)
 *     .filter { it.useYn eq "Y" }
 *     .sortedBy { it.sortNumber }
 *     .toList()
 *
 * // 2. 단일 코드 조회
 * val code = database.sequenceOf(Codes)
 *     .firstOrNull { it.codeId eq "CODE_001" }
 *
 * // 3. 페이징 처리
 * val pagedCodes = database.sequenceOf(Codes)
 *     .filter { it.parCodeId eq "PAR_001" }
 *     .sortedBy { it.sortNumber }
 *     .drop(offset)
 *     .take(limit)
 *     .toList()
 *
 * // 4. 집계 함수 사용
 * val count = database.sequenceOf(Codes)
 *     .filter { it.parCodeId eq "PAR_001" }
 *     .count()
 *
 * // 5. 엔티티 객체를 통한 신규 생성
 * val newCode = Code {
 *     codeId = "CODE_NEW"
 *     parCodeId = "PAR_001"
 *     codeName = "새로운 코드"
 *     codeValue = "NEW_VALUE"
 *     codeExplanation = "새로운 코드 설명"
 *     useYn = "Y"
 *     sortNumber = 1
 *     createdAt = LocalDateTime.now()
 *     lastUpdatedAt = LocalDateTime.now()
 * }
 * database.sequenceOf(Codes).add(newCode)
 *
 * // 6. 엔티티 수정
 * val existingCode = database.sequenceOf(Codes)
 *     .first { it.codeId eq "CODE_001" }
 *
 * existingCode.apply {
 *     codeName = "수정된 이름"
 *     lastUpdatedAt = LocalDateTime.now()
 * }
 * database.sequenceOf(Codes).update(existingCode)
 *
 * // 7. 조건부 삭제
 * database.sequenceOf(Codes)
 *     .filter { it.parCodeId eq "PAR_001" }
 *     .forEach { code ->
 *         database.sequenceOf(Codes).remove(code)
 *     }
 *
 * // 8. 체이닝을 활용한 복잡한 조회
 * val complexQuery = database.sequenceOf(Codes)
 *     .filter { it.useYn eq "Y" }
 *     .filter { it.parCodeId eq "PAR_001" }
 *     .sortedBy { it.sortNumber }
 *     .map { code ->
 *         CodeDto(
 *             id = code.seq,
 *             name = code.codeName,
 *             value = code.codeValue
 *         )
 *     }
 *     .toList()
 *
 * // 9. 그룹화와 집계
 * val groupedCodes = database.sequenceOf(Codes)
 *     .groupBy { it.parCodeId }
 *     .map { (parCodeId, codes) ->
 *         CodeGroupDto(
 *             parCodeId = parCodeId,
 *             childCount = codes.count(),
 *             childCodes = codes.toList()
 *         )
 *     }
 *
 * // 10. 존재 여부 확인
 * val exists = database.sequenceOf(Codes)
 *     .any { it.codeId eq "CODE_001" }
 * ```
 *
 * Ktorm 시퀀스 API의 주요 특징:
 * - 컬렉션과 유사한 직관적인 인터페이스
 * - 타입 안전한 엔티티 조작
 * - 지연 평가(lazy evaluation) 지원
 * - 메서드 체이닝을 통한 쿼리 구성
 * - 엔티티 객체의 생명주기 관리
 *
 * @see org.ktorm.schema.Table
 * @see org.ktorm.entity.Entity
 * @see org.ktorm.entity.EntitySequence
 */
interface Code : Entity<Code> {
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
}

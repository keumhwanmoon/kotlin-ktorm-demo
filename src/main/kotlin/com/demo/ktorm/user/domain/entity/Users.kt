package com.demo.ktorm.user.domain.entity

import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.long
import org.ktorm.schema.varchar

/**
 * Users 테이블을 표현하는 Ktorm DSL 클래스입니다.
 * Ktorm의 선언적 테이블 정의 방식을 사용하여 데이터베이스 테이블과 매핑됩니다.
 *
 * [Ktorm](https://www.ktorm.org/)의 Table 클래스를 상속받아 DSL 방식으로 SQL을 작성할 수 있게 합니다.
 * Nothing 타입 파라미터는 이 테이블이 엔티티 클래스와 매핑되지 않음을 나타냅니다.
 *
 * @property id 사용자의 고유 식별자 (Primary Key)
 * @property loginId 사용자 로그인 아이디
 * @property userName 사용자 이름
 * @property picture 사용자 프로필 사진 URL
 * @property phoneNumber 전화번호
 * @property mobilePhoneNumber 휴대전화 번호
 * @property email 이메일 주소
 * @property createdAt 생성 일시
 * @property lastUpdatedAt 마지막 수정 일시
 *
 * 사용 예시:
 * ```kotlin
 * // Select 쿼리 예시
 * // 1. 단일 사용자 조회
 * val user = database.from(Users).select()
 *     .where { Users.email eq "example@email.com" }
 *     .map { row ->
 *         UserDto(
 *             id = row[Users.id]!!,
 *             loginId = row[Users.loginId]!!,
 *             userName = row[Users.userName]!!
 *         )
 *     }.firstOrNull()
 *
 * // 2. 조건부 다중 사용자 조회
 * val activeUsers = database.from(Users).select()
 *     .where {
 *         (Users.lastUpdatedAt gt LocalDateTime.now().minusDays(30)) and
 *         (Users.email like "%@company.com")
 *     }
 *     .orderBy(Users.createdAt.desc())
 *     .limit(0, 10)
 *     .map { ... }
 *
 * // Insert 쿼리 예시
 * // 1. 단일 사용자 추가
 * database.insert(Users) {
 *     set(it.loginId, "user123")
 *     set(it.userName, "John Doe")
 *     set(it.email, "john@example.com")
 *     set(it.createdAt, LocalDateTime.now())
 *     set(it.lastUpdatedAt, LocalDateTime.now())
 * }
 *
 * // 2. 반환값을 받는 삽입
 * val insertedId = database.insertAndGenerateKey(Users) {
 *     set(it.loginId, "user123")
 *     set(it.userName, "John Doe")
 *     set(it.email, "john@example.com")
 *     set(it.createdAt, LocalDateTime.now())
 *     set(it.lastUpdatedAt, LocalDateTime.now())
 * } as Long
 *
 * // Update 쿼리 예시
 * // 1. 단일 필드 업데이트
 * database.update(Users) {
 *     set(it.userName, "New Name")
 *     set(it.lastUpdatedAt, LocalDateTime.now())
 *     where {
 *         it.id eq targetId
 *     }
 * }
 *
 * // 2. 조건부 다중 필드 업데이트
 * database.update(Users) {
 *     set(it.phoneNumber, "010-1234-5678")
 *     set(it.lastUpdatedAt, LocalDateTime.now())
 *     where {
 *         (it.email like "%@olddomain.com") and
 *         (it.phoneNumber.isNull())
 *     }
 * }
 *
 * // Delete 쿼리 예시
 * // 1. ID 기반 단일 삭제
 * database.delete(Users) { it.id eq targetId }
 *
 * // 2. 조건부 다중 삭제
 * database.delete(Users) {
 *     (it.lastUpdatedAt less LocalDateTime.now().minusYears(1)) and
 *     (it.email like "%@inactive.com")
 * }
 *
 * ```
 *
 * @see org.ktorm.schema.Table
 * @see org.ktorm.dsl.Query
 * @see <a href="https://www.ktorm.org/en/query.html">Ktorm</a>
 */
object Users : Table<Nothing>("USERS") {
    val id = long("ID").primaryKey()
    val loginId = varchar("LOGIN_ID")
    val userName = varchar("USER_NAME")
    val picture = varchar("PICTURE")
    val phoneNumber = varchar("PHONE_NUMBER")
    val mobilePhoneNumber = varchar("MOBILE_PHONE_NUMBER")
    val email = varchar("EMAIL")
    var createdAt = datetime("CREATED_AT")
    var lastUpdatedAt = datetime("LAST_UPDATED_AT")
}

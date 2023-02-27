package kr.ac.jbnu.ampm.ampmsiteapi.Entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.ac.jbnu.ampm.ampmsiteapi.DTO.MemberActivityDTO

class MemberActivityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var email: String,
    var studentNum: Long?,
    var bio: String,
    var interest: String,
    var status: Int?,
    var applyStatus : Int?
)

fun MemberActivityEntity.toDTO() = MemberActivityDTO(id, name, email, studentNum, bio, interest, status, applyStatus)
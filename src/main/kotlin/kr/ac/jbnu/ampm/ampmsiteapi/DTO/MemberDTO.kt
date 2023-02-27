package kr.ac.jbnu.ampm.ampmsiteapi.DTO

import kr.ac.jbnu.ampm.ampmsiteapi.Entity.MemberEntity

data class MemberDTO(
    var id: Long?,
    var name: String,
    var email: String,
    var studentNum: Long?,
    var bio: String,
    var interest: String,
    var status: Int?
)

fun MemberDTO.toEntity() = MemberEntity(id, name, email, studentNum, bio, interest, status)
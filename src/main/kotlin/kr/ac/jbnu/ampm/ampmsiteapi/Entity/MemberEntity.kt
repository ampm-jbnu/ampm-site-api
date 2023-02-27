package kr.ac.jbnu.ampm.ampmsiteapi.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.ac.jbnu.ampm.ampmsiteapi.DTO.MemberDTO
import lombok.Getter
import lombok.Setter

@Entity
@Getter
@Setter
class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var email: String,
    var studentNum: Long?,
    var bio: String,
    var interest: String,
    var status: Int?
)

fun MemberEntity.toDTO() = MemberDTO(id, name, email, studentNum, bio, interest, status)
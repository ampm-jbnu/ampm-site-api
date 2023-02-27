package kr.ac.jbnu.ampm.ampmsiteapi.Repo

import kr.ac.jbnu.ampm.ampmsiteapi.Entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MemberRepo : JpaRepository<MemberEntity, Long?> {
}
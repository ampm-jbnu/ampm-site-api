package kr.ac.jbnu.ampm.ampmsiteapi.Repo

import kr.ac.jbnu.ampm.ampmsiteapi.Entity.MemberActivityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberActivityRepo : JpaRepository<MemberActivityEntity, Long?> {
}
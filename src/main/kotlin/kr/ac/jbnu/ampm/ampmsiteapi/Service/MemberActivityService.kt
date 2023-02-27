package kr.ac.jbnu.ampm.ampmsiteapi.Service

import kr.ac.jbnu.ampm.ampmsiteapi.DTO.MemberActivityDTO
import kr.ac.jbnu.ampm.ampmsiteapi.DTO.toEntity
import kr.ac.jbnu.ampm.ampmsiteapi.Entity.toDTO
import kr.ac.jbnu.ampm.ampmsiteapi.Repo.MemberActivityRepo

class MemberActivityService(private val memberActivityRepository : MemberActivityRepo) {
    fun getAllMembers():List<MemberActivityDTO>{
        return memberActivityRepository.findAll().map{it.toDTO()}
    }
    fun getMemberById(id: Long) : MemberActivityDTO {
        val Member = memberActivityRepository.findById(id).orElseThrow{MemberNotFoundException()}
        return Member.toDTO()
    }
    fun createMember(memberDTO: MemberActivityDTO): MemberActivityDTO {
        val memberEntity = memberDTO.toEntity()
        val savedMemberEntity = memberActivityRepository.save(memberEntity)
        return savedMemberEntity.toDTO()
    }
    fun updateMemberByID(id:Long, memberDTO: MemberActivityDTO): MemberActivityDTO {
        val Member = memberActivityRepository.findById(id).orElseThrow{MemberNotFoundException()}
        Member.name = memberDTO.name
        Member.email = memberDTO.email
        Member.studentNum = memberDTO.studentNum
        Member.bio = memberDTO.bio
        Member.interest = memberDTO.interest
        Member.status = memberDTO.status
        Member.applyStatus = memberDTO.applyStatus
        val updatedEntity = memberActivityRepository.save(Member)
        return updatedEntity.toDTO()
    }
}

class MemberNotFoundException : RuntimeException("Member not found")
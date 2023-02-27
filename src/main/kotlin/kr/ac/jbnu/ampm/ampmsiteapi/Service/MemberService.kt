package kr.ac.jbnu.ampm.ampmsiteapi.Service

import kr.ac.jbnu.ampm.ampmsiteapi.DTO.MemberDTO
import kr.ac.jbnu.ampm.ampmsiteapi.DTO.toEntity
import kr.ac.jbnu.ampm.ampmsiteapi.Entity.toDTO
import kr.ac.jbnu.ampm.ampmsiteapi.Repo.MemberRepo

class MemberService(private var memberRepository : MemberRepo) {
    fun getAllMembers(): List<Unit> {
        return memberRepository.findAll().map{it.toDTO()}
    }
    fun getMemberById(id: Long) : MemberDTO{
        val Member = memberRepository.findById(id).orElseThrow{MemberNotFoundException()}
        return Member.toDTO()
    }
    fun createMember(memberDTO: MemberDTO): MemberDTO{
        val memberEntity = memberDTO.toEntity()
        val savedMemberEntity = memberRepository.save(memberEntity)
        return savedMemberEntity.toDTO()
    }
    fun updateMemberByID(id:Long, memberDTO: MemberDTO):MemberDTO{
        val Member = memberRepository.findById(id).orElseThrow{MemberNotFoundException()}
        Member.name = memberDTO.name
        Member.email = memberDTO.email
        Member.studentNum = memberDTO.studentNum
        Member.bio = memberDTO.bio
        Member.interest = memberDTO.interest
        Member.status = memberDTO.status
        val updatedEntity = memberRepository.save(Member)
        return updatedEntity.toDTO()
    }
}
package com.example.study.service;

import com.example.study.model.Member;
import com.example.study.model.MemberCreateRequest;
import com.example.study.model.MemberUpdateRequest;
import com.example.study.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(MemberCreateRequest request) {
        Member member = Member.toEntity(request);
        return memberRepository.save(member); // 저장 및 반환
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    public List<Member> findAllMember() {
//        List<Member> allMember = memberRepository.findAll();
        return memberRepository.findAll();
    }

    public void updateMember(Long memberId, MemberUpdateRequest request) {
        // 1. 회원을 찾는다 (memberId로)
        Member member = memberRepository.findById(memberId).get();

        // 2. 찾은 회원의 이름을 변경한다 (request.getName())
        member.updateName(request.getName());

        // 3. 변경된 내용을 db에 저장한다
        // JPA에서 SAVE() 함수는 데이터가 존재하면 업데이트하고, 존재하지 않으면 데이터 삽입
        memberRepository.save(member);
    }

    public void deleteMember(Long memberId) {
//        1. 회원을 찾는다 (memberId로)
        Member member = memberRepository.findById(memberId).get();
//        2. 회원을 삭제한다
        memberRepository.delete(member);
    }

    public void deleteAllMember() {
        memberRepository.deleteAll();
    }

}

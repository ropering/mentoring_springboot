package com.example.study.controller;

import com.example.study.model.Member;
import com.example.study.model.MemberCreateRequest;
import com.example.study.model.MemberUpdateRequest;
import com.example.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 필요한 생성자를 자동으로 만들어줌
@RestController
public class MemberController {
    /*
    Controller - Service - Respository
    * */

    private final MemberService memberService;
    /**
     * 회원 생성 API
     * [POST] /api/members
     * @return
    // 500 번대 : Server 에러
    // 400 번대 : client 에러
     */
    // 회원 생성에 대한 코드
    @PostMapping("/api/members")
    public ResponseEntity<Member> createMember(@RequestBody MemberCreateRequest request) {
        Member createMember = memberService.createMember(request); // member 생성 //컨트롤러 -> 서비스로 넘겨줌
        return new ResponseEntity<>(createMember, HttpStatus.OK); // 200
    }


    /**
     * 특정 회원 조회 API
     * [GET] /api/members/{memberId}
     * @return
     */
    @GetMapping("/api/members/{memberId}")
    public ResponseEntity<Member> findMember(@PathVariable Long memberId) {
        Member findMember = memberService.findMember(memberId); // member 생성 //컨트롤러 -> 서비스로 넘겨줌
        return new ResponseEntity<>(findMember, HttpStatus.OK); // 200
    }


    /**
     * 전체 회원 조회 API
     * [GET] /api/members
     * @return
     */
    @GetMapping("/api/members")
    public ResponseEntity<List<Member>> findAllMember() {
        List<Member> allMember = memberService.findAllMember();
        return new ResponseEntity<>(allMember, HttpStatus.OK);
    }
//    부분 삭제
    @DeleteMapping("/api/members/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(memberId + "번 회원이 정상적으로 삭제되었습니다" , HttpStatus.OK);
    }
//  전체 삭제
    @DeleteMapping("/api/members")
    public ResponseEntity<String> deleteAllMember() {
        memberService.deleteAllMember();
        return new ResponseEntity<>("모든게 삭제되었습니다", HttpStatus.OK);
    }

    /**
     * 회원 수정 API
     * Patch : 부분 수정
     * PUT : 덮어쓰기
     * [PATCH] /api/members/{memberId}
     * @param memberId
     * @return
     */
    @PatchMapping("/api/members/{memberId}")
    public ResponseEntity<String> updateMember(
            @PathVariable Long memberId, @RequestBody MemberUpdateRequest request) {
        memberService.updateMember(memberId, request);
        return new ResponseEntity<>( memberId + "번 회원 이름이 정상적으로 수정되었습니다.", HttpStatus.OK);

    }


    /**
     * 특정 회원 삭제 API
     * [DELETE] /api/members/{memberId}
     * @param memberId
     * @return
     */



    /**
     * 전체 회원 삭제 API
     * [DELETE] /api/members
     * @param memberId
     * @return
     */

}
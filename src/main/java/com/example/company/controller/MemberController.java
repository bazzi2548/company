package com.example.company.controller;

import com.example.company.domain.Member;
import com.example.company.dto.request.MemberRequest;
import com.example.company.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/member")
    public void saveMember(@RequestBody MemberRequest request) {
        memberService.saveMember(request);
    }

    @GetMapping("/api/member")
    public List<Member> getTeam(){
        return memberService.getTeam();
    }
}

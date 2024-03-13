package com.example.company.controller;

import com.example.company.dto.request.member.MemberRequest;
import com.example.company.dto.response.member.MemberInfoResponse;
import com.example.company.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TemporalAdjusters키워드

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
    public List<MemberInfoResponse> getTeam(){
        return memberService.getTeam();
    }
}

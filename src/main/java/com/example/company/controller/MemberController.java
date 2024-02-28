package com.example.company.controller;

import com.example.company.dto.request.MemberRequest;
import com.example.company.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/member")
    public void saveMember(@RequestBody MemberRequest request){
        memberService.saveMember(request);
    }

}

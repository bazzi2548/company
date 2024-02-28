package com.example.company.service;

import com.example.company.domain.Member;
import com.example.company.dto.request.MemberRequest;
import com.example.company.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void saveMember(MemberRequest request) {
        memberRepository.save(new Member(request));
    }
}

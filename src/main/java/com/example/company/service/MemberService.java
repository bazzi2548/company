package com.example.company.service;

import com.example.company.domain.Member;
import com.example.company.domain.Team;
import com.example.company.dto.request.member.MemberRequest;
import com.example.company.dto.response.member.MemberInfoResponse;
import com.example.company.repository.MemberRepository;
import com.example.company.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveMember(MemberRequest request) {
        if (request.getTeamName() != null && !(request.getTeamName().isEmpty())) {
            Team team = teamRepository.findByName(request.getTeamName());
            team.setMemberCount();
        }
        memberRepository.save(new Member(request));
    }

    public List<MemberInfoResponse> getTeam() {
        return memberRepository.findAll()
                .stream()
                .map(MemberInfoResponse::new)
                .collect(Collectors.toList());
    }
}

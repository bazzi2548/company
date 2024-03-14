package com.example.company.dto.response.member;

import com.example.company.domain.Member;
import com.example.company.domain.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberInfoResponse {
    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthDay;
    private LocalDate workStartDate;

    public MemberInfoResponse(Member member) {
        this.name = member.getName();
        this.teamName = member.getTeam().getName();
        this.role = member.getRole();
        this.birthDay = member.getBirthday();
        this.workStartDate = member.getWorkStartDate();
    }
}

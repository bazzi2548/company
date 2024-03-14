package com.example.company.dto.request.member;

import com.example.company.domain.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberRequest {

    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;

}

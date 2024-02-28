package com.example.company.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberRequest {

    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

}

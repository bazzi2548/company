package com.example.company.domain;

import com.example.company.dto.request.MemberRequest;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30)
    private String teamName;
    @Column(length = 30, nullable = false)
    private String role;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private LocalDate workStartDate;

    protected Member() {
    }

    public Member(MemberRequest request) {
        name = request.getName();

        if (request.getTeamName() == null || request.getTeamName().isBlank()) {
            teamName = null;
        } else {
            teamName = request.getTeamName();
        }

        if (request.getRole().equals("MEMBER") || request.getRole().equals("MANAGER")) {
            role = request.getRole();
        } else {
            System.out.println(request.getRole());
            throw new IllegalArgumentException();
        }

        birthday = request.getBirthday();
        workStartDate = request.getWorkStartDate();
    }

}

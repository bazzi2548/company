package com.example.company.domain;

import com.example.company.dto.request.member.MemberRequest;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30)
    private String teamName;
    @Column(length = 30, nullable = false)
    private String role; // Enum으로 Role 만들기(확장에 유연), @Enumerated 공부
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private LocalDate workStartDate;
    @OneToMany(mappedBy = "member")
    private List<Attendance> attendances = new ArrayList<>();

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

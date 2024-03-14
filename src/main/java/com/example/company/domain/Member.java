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

    @ManyToOne(fetch = FetchType.LAZY)
    private Team teamId;

    @Column(length = 30, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;
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

        if (request.getRole() == Role.MEMBER || request.getRole() == Role.MANAGER) {
            role = request.getRole();
        } else {
            throw new IllegalArgumentException();
        }

        birthday = request.getBirthday();
        workStartDate = request.getWorkStartDate();
    }

    public void setTeam(Team team){
        this.teamId = team;
        team.getMembers().add(this);
        team.setMemberCount();
    }
}

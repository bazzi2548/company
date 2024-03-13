package com.example.company.domain;

import com.example.company.dto.request.team.TeamRequest;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30)
    private String manager;

    private int memberCount;

    protected Team() {
    }

    public Team(TeamRequest request) {
        name = request.getName();
        if (request.getManager() == null || request.getManager().isBlank()) {
            manager = null;
        } else {
            manager = request.getManager();
        }
        memberCount = 0;
    }

    public void setMemberCount() {
        this.memberCount++;
    }
}

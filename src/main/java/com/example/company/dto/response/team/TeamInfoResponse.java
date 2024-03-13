package com.example.company.dto.response.team;

import com.example.company.domain.Team;
import lombok.Getter;

@Getter
public class TeamInfoResponse {

    private String name;
    private String manager;
    private int memberCount;

    public TeamInfoResponse(Team team) {
        this.name = team.getName();
        this.manager = team.getManager();
        this.memberCount = team.getMemberCount();
    }
}

package com.example.company.controller;

import com.example.company.domain.Team;
import com.example.company.dto.request.team.TeamRequest;
import com.example.company.dto.response.team.TeamInfoResponse;
import com.example.company.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/api/team")
    public void saveTeam(@RequestBody TeamRequest request) {
        teamService.saveTeam(request);
    }

    @GetMapping("/api/team") // 엔티티를 직접 반환받는건 위험, DTO를 써서 리스트 받아보자
    public List<TeamInfoResponse> getTeam() {
        return teamService.getTeam();
    }
}

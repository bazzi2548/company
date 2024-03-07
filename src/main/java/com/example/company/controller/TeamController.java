package com.example.company.controller;

import com.example.company.domain.Team;
import com.example.company.dto.request.TeamRequest;
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

    @GetMapping("/api/team")
    public List<Team> getTeam() {
        return teamService.getTeam();
    }
}

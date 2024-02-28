package com.example.company.controller;

import com.example.company.dto.request.TeamRequest;
import com.example.company.service.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

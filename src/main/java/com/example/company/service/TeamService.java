package com.example.company.service;

import com.example.company.domain.Team;
import com.example.company.dto.request.TeamRequest;
import com.example.company.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeam(TeamRequest request) {
        teamRepository.save(new Team(request));
    }
}

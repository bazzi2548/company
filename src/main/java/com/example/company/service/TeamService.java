package com.example.company.service;

import com.example.company.domain.Team;
import com.example.company.dto.request.team.TeamRequest;
import com.example.company.dto.response.team.TeamInfoResponse;
import com.example.company.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeam(TeamRequest request) {
        teamRepository.save(new Team(request));
    }

    public List<TeamInfoResponse> getTeam() {
        return teamRepository.findAll()
                .stream()
                .map(TeamInfoResponse::new)
                .collect(Collectors.toList());
    }
}

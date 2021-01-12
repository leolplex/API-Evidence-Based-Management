package com.ebm.domain.service;

import com.ebm.domain.Team;
import com.ebm.domain.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private final TeamRepository teamRepository;

    TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    public Optional<Team> getTeamById(int idTeam) {
        return teamRepository.getTeamById(idTeam);
    }

    public List<Team> getTeamsByIdUser(int idUser) {
        return teamRepository.getTeamsByIdUser(idUser);
    }

}

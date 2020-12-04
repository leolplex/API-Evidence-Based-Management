package com.ebm.domain.service;

import com.ebm.domain.TeamDomain;
import com.ebm.domain.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private final TeamRepository teamRepository;

    TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDomain> getAll() {
        return teamRepository.getAll();
    }

}

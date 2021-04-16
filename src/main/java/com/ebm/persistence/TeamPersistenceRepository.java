package com.ebm.persistence;

import com.ebm.domain.Team;
import com.ebm.domain.repository.TeamRepository;
import com.ebm.persistence.crud.TeamCrudRepository;
import com.ebm.persistence.entity.EntityTeam;
import com.ebm.persistence.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamPersistenceRepository implements TeamRepository {
    @Autowired
    private TeamCrudRepository teamCrudRepository;
    @Autowired
    private TeamMapper mapper;

    TeamPersistenceRepository(TeamCrudRepository teamCrudRepository, TeamMapper teamMapper) {
        this.teamCrudRepository = teamCrudRepository;
        this.mapper = teamMapper;
    }

    @Override
    public List<Team> getAll() {
        List<EntityTeam> teams = (List<EntityTeam>) teamCrudRepository.findAll();
        return mapper.toTeams(teams);
    }

    @Override
    public Optional<Team> getTeamById(int idTeam) {
        return teamCrudRepository.findById(idTeam).map(team -> mapper.toTeam(team));
    }

    @Override
    public List<Team> getTeamsByIdUser(int idUser) {
        return mapper.toTeams(teamCrudRepository.findByEntityIdUser(idUser));
    }

    @Override
    public Team save(Team teamDomain) {
        EntityTeam team = mapper.toTeamDomain(teamDomain);
        return mapper.toTeam(teamCrudRepository.save(team));
    }

}

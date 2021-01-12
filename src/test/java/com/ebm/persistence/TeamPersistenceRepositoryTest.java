package com.ebm.persistence;

import com.ebm.domain.Team;
import com.ebm.persistence.crud.TeamCrudRepository;
import com.ebm.persistence.entity.EntityTeam;
import com.ebm.persistence.mapper.TeamMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TeamPersistenceRepositoryTest {
    TeamPersistenceRepository tester;
    TeamCrudRepository teamCrudRepository;
    TeamMapper mapper;

    @BeforeEach
    void initEach() {
        teamCrudRepository = Mockito.mock(TeamCrudRepository.class);
        mapper = Mockito.mock(TeamMapper.class);
        tester = new TeamPersistenceRepository(teamCrudRepository, mapper);
    }

    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Team> teamsDomain = new ArrayList<>();
        Team team = new Team();
        teamsDomain.add(team);

        List<EntityTeam> iterations = new ArrayList<>();
        EntityTeam iteration = new EntityTeam();
        iterations.add(iteration);

        when(teamCrudRepository.findAll()).thenReturn(iterations);
        when(mapper.toTeams(iterations)).thenReturn(teamsDomain);


        List<Team> teamsResult = tester.getAll();
        assertEquals(1, teamsResult.size(), "getAll must have a team");
        assertEquals(team, teamsResult.toArray()[0], "getAll must have a team equal to object defined");
    }


    @Test
    void TestGetTeamByIdWithOutData() {
        int idTea = 2;
        assertEquals(Optional.empty(), tester.getTeamById(idTea), "getTeamById must be Optional.empty()");
    }

    @Test
    void TestGetTeamByIdWithData() {
        int idTeam = 2;
        Optional<EntityTeam> myEntityTeamOptional = Optional.of(new EntityTeam());
        Optional<Team> myTeam = Optional.of(new Team());

        when(teamCrudRepository.findById(idTeam)).thenReturn(myEntityTeamOptional);
        when(mapper.toTeam(myEntityTeamOptional.get())).thenReturn(myTeam.get());

        // Act
        Optional<Team> result = tester.getTeamById(idTeam);


        assertEquals(myTeam, result, "getTeamById must be Optional.of(new Team())");
    }


    @Test
    void TestGetTeamsByIdUserWithOutData() {
        assertEquals(new ArrayList<>(), tester.getTeamsByIdUser(1), "getTeamsByIdUser must be []");
    }


    @Test
    void TestGetTeamsByIdUseWithData() {
        List<Team> teamsDomain = new ArrayList<>();
        Team team = new Team();
        teamsDomain.add(team);

        List<EntityTeam> iterations = new ArrayList<>();
        EntityTeam iteration = new EntityTeam();
        iterations.add(iteration);

        when(teamCrudRepository.findByEntityIdUser(1)).thenReturn(iterations);
        when(mapper.toTeams(iterations)).thenReturn(teamsDomain);


        List<Team> teamsResult = tester.getTeamsByIdUser(1);
        assertEquals(1, teamsResult.size(), "getTeamsByIdUser must have a team");
        assertEquals(team, teamsResult.toArray()[0], "getTeamsByIdUser must have a team equal to object defined");
    }

}

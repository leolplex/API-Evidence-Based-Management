package com.ebm.persistence;

import com.ebm.domain.TeamDomain;
import com.ebm.persistence.crud.TeamCrudRepository;
import com.ebm.persistence.entity.EntityTeam;
import com.ebm.persistence.mapper.TeamMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
    void TestGetAllWithData(){
        List<TeamDomain> teamsDomain = new ArrayList<>();
        TeamDomain teamDomain = new TeamDomain();
        teamsDomain.add(teamDomain);

        List<EntityTeam>  iterations = new ArrayList<>();
        EntityTeam iteration = new EntityTeam();
        iterations.add(iteration);

        when(teamCrudRepository.findAll()).thenReturn(iterations);
        when(mapper.toTeams(iterations)).thenReturn(teamsDomain);


        List<TeamDomain> teamsResult = tester.getAll();
        assertEquals(1, teamsResult.size(), "getAll must have a team");
        assertEquals(teamDomain, teamsResult.toArray()[0], "getAll must have a team equal to object defined");
    }

}

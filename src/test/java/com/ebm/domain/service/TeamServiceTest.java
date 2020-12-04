package com.ebm.domain.service;

import com.ebm.domain.TeamDomain;
import com.ebm.domain.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TeamServiceTest {
    TeamService tester;
    TeamRepository teamRepository;

    @BeforeEach
    void initEach() {
        teamRepository = Mockito.mock(TeamRepository.class);
        tester = new TeamService(teamRepository);
    }

    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void  TestGetAllWithData(){
        List<TeamDomain> teams = new ArrayList<>();
        TeamDomain team = new TeamDomain();
        teams.add(team);

        when(teamRepository.getAll()).thenReturn(teams);

        List<TeamDomain> teamsResult = tester.getAll();
        assertEquals(1, teamsResult.size(), "getAll must have a team");
        assertEquals(team, teamsResult.toArray()[0], "getAll must have a team equal to object defined");
    }
}

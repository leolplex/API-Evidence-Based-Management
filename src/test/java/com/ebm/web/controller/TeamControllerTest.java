package com.ebm.web.controller;

import com.ebm.domain.Team;
import com.ebm.domain.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TeamControllerTest {
    TeamController tester;
    TeamService teamService;

    @BeforeEach()
    void initEach() {
        teamService = Mockito.mock(TeamService.class);
        tester = new TeamController(teamService);
    }

    @Test
    void TestGetAllWithoutData() {
        assertEquals(new ResponseEntity<>(new ArrayList<Team>(), HttpStatus.OK), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Team> teams = new ArrayList<>();
        Team team = new Team();
        teams.add(team);

        when(teamService.getAll()).thenReturn(teams);

        assertEquals(new ResponseEntity<>(teams, HttpStatus.OK), tester.getAll(), "getAll must be new ResponseEntity with a value");
    }
}

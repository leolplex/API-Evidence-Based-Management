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
import java.util.Optional;

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


    @Test
    void TestGetTeamByIdWithoutData() {
        int idTeam = 2;
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.getTeamById(idTeam), "getTeamById must be <404 NOT_FOUND Not Found,[]>");
    }


    @Test
    void TestGetTeamByIdWitData() {
        int idTeam = 2;
        Optional<Team> optionalTeam = Optional.of(new Team());


        when(teamService.getTeamById(idTeam)).thenReturn(optionalTeam);

        assertEquals(new ResponseEntity<>(optionalTeam.get(), HttpStatus.OK), tester.getTeamById(idTeam), "getTeamById must be new ResponseEntity with a value and status Ok");
    }

    @Test
    void TestGetTeamsByIdUserWithoutData() {
        assertEquals(new ResponseEntity<>(new ArrayList<Team>(), HttpStatus.OK), tester.getTeamsByIdUser(1), "getTeamsByIdUser must be []");
    }

    @Test
    void TestGetTeamsByIdUserWithData() {
        List<Team> teams = new ArrayList<>();
        Team team = new Team();
        teams.add(team);

        when(teamService.getTeamsByIdUser(1)).thenReturn(teams);

        assertEquals(new ResponseEntity<>(teams, HttpStatus.OK), tester.getTeamsByIdUser(1), "getTeamsByIdUser must be new ResponseEntity with a value");
    }

    @Test
    void TestSaveNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new Team()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Team team = new Team();
        when(teamService.save(team)).thenReturn(team);

        assertEquals(new ResponseEntity<>(team, HttpStatus.CREATED), tester.save(team), "save must be new instance Team");
    }

}

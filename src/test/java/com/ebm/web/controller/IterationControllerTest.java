package com.ebm.web.controller;

import com.ebm.domain.Iteration;
import com.ebm.domain.service.IterationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class IterationControllerTest {
    IterationController tester;
    IterationService iterationService;

    private Iteration getIteration() {
        Iteration iteration = new Iteration();
        iteration.setState("In Progress");
        iteration.setEndDate(LocalDateTime.now());
        iteration.setStartDate(LocalDateTime.now());
        iteration.setGoal("Less rate of bureaucracy");
        iteration.setId(190);
        return iteration;
    }

    @BeforeEach()
    void initEach() {
        iterationService = Mockito.mock(IterationService.class);
        tester = new IterationController(iterationService);
    }

    @Test
    void TestGetAllWithoutData() {
        assertEquals(new ResponseEntity<>(new ArrayList<Iteration>(), HttpStatus.OK), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = getIteration();
        iterations.add(iteration);

        when(iterationService.getAll()).thenReturn(iterations);

        assertEquals(new ResponseEntity<>(iterations, HttpStatus.OK), tester.getAll(), "getAll must be new ResponseEntity with a value");
    }

    @Test
    void TestGetByTeamWithoutData() {
        assertEquals(new ResponseEntity<>(new ArrayList<Iteration>(), HttpStatus.OK), tester.getByTeam(1), "getAll must be []");
    }

    @Test
    void TestGetByTeamWithData() {
        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = getIteration();
        iterations.add(iteration);

        when(iterationService.getByTeam(1)).thenReturn(iterations);

        assertEquals(new ResponseEntity<>(iterations, HttpStatus.OK), tester.getByTeam(1), "getByTeam must be new ResponseEntity with a value");
    }

    @Test
    void TestSaveNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new Iteration()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Iteration iteration = new Iteration();
        when(iterationService.save(iteration)).thenReturn(iteration);

        assertEquals(new ResponseEntity<>(iteration,HttpStatus.CREATED), tester.save(iteration), "save must be new instance Iteration");
    }

}

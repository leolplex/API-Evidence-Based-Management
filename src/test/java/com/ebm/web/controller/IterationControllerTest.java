package com.ebm.web.controller;

import com.ebm.domain.IterationDomain;
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

    private IterationDomain getIteration() {
        IterationDomain iteration = new IterationDomain();
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
        assertEquals(new ResponseEntity<>(new ArrayList<IterationDomain>(), HttpStatus.OK), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<IterationDomain> iterations = new ArrayList<>();
        IterationDomain iteration = getIteration();
        iterations.add(iteration);

        when(iterationService.getAll()).thenReturn(iterations);

        assertEquals(new ResponseEntity<>(iterations, HttpStatus.OK), tester.getAll(), "getAll must be new ResponseEntity with a value");
    }

    @Test
    void TestGetByTeamWithoutData() {
        assertEquals(new ResponseEntity<>(new ArrayList<IterationDomain>(), HttpStatus.OK), tester.getByTeam(1), "getAll must be []");
    }

    @Test
    void TestGetByTeamWithData() {
        List<IterationDomain> iterations = new ArrayList<>();
        IterationDomain iteration = getIteration();
        iterations.add(iteration);

        when(iterationService.getByTeam(1)).thenReturn(iterations);

        assertEquals(new ResponseEntity<>(iterations, HttpStatus.OK), tester.getByTeam(1), "getByTeam must be new ResponseEntity with a value");
    }

    @Test
    void TestSaveNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new IterationDomain()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        IterationDomain iterationDomain = new IterationDomain();
        when(iterationService.save(iterationDomain)).thenReturn(iterationDomain);

        assertEquals(new ResponseEntity<>(iterationDomain,HttpStatus.CREATED), tester.save(iterationDomain), "save must be new instance Iteration");
    }

}

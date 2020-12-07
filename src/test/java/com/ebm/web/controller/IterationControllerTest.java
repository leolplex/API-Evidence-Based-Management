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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class IterationControllerTest {
    IterationController tester;
    IterationService iterationService;



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
        Iteration iteration = new Iteration();
        iterations.add(iteration);

        when(iterationService.getAll()).thenReturn(iterations);

        assertEquals(new ResponseEntity<>(iterations, HttpStatus.OK), tester.getAll(), "getAll must be new ResponseEntity with a value");
    }

    @Test
    void TestGetByTeamWithoutData() {
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.getIterationById(1), "getIterationById must be HttpStatus.NOT_FOUND");
    }

    @Test
    void TestGetByTeamWithData() {
        Optional<Iteration> iterations = Optional.of(new Iteration());

        when(iterationService.getIterationById(1)).thenReturn(iterations);

        assertEquals(new ResponseEntity<>(iterations.get(), HttpStatus.OK), tester.getIterationById(1), "getIterationById must be new ResponseEntity with a value");
    }

    @Test
    void TestSaveNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new Iteration()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Iteration iteration = new Iteration();
        when(iterationService.save(iteration)).thenReturn(iteration);

        assertEquals(new ResponseEntity<>(iteration, HttpStatus.CREATED), tester.save(iteration), "save must be new instance Iteration");
    }

}

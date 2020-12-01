package com.ebm.domain.service;

import com.ebm.domain.repository.IterationRepository;
import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.Iteration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IterationServiceTest {
    IterationService tester;
    IterationRepository iterationRepository;

    private Iteration getIteration() {
        Iteration iteration = new Iteration();
        iteration.setState("In Progress");
        iteration.setEndDate(LocalDateTime.now());
        iteration.setStartDate(LocalDateTime.now());
        iteration.setGoal("Less rate of bureaucracy");
        iteration.setId(190);
        return iteration;
    }

    @BeforeEach
    void initEach() {
        iterationRepository = Mockito.mock(IterationRepository.class);
        tester = new IterationService(iterationRepository);
    }
    @Test
    void TestGetAllWithOutData(){
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = getIteration();
        iterations.add(iteration);
        when(iterationRepository.getAll()).thenReturn(iterations);

        List<Iteration> iterationsResult = tester.getAll();

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iteration, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }
}

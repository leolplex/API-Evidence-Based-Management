package com.ebm.domain.service;

import com.ebm.domain.IterationDomain;
import com.ebm.domain.repository.IterationRepository;
import com.ebm.persistence.entity.Iteration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class IterationServiceTest {
    IterationService tester;
    IterationRepository iterationRepository;

    private IterationDomain getIteration() {
        IterationDomain iteration = new IterationDomain();
        iteration.setStateDomain("In Progress");
        iteration.setEndDateDomain(LocalDateTime.now());
        iteration.setStartDateDomain(LocalDateTime.now());
        iteration.setGoalDomain("Less rate of bureaucracy");
        iteration.setIdDomain(190);
        return iteration;
    }

    @BeforeEach
    void initEach() {
        iterationRepository = Mockito.mock(IterationRepository.class);
        tester = new IterationService(iterationRepository);
    }

    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<IterationDomain> iterations = new ArrayList<>();
        IterationDomain iteration = getIteration();
        iterations.add(iteration);
        when(iterationRepository.getAll()).thenReturn(iterations);

        List<IterationDomain> iterationsResult = tester.getAll();

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iteration, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }


    @Test
    void TestGetByTeamWithOutData() {
        assertEquals(new ArrayList<>(), tester.getByTeam(1), "getByTeam must be []");
    }

    @Test
    void TestGetByTeamWithData() {
        List<IterationDomain> iterations = new ArrayList<>();
        IterationDomain iteration = getIteration();
        iterations.add(iteration);
        when(iterationRepository.getByIdTeam(1)).thenReturn(iterations);

        List<IterationDomain> iterationsResult = tester.getByTeam(1);

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iteration, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }
}

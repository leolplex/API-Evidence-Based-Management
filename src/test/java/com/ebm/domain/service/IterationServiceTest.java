package com.ebm.domain.service;

import com.ebm.domain.Iteration;
import com.ebm.domain.repository.IterationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class IterationServiceTest {
    IterationService tester;
    IterationRepository iterationRepository;


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
        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = new Iteration();
        iterations.add(iteration);
        when(iterationRepository.getAll()).thenReturn(iterations);

        List<Iteration> iterationsResult = tester.getAll();

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iteration, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }


    @Test
    void TestGetIterationByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getIterationById(1), "getByTeam must be Optional.empty()");
    }

    @Test
    void TestGetIterationByIdmWithData() {
        Optional<Iteration> iterations = Optional.of(new Iteration());
        when(iterationRepository.getIterationById(1)).thenReturn(iterations);

        Optional<Iteration> iterationsResult = tester.getIterationById(1);

        assertEquals(iterations, iterationsResult, "getAll must have an iteration");
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new Iteration()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Iteration iteration = new Iteration();
        when(iterationRepository.save(iteration)).thenReturn(iteration);

        assertEquals(iteration, tester.save(iteration), "save must be new instance Iteration");
    }
}

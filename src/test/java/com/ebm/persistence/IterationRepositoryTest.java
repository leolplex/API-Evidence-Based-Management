package com.ebm.persistence;

import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.Iteration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class IterationRepositoryTest {
    IterationRepository tester;
    IterationCrudRepository iterationCrudRepository;

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
        iterationCrudRepository = Mockito.mock(IterationCrudRepository.class);
        tester = new IterationRepository(iterationCrudRepository);
    }

    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = getIteration();
        iterations.add(iteration);
        when(iterationCrudRepository.findAll()).thenReturn(iterations);

        List<Iteration> iterationsResult = tester.getAll();

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iteration, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }

    @Test
    void TestGetByIdTeamWithOutData() {
        assertEquals(new ArrayList<>(), tester.getByIdTeam(0), "getByIdTeam must be []");
    }

    @Test
    void TestGetByIdTeamWithData() {
        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = getIteration();
        iterations.add(iteration);
        when(iterationCrudRepository.getByIdTeam(1)).thenReturn(iterations);

        List<Iteration> iterationsResult = tester.getByIdTeam(1);

        assertEquals(1, iterationsResult.size(), "getByIdTeam must have an iteration");
        assertEquals(iteration, iterationsResult.toArray()[0], "getByIdTeam must have an iteration equal to object defined");

    }


    @Test
    void TestSaveNull() {
        Iteration iteration = getIteration();
        assertNull(tester.save(iteration), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Iteration iteration = getIteration();
        when(iterationCrudRepository.save(iteration)).thenReturn(iteration);
        assertEquals(iteration, tester.save(iteration), "save must be new instance Iteration");
    }

    @Test
    void TestDelete() {
        boolean result = tester.delete(1);
        assertTrue(result, "delete must be true");
    }

    @Test
    void TestDeleteError() {
        doThrow(NullPointerException.class)
                .when(iterationCrudRepository)
                .deleteById(1);
        boolean result = tester.delete(1);
        assertFalse(result, "delete must be false");
    }

}

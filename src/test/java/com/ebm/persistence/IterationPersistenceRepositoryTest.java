package com.ebm.persistence;

import com.ebm.domain.IterationDomain;
import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.Iteration;
import com.ebm.persistence.mapper.IterationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class IterationPersistenceRepositoryTest {
    IterationPersistenceRepository tester;
    IterationCrudRepository iterationCrudRepository;
    IterationMapper mapper;

    private Iteration getIteration() {
        Iteration iteration = new Iteration();
        iteration.setState("In Progress");
        iteration.setEndDate(LocalDateTime.now());
        iteration.setStartDate(LocalDateTime.now());
        iteration.setGoal("Less rate of bureaucracy");
        iteration.setId(190);
        return iteration;
    }


    private IterationDomain getIterationDomain() {
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
        iterationCrudRepository = Mockito.mock(IterationCrudRepository.class);
        mapper = Mockito.mock(IterationMapper.class);
        tester = new IterationPersistenceRepository(iterationCrudRepository, mapper);
    }

    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<IterationDomain> iterationsDomain = new ArrayList<>();
        IterationDomain iterationDomain = getIterationDomain();
        iterationsDomain.add(iterationDomain);

        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = getIteration();
        iterations.add(iteration);

        when(iterationCrudRepository.findAll()).thenReturn(iterations);
        when(mapper.toIterations(iterations)).thenReturn(iterationsDomain);

        List<IterationDomain> iterationsResult = tester.getAll();

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iterationDomain, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }

    @Test
    void TestGetByIdTeamWithOutData() {
        assertEquals(new ArrayList<>(), tester.getByIdTeam(0), "getByIdTeam must be []");
    }

    @Test
    void TestGetByIdTeamWithData() {
        List<IterationDomain> iterationsDomain = new ArrayList<>();
        IterationDomain iterationDomain = getIterationDomain();
        iterationsDomain.add(iterationDomain);

        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = getIteration();
        iterations.add(iteration);
        when(iterationCrudRepository.getByIdTeam(1)).thenReturn(iterations);
        when(mapper.toIterations(iterations)).thenReturn(iterationsDomain);

        List<IterationDomain> iterationsResult = tester.getByIdTeam(1);

        assertEquals(1, iterationsResult.size(), "getByIdTeam must have an iteration");
        assertEquals(iterationDomain, iterationsResult.toArray()[0], "getByIdTeam must have an iteration equal to object defined");

    }


    @Test
    void TestSaveNull() {
        assertNull(tester.save(new IterationDomain()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Iteration iteration = getIteration();
        IterationDomain iterationDomain = new IterationDomain();
        when(mapper.toIterationDomain(iterationDomain)).thenReturn(iteration);
        when(mapper.toIteration(iteration)).thenReturn(iterationDomain);

        when(iterationCrudRepository.save(iteration)).thenReturn(iteration);
        assertEquals(iterationDomain, tester.save(iterationDomain), "save must be new instance Iteration");
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

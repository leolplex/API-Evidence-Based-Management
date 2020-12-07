package com.ebm.persistence;

import com.ebm.domain.Iteration;
import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.EntityIteration;
import com.ebm.persistence.mapper.IterationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class IterationPersistenceRepositoryTest {
    IterationPersistenceRepository tester;
    IterationCrudRepository iterationCrudRepository;
    IterationMapper mapper;


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
        List<Iteration> iterationsDomain = new ArrayList<>();
        Iteration iterationDomain = new Iteration();
        iterationsDomain.add(iterationDomain);

        List<EntityIteration> iterations = new ArrayList<>();
        EntityIteration iteration = new EntityIteration();
        iterations.add(iteration);

        when(iterationCrudRepository.findAll()).thenReturn(iterations);
        when(mapper.toIterations(iterations)).thenReturn(iterationsDomain);

        List<Iteration> iterationsResult = tester.getAll();

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iterationDomain, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }

    @Test
    void TestGetByIdTeamWithOutData() {
        assertEquals(Optional.empty(), tester.getIterationById(0), "getByIdTeam must be Optional.empty()");
    }

    @Test
    void TestGetByIdTeamWithData() {

        Optional<Iteration> iterationDomain = Optional.of(new Iteration());
        Optional<EntityIteration> iterations = Optional.of(new EntityIteration());
        when(iterationCrudRepository.findById(1)).thenReturn(iterations);
        when(mapper.toIteration(iterations.get())).thenReturn(iterationDomain.get());

        Optional<Iteration> iterationsResult = tester.getIterationById(1);

        assertEquals(iterationDomain, iterationsResult, "getIterationById must be Optional.of(new EntityIteration())");

    }


    @Test
    void TestSaveNull() {
        assertNull(tester.save(new Iteration()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        EntityIteration iteration = new EntityIteration();
        Iteration iterationDomain = new Iteration();
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

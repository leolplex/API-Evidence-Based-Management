package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class IterationTest {
    Iteration tester;

    @BeforeEach
    void initEach() {
        tester = new Iteration();
    }

    @Test
    void TestInstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getId(),"getIdIteration must be null");
        assertNull(tester.getGoal(),"getGoal must be null");
        assertNull(tester.getStartDate(),"getStartDate must be null");
        assertNull(tester.getEndDate(),"getEndDate must be null");
        assertNull(tester.getState(),"getState must be null");
        assertNull(tester.getKva(),"getKva must be null");
        assertNull(tester.getIdTeam(),"getIdTeam must be null");
    }

    @Test
    void  getAndSetId(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setId(id);
        final Integer getId = tester.getId();

        // Assert
        assertEquals(id, getId, "setId must be my 42");
    }

    @Test
    void  getAndSetName(){
        // Arrange
        final String name = "Iteration 1";

        //Act
        tester.setName(name);
        final String getName = tester.getName();

        // Assert
        assertEquals(name, getName, "setName must be my Iteration 1");
    }

    @Test
    void  getAndSetGoal(){
        // Arrange
        final String goal = "Set up deployment pipeline & release an empty site to production";

        //Act
        tester.setGoal(goal);
        final String getGoal = tester.getGoal();

        // Assert
        assertEquals(goal, getGoal, "setGoal must be my Set up deployment pipeline & release an empty site to production");
    }

    @Test
    void  getAndSetStarDate(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.now();

        //Act
        tester.setStartDate(startDate);
        final LocalDateTime getStartDate = tester.getStartDate();

        // Assert
        assertEquals(startDate, getStartDate, "setStartDate must be .now()");
    }

    @Test
    void  getAndSetEndDate(){
        // Arrange
        final LocalDateTime endDate = LocalDateTime.now();

        //Act
        tester.setEndDate(endDate);
        final LocalDateTime getEndDate = tester.getEndDate();

        // Assert
        assertEquals(endDate, getEndDate, "setEndDate must be .now()");
    }

    @ParameterizedTest
    @ValueSource(strings = {"In_Progress", "Completed", "Fail"})
    void  getAndSetStateStates(String state){

        //Act
        tester.setState(state);
        final String getState = tester.getState();

        // Assert
        assertEquals(state, getState, "setState must be In_Progress | Completed | Fail");
    }


    @Test
    void  getAndSetKVA(){
        // Arrange
        final KVA kva = new KVA();

        //Act
        tester.setKva(kva);
        final KVA getKva = tester.getKva();

        // Assert
        assertEquals(kva, getKva, "setKva must be new KVADomain()");
    }

    @Test
    void  getAndSetIdTeam(){
        // Arrange
        final Integer idTeam = 42;

        //Act
        tester.setIdTeam(idTeam);
        final Integer getIdTeam = tester.getIdTeam();

        // Assert
        assertEquals(idTeam, getIdTeam, "setIdTeam must be 42");
    }
}

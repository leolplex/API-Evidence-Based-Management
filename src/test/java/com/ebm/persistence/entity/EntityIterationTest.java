package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityIterationTest {
    EntityIteration tester;

    @BeforeEach
    void initEach() {
        // Arrange
        tester = new EntityIteration();
    }


    @Test
    void InstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getEntityId(),"getIdIteration must be null");
        assertNull(tester.getEntityGoal(),"getGoal must be null");
        assertNull(tester.getEntityStartDate(),"getStartDate must be null");
        assertNull(tester.getEntityEndDate(),"getEndDate must be null");
        assertNull(tester.getEntityState(),"getState must be null");
    }

    @Test
    void  getAndSetEntityId(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setEntityId(id);
        final Integer getEntityId = tester.getEntityId();

        // Assert
        assertEquals(id, getEntityId, "setEntityId must be my 42");
    }

    @Test
    void  getAndSetEntityName(){
        // Arrange
        final String name = "Iteration 1";

        //Act
        tester.setEntityName(name);
        final String getEntityName = tester.getEntityName();

        // Assert
        assertEquals(name, getEntityName, "setEntityName must be my Iteration 1");
    }

    @Test
    void  getAndSetEntityGoal(){
        // Arrange
        final String goal = "Set up deployment pipeline & release an empty site to production";

        //Act
        tester.setEntityGoal(goal);
        final String getEntityGoal = tester.getEntityGoal();

        // Assert
        assertEquals(goal, getEntityGoal, "setEntityGoal must be my Set up deployment pipeline & release an empty site to production");
    }

    @Test
    void  getAndSetEntityStarDate(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.now();

        //Act
        tester.setEntityStartDate(startDate);
        final LocalDateTime getEntityStartDate = tester.getEntityStartDate();

        // Assert
        assertEquals(startDate, getEntityStartDate, "setEntityStartDate must be .now()");
    }

    @Test
    void  getAndSetEntityEndDate(){
        // Arrange
        final LocalDateTime endDate = LocalDateTime.now();

        //Act
        tester.setEntityEndDate(endDate);
        final LocalDateTime getEntityEndDate = tester.getEntityEndDate();

        // Assert
        assertEquals(endDate, getEntityEndDate, "setEntityEndDate must be .now()");
    }

    @ParameterizedTest
    @ValueSource(strings = {"In_Progress", "Completed", "Fail"})
    void  getAndSetEntityStates(String state){

        //Act
        tester.setEntityState(state);
        final String getEntityState = tester.getEntityState();

        // Assert
        assertEquals(state, getEntityState, "setEntityState must be In_Progress | Completed | Fail");
    }


}

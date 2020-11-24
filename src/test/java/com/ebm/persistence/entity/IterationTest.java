package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class IterationTest {
    Iteration tester;

    @BeforeEach
    void initEach() {
        // Arrange
        tester = new Iteration();
    }


    @Test
    void InstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getId(),"getIdIteration must be null");
        assertNull(tester.getGoal(),"getGoal must be null");
        assertNull(tester.getStartDate(),"getStartDate must be null");
        assertNull(tester.getEndDate(),"getEndDate must be null");
        assertNull(tester.getState(),"getState must be null");
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

    @Test
    void  getAndSetStateInProgress(){
        // Arrange
        final String state = "In_Progress";

        //Act
        tester.setState(state);
        final String getState = tester.getState();

        // Assert
        assertEquals(state, getState, "setState must be In_Progress");
    }

    @Test
    void  getAndSetStateCompleted(){
        // Arrange
        final String state = "Completed";

        //Act
        tester.setState(state);
        final String getState = tester.getState();

        // Assert
        assertEquals(state, getState, "setState must be Completed");
    }

    @Test
    void  getAndSetStateFail(){
        // Arrange
        final String state = "Fail";

        //Act
        tester.setState(state);
        final String getState = tester.getState();

        // Assert
        assertEquals(state, getState, "setState must be Fail");
    }

}

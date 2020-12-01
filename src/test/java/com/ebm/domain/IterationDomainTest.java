package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class IterationDomainTest {
    IterationDomain tester;

    @BeforeEach
    void initEach() {
        tester = new IterationDomain();
    }

    @Test
    void TestInstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getIdDomain(),"getIdIteration must be null");
        assertNull(tester.getGoalDomain(),"getGoal must be null");
        assertNull(tester.getStartDateDomain(),"getStartDate must be null");
        assertNull(tester.getEndDateDomain(),"getEndDate must be null");
        assertNull(tester.getStateDomain(),"getState must be null");
    }

    @Test
    void  getAndSetIdDomain(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setIdDomain(id);
        final Integer getIdDomain = tester.getIdDomain();

        // Assert
        assertEquals(id, getIdDomain, "setIdDomain must be my 42");
    }

    @Test
    void  getAndSetGoalDomain(){
        // Arrange
        final String goal = "Set up deployment pipeline & release an empty site to production";

        //Act
        tester.setGoalDomain(goal);
        final String getGoalDomain = tester.getGoalDomain();

        // Assert
        assertEquals(goal, getGoalDomain, "setGoalDomain must be my Set up deployment pipeline & release an empty site to production");
    }

    @Test
    void  getAndSetStarDate(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.now();

        //Act
        tester.setStartDateDomain(startDate);
        final LocalDateTime getStartDateDomain = tester.getStartDateDomain();

        // Assert
        assertEquals(startDate, getStartDateDomain, "setStartDateDomain must be .now()");
    }

    @Test
    void  getAndSetEndDate(){
        // Arrange
        final LocalDateTime endDate = LocalDateTime.now();

        //Act
        tester.setEndDateDomain(endDate);
        final LocalDateTime getEndDateDomain = tester.getEndDateDomain();

        // Assert
        assertEquals(endDate, getEndDateDomain, "setEndDateDomain must be .now()");
    }

    @ParameterizedTest
    @ValueSource(strings = {"In_Progress", "Completed", "Fail"})
    void  getAndSetStateStates(String state){

        //Act
        tester.setStateDomain(state);
        final String getStateDomain = tester.getStateDomain();

        // Assert
        assertEquals(state, getStateDomain, "setStateDomain must be In_Progress | Completed | Fail");
    }

}

package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EntityIterationTeamTest {
    EntityIterationTeam tester;

    @BeforeEach
    void initEach() {
        // Arrange
        tester = new EntityIterationTeam();
    }

    @Test
    void InstanceIterationDefaultValues(){
        // Act & Assert
        assertNull(tester.getEntityIdIteration(),"getEntityIdIteration must be null");
        assertNull(tester.getEntityIdTeam(),"getEntityIdTeam must be null");
    }

    @Test
    void  getAndSetEntityIdIteration(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setEntityIdIteration(id);
        final Integer getEntityIdIteration = tester.getEntityIdIteration();

        // Assert
        assertEquals(id, getEntityIdIteration, "setEntityIdIteration must be my 42");
    }

    @Test
    void  getAndSetEntityIdTeam(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setEntityIdTeam(id);
        final Integer getEntityIdTeam = tester.getEntityIdTeam();

        // Assert
        assertEquals(id, getEntityIdTeam, "setEntityIdTeam must be my 42");
    }
}

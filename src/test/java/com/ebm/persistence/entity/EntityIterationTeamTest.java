package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityIterationTeamTest {
    EntityIterationTeam tester;

    @BeforeEach
    void initEach() {
        tester = new EntityIterationTeam();
    }

    @Test
    void InstanceIterationDefaultValues(){
        // Act & Assert
        assertNull(tester.getEntityIteration(),"getIdIteration must be null");
        assertNull(tester.getEntityTeam(),"getIdTeam must be null");
        assertNull(tester.getEntityId(),"getIdTeam must be null");
    }


    @Test
    void  getAndSetEntityId(){
        // Arrange
        final EntityIterationTeamPK id = new EntityIterationTeamPK();

        //Act
        tester.setEntityId(id);
        final EntityIterationTeamPK getEntityId = tester.getEntityId();

        // Assert
        assertEquals(id, getEntityId, "setEntityId must be new EntityIterationTeamPK()");
    }

    @Test
    void  getAndSetEntityIteration(){
        // Arrange
        final EntityIteration id = new EntityIteration();

        //Act
        tester.setEntityIteration(id);
        final EntityIteration getEntityIteration = tester.getEntityIteration();

        // Assert
        assertEquals(id, getEntityIteration, "setEntityIteration must be new EntityIteration()");
    }

    @Test
    void  getAndSetEntityTeam(){
        // Arrange
        final EntityTeam id = new EntityTeam();

        //Act
        tester.setEntityTeam(id);
        final EntityTeam getEntityTeam = tester.getEntityTeam();

        // Assert
        assertEquals(id, getEntityTeam, "setEntityTeam must be new EntityTeam()");
    }

}

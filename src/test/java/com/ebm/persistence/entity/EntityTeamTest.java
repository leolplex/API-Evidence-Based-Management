package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityTeamTest {
    EntityTeam tester;

    @BeforeEach
    void  initEach(){
        tester = new EntityTeam();
    }

    @Test
    void InstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getEntityId(),"getIdIteration must be null");
        assertNull(tester.getEntityName(),"getEntityName must be null");
        assertNull(tester.getEntityDateJoin(),"getEntityDateJoin must be null");
        assertNull(tester.getEntityTeam(),"getEntityTeam must be null");

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
        final String name = "My team";

        //Act
        tester.setEntityName(name);
        final String getEntityName = tester.getEntityName();

        // Assert
        assertEquals(name, getEntityName, "setEntityName must be my My team");
    }


    @Test
    void  getAndSetEntityDateJoin(){
        // Arrange
        final LocalDateTime dateJoin = LocalDateTime.now();

        //Act
        tester.setEntityDateJoin(dateJoin);
        final LocalDateTime getEntityDateJoin = tester.getEntityDateJoin();

        // Assert
        assertEquals(dateJoin, getEntityDateJoin, "setEntityDateJoin must be LocalDateTime.now()");
    }

    @Test
    void  getAndSetEntityTeam(){
        // Arrange
        final List<EntityIterationTeam> teams = new ArrayList<>();

        //Act
        tester.setEntityTeam(teams);
        final List<EntityIterationTeam> getEntityTeam = tester.getEntityTeam();

        // Assert
        assertEquals(teams, getEntityTeam, "setEntityTeam must be new ArrayList<>()");
    }
}


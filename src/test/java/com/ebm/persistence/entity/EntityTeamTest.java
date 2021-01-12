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
    void initEach() {
        tester = new EntityTeam();
    }

    @Test
    void InstanceIterationDefaultValues() {

        // Act & Assert
        assertNull(tester.getEntityId(), "getIdIteration must be null");
        assertNull(tester.getEntityName(), "getEntityName must be null");
        assertNull(tester.getEntityDateJoin(), "getEntityDateJoin must be null");
        assertNull(tester.getEntityIdUser(), "getEntityIdUser must be null");


    }

    @Test
    void getAndSetNewObject() {
        // Arrange
        final Integer id = 42;
        final String name = "My team";
        final LocalDateTime dateJoin = LocalDateTime.now();
        final Integer idUser = 4;


        //Act
        tester.setEntityId(id);
        tester.setEntityName(name);
        tester.setEntityDateJoin(dateJoin);
        tester.setEntityIdUser(idUser);

        final Integer getEntityId = tester.getEntityId();
        final String getEntityName = tester.getEntityName();
        final LocalDateTime getEntityDateJoin = tester.getEntityDateJoin();
        final Integer getEntityIdUser = tester.getEntityIdUser();

        // Assert
        assertEquals(id, getEntityId, "setEntityId must be my 42");
        assertEquals(name, getEntityName, "setEntityName must be my My team");
        assertEquals(dateJoin, getEntityDateJoin, "setEntityDateJoin must be LocalDateTime.now()");
        assertEquals(idUser, getEntityIdUser, "setEntityIdUser must be 4");
    }


}


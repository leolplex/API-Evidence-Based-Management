package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TeamTest {
    Team tester;

    @BeforeEach
    void initEach(){
        tester = new Team();
    }

    @Test
    void TestInstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getId(),"getId must be null");
        assertNull(tester.getName(),"getName must be null");
        assertNull(tester.getDateJoin(),"getDateJoin must be null");
        assertNull(tester.getIdUser(),"getIdUser must be null");
    }

    @Test
    void  getAndSetNewObject(){
        // Arrange
        final Integer id = 42;
        final String name = "My name";
        final LocalDateTime datetime = LocalDateTime.now();
        final Integer idUser = 4;


        //Act
        tester.setId(id);
        tester.setName(name);
        tester.setDateJoin(datetime);
        tester.setIdUser(idUser);

        final Integer getId = tester.getId();
        final String getName = tester.getName();
        final LocalDateTime getDateJoin = tester.getDateJoin();
        final Integer getIdUser = tester.getIdUser();

        // Assert
        assertEquals(id, getId, "setId must be my 42");
        assertEquals(name, getName, "setName must be my My name");
        assertEquals(datetime, getDateJoin, "setDateJoin must be LocalDateTime.now()");
        assertEquals(idUser, getIdUser, "setIdUser must be my 4");
    }


}

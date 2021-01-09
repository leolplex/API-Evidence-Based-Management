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
        final String name = "My name";

        //Act
        tester.setName(name);
        final String getName = tester.getName();

        // Assert
        assertEquals(name, getName, "setName must be my My name");
    }

    @Test
    void  getAndSetDateJoin(){
        // Arrange
        final LocalDateTime datetime = LocalDateTime.now();

        //Act
        tester.setDateJoin(datetime);
        final LocalDateTime getDateJoin = tester.getDateJoin();

        // Assert
        assertEquals(datetime, getDateJoin, "setDateJoin must be LocalDateTime.now()");
    }
}

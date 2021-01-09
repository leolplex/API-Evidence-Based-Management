package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductTest {
    Product tester;

    @BeforeEach
    void initEach() {
        tester = new Product();
    }

    @Test
    void InstanceIterationDefaultValues() {

        // Act & Assert
        assertNull(tester.getId(), "getId must be null");
        assertNull(tester.getName(), "getName must be null");
        assertNull(tester.getIterations(), "getIterations must be null");
        assertNull(tester.getStartDate(), "getStartDate must be null");
        assertNull(tester.getIdTeam(), "getIdTeam must be null");

    }

    @Test
    void getAndSetNewObject() {
        final Integer id = 42;
        final String name = "myusername";
        final List<Iteration> iterations = new ArrayList<>();
        final LocalDateTime startDate = LocalDateTime.now();
        final Integer idTeam = 50;

        tester.setId(id);
        tester.setName(name);
        tester.setIterations(iterations);
        tester.setStartDate(startDate);
        tester.setIdTeam(idTeam);

        final Integer getId = tester.getId();
        final String getName = tester.getName();
        final List<Iteration> getIterations = tester.getIterations();
        final LocalDateTime getStartDate = tester.getStartDate();
        final Integer getIdTeam = tester.getIdTeam();

        assertEquals(id, getId, "setId must be my 42");
        assertEquals(name, getName, "setIdRol must be my 50");
        assertEquals(iterations, getIterations, "setUserName must be my myusername");
        assertEquals(startDate, getStartDate, "setPassword must be my myusername");
        assertEquals(idTeam, getIdTeam, "setEmail must be my myusername@gmail.com");


    }
}

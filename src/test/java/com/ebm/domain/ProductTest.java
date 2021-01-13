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
        assertNull(tester.getIdUser(), "getIdUser must be null");
        assertNull(tester.getTeam(), "getTeam must be null");

    }

    @Test
    void getAndSetNewObject() {
        final Integer id = 42;
        final String name = "myusername";
        final List<Iteration> iterations = new ArrayList<>();
        final LocalDateTime startDate = LocalDateTime.now();
        final Integer idTeam = 50;
        final Integer idUser = 5;
        final Team team = new Team();

        tester.setId(id);
        tester.setName(name);
        tester.setIterations(iterations);
        tester.setStartDate(startDate);
        tester.setIdTeam(idTeam);
        tester.setIdUser(idUser);
        tester.setTeam(team);

        final Integer getId = tester.getId();
        final String getName = tester.getName();
        final List<Iteration> getIterations = tester.getIterations();
        final LocalDateTime getStartDate = tester.getStartDate();
        final Integer getIdTeam = tester.getIdTeam();
        final Integer getIdUser = tester.getIdUser();
        final Team getTeam = tester.getTeam();

        assertEquals(id, getId, "setId must be my 42");
        assertEquals(name, getName, "setName must be my myusername");
        assertEquals(iterations, getIterations, "setIterations must be new ArrayList<>()");
        assertEquals(startDate, getStartDate, "setStartDate must be my LocalDateTime.now()");
        assertEquals(idTeam, getIdTeam, "setIdTeam must be 50");
        assertEquals(idUser, getIdUser, "setIdTeam must be 5");
        assertEquals(team, getTeam, "setTeam must be new Team()");
    }
}

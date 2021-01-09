package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityProductTest {
    EntityProduct tester;

    @BeforeEach
    void initEach() {
        tester = new EntityProduct();
    }

    @Test
    void InstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getEntityId(), "getId must be null");
        assertNull(tester.getEntityName(), "getName must be null");
        assertNull(tester.getEntityIterationProducts(), "getIterations must be null");
        assertNull(tester.getEntityStartDate(), "getStartDate must be null");
        assertNull(tester.getEntityIdTeam(), "getIdTeam must be null");
    }

    @Test
    void getAndSetNewObject() {
        final Integer id = 42;
        final String name = "myusername";
        final List<EntityIterationProduct> iterationsProduct = new ArrayList<>();
        final LocalDateTime startDate = LocalDateTime.now();
        final Integer idTeam = 50;

        tester.setEntityId(id);
        tester.setEntityName(name);
        tester.setEntityIterationProducts(iterationsProduct);
        tester.setEntityStartDate(startDate);
        tester.setEntityIdTeam(idTeam);

        final Integer getId = tester.getEntityId();
        final String getName = tester.getEntityName();
        final List<EntityIterationProduct> getEntityIterationProducts = tester.getEntityIterationProducts();
        final LocalDateTime getStartDate = tester.getEntityStartDate();
        final Integer getIdTeam = tester.getEntityIdTeam();

        assertEquals(id, getId, "setEntityId must be my 42");
        assertEquals(name, getName, "setEntityName must be myusername");
        assertEquals(iterationsProduct, getEntityIterationProducts, "setEntityIterationProducts must be new ArrayList<>()");
        assertEquals(startDate, getStartDate, "setEntityStartDate must be LocalDateTime.now()");
        assertEquals(idTeam, getIdTeam, "setEntityIdTeam must be 50");
    }
}

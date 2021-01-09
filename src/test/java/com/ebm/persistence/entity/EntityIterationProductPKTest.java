package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityIterationProductPKTest {
    EntityIterationProductPK tester;

    @BeforeEach
    void initEach() {
        tester = new EntityIterationProductPK();
    }

    @Test
    void InstanceIterationDefaultValues(){
        // Act & Assert
        assertNull(tester.getIdIteration(),"getIdIteration must be null");
        assertNull(tester.getIdProduct(),"getIdTeam must be null");
    }

    @Test
    void  getAndSetIdIteration(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setIdIteration(id);
        final Integer getIdIteration = tester.getIdIteration();

        // Assert
        assertEquals(id, getIdIteration, "setIdIteration must be my 42");
    }

    @Test
    void  getAndSetIdTeam(){
        // Arrange
        final Integer id = 42;

        //Act
        tester.setIdProduct(id);
        final Integer getIdTeam = tester.getIdProduct();

        // Assert
        assertEquals(id, getIdTeam, "setIdTeam must be my 42");
    }
}

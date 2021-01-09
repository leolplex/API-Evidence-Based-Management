package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityIterationProductTest {
    EntityIterationProduct tester;

    @BeforeEach
    void initEach() {
        tester = new EntityIterationProduct();
    }

    @Test
    void InstanceIterationDefaultValues(){
        // Act & Assert
        assertNull(tester.getEntityIteration(),"getIdIteration must be null");
        assertNull(tester.getEntityProduct(),"getIdTeam must be null");
        assertNull(tester.getEntityId(),"getIdTeam must be null");
    }


    @Test
    void  getAndSetEntityId(){
        // Arrange
        final EntityIterationProductPK id = new EntityIterationProductPK();

        //Act
        tester.setEntityId(id);
        final EntityIterationProductPK getEntityId = tester.getEntityId();

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
        final EntityProduct id = new EntityProduct();

        //Act
        tester.setEntityProduct(id);
        final EntityProduct getEntityTeam = tester.getEntityProduct();

        // Assert
        assertEquals(id, getEntityTeam, "setEntityTeam must be new EntityTeam()");
    }

}

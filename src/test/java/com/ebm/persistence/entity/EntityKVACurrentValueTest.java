package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityKVACurrentValueTest {
    EntityKVACurrentValue tester;

    @BeforeEach
    void initEach() {
        tester = new EntityKVACurrentValue();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getEntityId(), "getEntityId must be null");
        assertNull(tester.getEntityCustomerSatisfaction(), "getEntityCustomerSatisfaction must be null");
        assertNull(tester.getEntityIteration(), "getEntityIteration must be null");
        assertNull(tester.getEntityCustomerUsageIndex(), "getEntityCustomerUsageIndex must be null");
        assertNull(tester.getEntityEmployeeSatisfaction(), "getEntityEmployeeSatisfaction must be null");
        assertNull(tester.getEntityProductCostRatio(), "getEntityProductCostRatio must be null");
        assertNull(tester.getEntityRevenuePerEmployee(), "getEntityRevenuePerEmployee must be null");
        assertNull(tester.getEntityIdIteration(), "getEntityIdIteration must be null");
        assertNull(tester.getEntityIdTeam(), "getEntityIdTeam must be null");
    }

    @Test
    void getAndSetNewObject() {
        // Arrange
        final Integer id = 42;
        final String customerSatisfaction = "5/10";
        final EntityIteration entityIteration = new EntityIteration();
        final String entityCustomerUsageIndex = "13";
        final String entityEmployeeSatisfaction = "7";
        final String entityProductCostRatio = "134";
        final String entityRevenuePerEmployee = "10000000";
        final Integer idTeam = 1;
        final Integer idIteration = 2;

        //Act
        tester.setEntityId(id);
        tester.setEntityCustomerSatisfaction(customerSatisfaction);
        tester.setEntityIteration(entityIteration);
        tester.setEntityCustomerUsageIndex(entityCustomerUsageIndex);
        tester.setEntityEmployeeSatisfaction(entityEmployeeSatisfaction);
        tester.setEntityProductCostRatio(entityProductCostRatio);
        tester.setEntityRevenuePerEmployee(entityRevenuePerEmployee);
        tester.setEntityIdTeam(idTeam);
        tester.setEntityIdIteration(idIteration);

        final Integer getEntityId = tester.getEntityId();
        final String getEntityCustomerSatisfaction = tester.getEntityCustomerSatisfaction();
        final EntityIteration getEntityIteration = tester.getEntityIteration();
        final String getEntityCustomerUsageIndex = tester.getEntityCustomerUsageIndex();
        final String getEntityEmployeeSatisfaction = tester.getEntityEmployeeSatisfaction();
        final String getEntityProductCostRatio = tester.getEntityProductCostRatio();
        final String getEntityRevenuePerEmployee = tester.getEntityRevenuePerEmployee();
        final Integer getEntityIdTeam = tester.getEntityIdTeam();
        final Integer getEntityIdIteration = tester.getEntityIdIteration();


        // Assert
        assertEquals(id, getEntityId, "setEntityId must be my 42");
        assertEquals(customerSatisfaction, getEntityCustomerSatisfaction, "setEntityCustomerSatisfaction must be 5/10");
        assertEquals(entityIteration, getEntityIteration, "setEntityIteration must be new EntityIteration()");
        assertEquals(entityCustomerUsageIndex, getEntityCustomerUsageIndex, "setEntityCustomerUsageIndex must be 13");
        assertEquals(entityEmployeeSatisfaction, getEntityEmployeeSatisfaction, "setEntityEmployeeSatisfaction must be 7");
        assertEquals(entityProductCostRatio, getEntityProductCostRatio, "setEntityProductCostRatio must be 134");
        assertEquals(entityRevenuePerEmployee, getEntityRevenuePerEmployee, "setEntityRevenuePerEmployee must be 10000000");
        assertEquals(idTeam, getEntityIdTeam, "setEntityIdTeam must be 1");
        assertEquals(idIteration, getEntityIdIteration, "setEntityIdIteration must be 2");
    }

}

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
    }

    @Test
    void getAndSetEntityId() {
        // Arrange
        final Integer id = 42;

        //Act
        tester.setEntityId(id);
        final Integer getEntityId = tester.getEntityId();

        // Assert
        assertEquals(id, getEntityId, "setEntityId must be my 42");
    }

    @Test
    void getAndSetEntityCustomerSatisfaction() {
        // Arrange
        final String customerSatisfaction = "5/10";

        //Act
        tester.setEntityCustomerSatisfaction(customerSatisfaction);
        final String getEntityCustomerSatisfaction = tester.getEntityCustomerSatisfaction();

        // Assert
        assertEquals(customerSatisfaction, getEntityCustomerSatisfaction, "setEntityCustomerSatisfaction must be 5/10");
    }

    @Test
    void getAndSetEntityIteration() {
        // Arrange
        final EntityIteration entityIteration = new EntityIteration();

        //Act
        tester.setEntityIteration(entityIteration);
        final EntityIteration getEntityIteration = tester.getEntityIteration();

        // Assert
        assertEquals(entityIteration, getEntityIteration, "setEntityIteration must be new EntityIteration()");
    }

    @Test
    void getAndSetEntityCustomerUsageIndex() {
        // Arrange
        final String entityCustomerUsageIndex = "13";

        //Act
        tester.setEntityCustomerUsageIndex(entityCustomerUsageIndex);
        final String getEntityCustomerUsageIndex = tester.getEntityCustomerUsageIndex();

        // Assert
        assertEquals(entityCustomerUsageIndex, getEntityCustomerUsageIndex, "setEntityCustomerUsageIndex must be 13");
    }

    @Test
    void getAndSetEntityEmployeeSatisfaction() {
        // Arrange
        final String entityEmployeeSatisfaction = "7";

        //Act
        tester.setEntityEmployeeSatisfaction(entityEmployeeSatisfaction);
        final String getEntityEmployeeSatisfaction = tester.getEntityEmployeeSatisfaction();

        // Assert
        assertEquals(entityEmployeeSatisfaction, getEntityEmployeeSatisfaction, "setEntityEmployeeSatisfaction must be 7");
    }

    @Test
    void getAndSetEntityProductCostRatio() {
        // Arrange
        final String entityProductCostRatio = "134";

        //Act
        tester.setEntityProductCostRatio(entityProductCostRatio);
        final String getEntityProductCostRatio = tester.getEntityProductCostRatio();

        // Assert
        assertEquals(entityProductCostRatio, getEntityProductCostRatio, "setEntityProductCostRatio must be 134");
    }

    @Test
    void getAndSetEntityRevenuePerEmployee() {
        // Arrange
        final String entityRevenuePerEmployee = "10000000";

        //Act
        tester.setEntityRevenuePerEmployee(entityRevenuePerEmployee);
        final String getEntityRevenuePerEmployee = tester.getEntityRevenuePerEmployee();

        // Assert
        assertEquals(entityRevenuePerEmployee, getEntityRevenuePerEmployee, "setEntityRevenuePerEmployee must be 10000000");
    }
}

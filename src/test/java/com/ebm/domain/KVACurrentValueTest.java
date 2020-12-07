package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class KVACurrentValueTest {

    KVACurrentValue tester;

    @BeforeEach
    void initEach() {
        tester = new KVACurrentValue();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getId(), "getId must be null");
        assertNull(tester.getCustomerSatisfaction(), "getCustomerSatisfaction must be null");
        assertNull(tester.getCustomerUsageIndex(), "getCustomerUsageIndex must be null");
        assertNull(tester.getEmployeeSatisfaction(), "getEmployeeSatisfaction must be null");
        assertNull(tester.getProductCostRatio(), "getProductCostRatio must be null");
        assertNull(tester.getRevenuePerEmployee(), "getRevenuePerEmployee must be null");
    }

    @Test
    void getAndSetId() {
        // Arrange
        final Integer id = 42;

        //Act
        tester.setId(id);
        final Integer getId = tester.getId();

        // Assert
        assertEquals(id, getId, "setId must be my 42");
    }

    @Test
    void getAndSetCustomerSatisfaction() {
        // Arrange
        final String customerSatisfaction = "5/10";

        //Act
        tester.setCustomerSatisfaction(customerSatisfaction);
        final String getCustomerSatisfaction = tester.getCustomerSatisfaction();

        // Assert
        assertEquals(customerSatisfaction, getCustomerSatisfaction, "setCustomerSatisfaction must be 5/10");
    }

    @Test
    void getAndSetCustomerUsageIndex() {
        // Arrange
        final String customerUsageIndex = "13";

        //Act
        tester.setCustomerUsageIndex(customerUsageIndex);
        final String getCustomerUsageIndex = tester.getCustomerUsageIndex();

        // Assert
        assertEquals(customerUsageIndex, getCustomerUsageIndex, "setCustomerUsageIndex must be 13");
    }

    @Test
    void getAndSetEmployeeSatisfaction() {
        // Arrange
        final String employeeSatisfaction = "7";

        //Act
        tester.setEmployeeSatisfaction(employeeSatisfaction);
        final String getEmployeeSatisfaction = tester.getEmployeeSatisfaction();

        // Assert
        assertEquals(employeeSatisfaction, getEmployeeSatisfaction, "setEmployeeSatisfaction must be 7");
    }

    @Test
    void getAndSetProductCostRatio() {
        // Arrange
        final String productCostRatio = "134";

        //Act
        tester.setProductCostRatio(productCostRatio);
        final String getProductCostRatio = tester.getProductCostRatio();

        // Assert
        assertEquals(productCostRatio, getProductCostRatio, "setProductCostRatio must be 134");
    }

    @Test
    void getAndSetRevenuePerEmployee() {
        // Arrange
        final String revenuePerEmployee = "10000000";

        //Act
        tester.setRevenuePerEmployee(revenuePerEmployee);
        final String getRevenuePerEmployee = tester.getRevenuePerEmployee();

        // Assert
        assertEquals(revenuePerEmployee, getRevenuePerEmployee, "setRevenuePerEmployee must be 10000000");
    }
}

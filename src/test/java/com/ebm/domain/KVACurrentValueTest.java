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
        assertNull(tester.getIdIteration(), "getIdIteration must be null");
        assertNull(tester.getIdTeam(), "getIdTeam must be null");
    }


    @Test
    void getAndSetNewObject() {
        // Arrange
        final Integer id = 42;
        final String customerSatisfaction = "5/10";
        final String customerUsageIndex = "13";
        final String employeeSatisfaction = "7";
        final String productCostRatio = "134";
        final String revenuePerEmployee = "10000000";
        final int idTeam = 1;
        final int idIteration = 2;

        //Act
        tester.setId(id);
        tester.setCustomerSatisfaction(customerSatisfaction);
        tester.setCustomerUsageIndex(customerUsageIndex);
        tester.setEmployeeSatisfaction(employeeSatisfaction);
        tester.setProductCostRatio(productCostRatio);
        tester.setRevenuePerEmployee(revenuePerEmployee);
        tester.setIdTeam(idTeam);
        tester.setIdIteration(idIteration);


        final Integer getId = tester.getId();
        final String getCustomerSatisfaction = tester.getCustomerSatisfaction();
        final String getCustomerUsageIndex = tester.getCustomerUsageIndex();
        final String getEmployeeSatisfaction = tester.getEmployeeSatisfaction();
        final String getProductCostRatio = tester.getProductCostRatio();
        final String getRevenuePerEmployee = tester.getRevenuePerEmployee();
        final Integer getIdTeam = tester.getIdTeam();
        final Integer getIdIteration = tester.getIdIteration();



        // Assert
        assertEquals(id, getId, "setId must be my 42");
        assertEquals(customerSatisfaction, getCustomerSatisfaction, "setCustomerSatisfaction must be 5/10");
        assertEquals(customerUsageIndex, getCustomerUsageIndex, "setCustomerUsageIndex must be 13");
        assertEquals(employeeSatisfaction, getEmployeeSatisfaction, "setEmployeeSatisfaction must be 7");
        assertEquals(productCostRatio, getProductCostRatio, "setProductCostRatio must be 134");
        assertEquals(revenuePerEmployee, getRevenuePerEmployee, "setRevenuePerEmployee must be 10000000");
        assertEquals(idTeam, getIdTeam, "setIdTeam must be 1");
        assertEquals(idIteration, getIdIteration, "setIdIteration must be 2");
    }


}

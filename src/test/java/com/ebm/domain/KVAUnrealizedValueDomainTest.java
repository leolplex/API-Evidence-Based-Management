package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class KVAUnrealizedValueDomainTest {
    KVAUnrealizedValueDomain tester;

    @BeforeEach
    void initEach() {
        tester = new KVAUnrealizedValueDomain();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getId(), "getIdIteration must be null");
        assertNull(tester.getCustomerSatisfactionGap(), "getCustomerSatisfactionGap must be null");
        assertNull(tester.getMarketShare(), "getMarketShare must be null");
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
    void getAndSetCustomerSatisfactionGap() {
        // Arrange
        final String customerSatisfactionGap = "GAP 1";

        //Act
        tester.setCustomerSatisfactionGap(customerSatisfactionGap);
        final String getCustomerSatisfactionGap = tester.getCustomerSatisfactionGap();

        // Assert
        assertEquals(customerSatisfactionGap, getCustomerSatisfactionGap, "setCustomerSatisfactionGap must be GAP 1");
    }

    @Test
    void getAndSetMarketShare() {
        // Arrange
        final String marketShare = "my ms";

        //Act
        tester.setMarketShare(marketShare);
        final String getMarketShare = tester.getMarketShare();

        // Assert
        assertEquals(marketShare, getMarketShare, "setMarketShare must be my ms");
    }
}

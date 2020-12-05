package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityKVAUnrealizedValueTest {

    EntityKVAUnrealizedValue tester;

    @BeforeEach
    void initEach() {
        tester = new EntityKVAUnrealizedValue();
    }

    @Test
    void InstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getEntityId(), "getEntityId must be null");
        assertNull(tester.getEntityIteration(), "getEntityIteration must be null");
        assertNull(tester.getEntityCustomerSatisfactionGap(), "getEntityCustomerSatisfactionGap must be null");
        assertNull(tester.getEntityMarketShare(), "getEntityMarketShare must be null");
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
    void getAndSetEntityIteration() {
        // Arrange
        final EntityIteration entityIteration = new EntityIteration();

        //Act
        tester.setEntityIteration(entityIteration);
        final EntityIteration getEntityIteration = tester.getEntityIteration();

        // Assert
        assertEquals(entityIteration, getEntityIteration, "setEntityIteration must be my new EntityIteration()");
    }

    @Test
    void getAndSetEntityCustomerSatisfactionGap() {
        // Arrange
        final String customerSatisfactionGap = "My GAP is 42";

        //Act
        tester.setEntityCustomerSatisfactionGap(customerSatisfactionGap);
        final String getEntityCustomerSatisfactionGap = tester.getEntityCustomerSatisfactionGap();

        // Assert
        assertEquals(customerSatisfactionGap, getEntityCustomerSatisfactionGap, "customerSatisfactionGap must be My GAP is 42");
    }

    @Test
    void getAndSetEntityMarketShare() {
        // Arrange
        final String marketShare = "Is 42";

        //Act
        tester.setEntityMarketShare(marketShare);
        final String getEntityMarketShare = tester.getEntityMarketShare();

        // Assert
        assertEquals(marketShare, getEntityMarketShare, "setEntityMarketShare must be Is 42");
    }
}

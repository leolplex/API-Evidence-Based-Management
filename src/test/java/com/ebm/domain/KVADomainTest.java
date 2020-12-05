package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class KVADomainTest {
    KVADomain tester;

    @BeforeEach
    void initEach(){
        tester = new KVADomain();
    }

    @Test
    void TestInstanceIterationDefaultValues(){
        // Act & Assert
        assertNull(tester.getKvaUnrealizedValue(),"getIdIteration must be null");
    }

    @Test
    void  getAndSetIterationDefaultValues(){
        // Arrange
        final KVAUnrealizedValueDomain kvaUnrealizedValueDomain = new KVAUnrealizedValueDomain();

        //Act
        tester.setKvaUnrealizedValue(kvaUnrealizedValueDomain);
        final KVAUnrealizedValueDomain getKvaUnrealizedValue = tester.getKvaUnrealizedValue();

        // Assert
        assertEquals(kvaUnrealizedValueDomain, getKvaUnrealizedValue, "setKvaUnrealizedValue must be new KVAUnrealizedValueDomain()");
    }
}

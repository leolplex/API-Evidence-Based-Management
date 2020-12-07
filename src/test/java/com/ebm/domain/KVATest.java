package com.ebm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class KVATest {
    KVA tester;

    @BeforeEach
    void initEach() {
        tester = new KVA();
    }

    @Test
    void TestInstanceIterationDefaultValues() {
        // Act & Assert
        assertNull(tester.getKvaUnrealizedValue(), "getIdIteration must be null");
        assertNull(tester.getKvaCurrentValue(), "getKvaCurrentValue must be null");
    }

    @Test
    void getAndSetIterationDefaultValues() {
        // Arrange
        final KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();

        //Act
        tester.setKvaUnrealizedValue(kvaUnrealizedValue);
        final KVAUnrealizedValue getKvaUnrealizedValue = tester.getKvaUnrealizedValue();

        // Assert
        assertEquals(kvaUnrealizedValue, getKvaUnrealizedValue, "setKvaUnrealizedValue must be new KVAUnrealizedValueDomain()");
    }

    @Test
    void getAndSetKvaCurrentValue() {
        // Arrange
        final KVACurrentValue kvaCurrentValue = new KVACurrentValue();

        //Act
        tester.setKvaCurrentValue(kvaCurrentValue);
        final KVACurrentValue getKvaCurrentValue = tester.getKvaCurrentValue();

        // Assert
        assertEquals(kvaCurrentValue, getKvaCurrentValue, "setKvaCurrentValue must be new KVACurrentValue()");
    }
}

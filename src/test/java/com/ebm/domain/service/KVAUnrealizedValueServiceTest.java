package com.ebm.domain.service;

import com.ebm.domain.KVAUnrealizedValue;
import com.ebm.domain.repository.KVAUnrealizedValueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVAUnrealizedValueServiceTest {
    KVAUnrealizedValueService tester;
    KVAUnrealizedValueRepository kvaUnrealizedValueRepository;

    @BeforeEach
    void initEach() {
        kvaUnrealizedValueRepository = Mockito.mock(KVAUnrealizedValueRepository.class);
        tester = new KVAUnrealizedValueService(kvaUnrealizedValueRepository);
    }

    @Test
    void TestGetByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getById(1), "getById must be Optional.empty()");
    }

    @Test
    void TestGetByIdWithData() {
        Optional<KVAUnrealizedValue> kvaUnrealizedValue = Optional.of(new KVAUnrealizedValue());
        when(kvaUnrealizedValueRepository.getById(1)).thenReturn(kvaUnrealizedValue);
        assertEquals(kvaUnrealizedValue, tester.getById(1), "getById must be Optional.of(new KVAUnrealizedValue())");
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVAUnrealizedValue()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        when(kvaUnrealizedValueRepository.save(kvaUnrealizedValue)).thenReturn(kvaUnrealizedValue);
        assertEquals(kvaUnrealizedValue, tester.save(kvaUnrealizedValue), "save must be a new instance KVAUnrealizedValue");
    }

    @Test
    void TestUpdateWithOutData() {
        assertEquals(Optional.empty(), tester.update(1, new KVAUnrealizedValue()), "update must be Optional.empty()");
    }

    @Test
    void TestUpdateWithData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        when(kvaUnrealizedValueRepository.update(1, kvaUnrealizedValue)).thenReturn(Optional.of(kvaUnrealizedValue));
        assertEquals(Optional.of(kvaUnrealizedValue), tester.update(1, kvaUnrealizedValue), "update must be a new instance KVAUnrealizedValue");
    }
}

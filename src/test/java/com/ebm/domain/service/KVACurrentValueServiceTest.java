package com.ebm.domain.service;

import com.ebm.domain.KVACurrentValue;
import com.ebm.domain.repository.KVACurrentValueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVACurrentValueServiceTest {
    KVACurrentValueService tester;
    KVACurrentValueRepository kvaCurrentValueRepository;

    @BeforeEach
    void initEach() {
        kvaCurrentValueRepository = Mockito.mock(KVACurrentValueRepository.class);
        tester = new KVACurrentValueService(kvaCurrentValueRepository);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVACurrentValue()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        when(kvaCurrentValueRepository.save(kvaCurrentValue)).thenReturn(kvaCurrentValue);
        assertEquals(kvaCurrentValue, tester.save(kvaCurrentValue), "save must be a new instance KVACurrentValue");
    }

    @Test
    void TestUpdateWithOutData() {
        assertEquals(Optional.empty(), tester.update(1, new KVACurrentValue()), "update must be Optional.empty()");
    }

    @Test
    void TestUpdateWithData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        when(kvaCurrentValueRepository.update(1, kvaCurrentValue)).thenReturn(Optional.of(kvaCurrentValue));
        assertEquals(Optional.of(kvaCurrentValue), tester.update(1, kvaCurrentValue), "update must be a new instance KVACurrentValue");
    }

}

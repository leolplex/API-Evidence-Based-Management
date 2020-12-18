package com.ebm.domain.service;

import com.ebm.domain.KVAAbilityToInnovate;
import com.ebm.domain.repository.KVAAbilityToInnovateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVAAbilityToInnovateServiceTest {
    KVAAbilityToInnovateService tester;
    KVAAbilityToInnovateRepository kvaAbilityToInnovateRepository;

    @BeforeEach
    void initEach() {
        kvaAbilityToInnovateRepository = Mockito.mock(KVAAbilityToInnovateRepository.class);
        tester = new KVAAbilityToInnovateService(kvaAbilityToInnovateRepository);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVAAbilityToInnovate()), "Save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();
        when(kvaAbilityToInnovateRepository.save(kvaAbilityToInnovate)).thenReturn(kvaAbilityToInnovate);
        assertEquals(kvaAbilityToInnovate, tester.save(kvaAbilityToInnovate), "save must be a new instance KVAAbilityToInnovate");
    }

    @Test
    void TestUpdateWithOutData() {
        assertEquals(Optional.empty(), tester.update(1, new KVAAbilityToInnovate()), "update must be Optional.empty()");
    }
    @Test
    void TestUpdateWithData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();


        when(kvaAbilityToInnovateRepository.update(1, kvaAbilityToInnovate)).thenReturn(Optional.of(kvaAbilityToInnovate));
        assertEquals(Optional.of(kvaAbilityToInnovate), tester.update(1, kvaAbilityToInnovate), "update must be a new instance KVAAbilityToInnovate");
    }

}

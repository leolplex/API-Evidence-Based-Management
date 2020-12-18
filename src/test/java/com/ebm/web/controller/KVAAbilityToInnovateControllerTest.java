package com.ebm.web.controller;

import com.ebm.domain.KVAAbilityToInnovate;
import com.ebm.domain.service.KVAAbilityToInnovateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class KVAAbilityToInnovateControllerTest {
    KVAAbilityToInnovateController tester;
    KVAAbilityToInnovateService kvaAbilityToInnovateService;

    @BeforeEach
    void initEach() {
        kvaAbilityToInnovateService = Mockito.mock(KVAAbilityToInnovateService.class);
        tester = new KVAAbilityToInnovateController(kvaAbilityToInnovateService);
    }

    @Test
    void TestSaveWithoutData() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new KVAAbilityToInnovate()), "save must be HttpStatus.CREATED");
    }

    @Test
    void TestSaveWithData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();
        when(kvaAbilityToInnovateService.save(kvaAbilityToInnovate)).thenReturn(kvaAbilityToInnovate);
        assertEquals(new ResponseEntity<>(kvaAbilityToInnovate, HttpStatus.CREATED), tester.save(kvaAbilityToInnovate), "save must be HttpStatus.CREATED");
    }

    @Test
    void TestUpdateNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.update(1, new KVAAbilityToInnovate()), "update must be null");
    }

    @Test
    void TestUpdateWithData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();
        Optional<KVAAbilityToInnovate> kvaAbilityToInnovateOptional = Optional.of(kvaAbilityToInnovate);
        when(kvaAbilityToInnovateService.update(1, kvaAbilityToInnovate)).thenReturn(kvaAbilityToInnovateOptional);

        assertEquals(new ResponseEntity<>(kvaAbilityToInnovate, HttpStatus.OK), tester.update(1, kvaAbilityToInnovate), "update must be new instance KVAAbilityToInnovate");
    }
}

package com.ebm.web.controller;

import com.ebm.domain.KVAUnrealizedValue;
import com.ebm.domain.service.KVAUnrealizedValueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class KVAUnrealizedValueControllerTest {
    KVAUnrealizedValueController tester;
    KVAUnrealizedValueService kvaUnrealizedValueService;

    @BeforeEach()
    void initEach() {
        kvaUnrealizedValueService = Mockito.mock(KVAUnrealizedValueService.class);
        tester = new KVAUnrealizedValueController(kvaUnrealizedValueService);
    }

    @Test
    void TestGetByIdWithoutData() {
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.getById(1), "getById must be HttpStatus.NOT_FOUND");
    }

    @Test
    void TestGetByIdWithData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        when(kvaUnrealizedValueService.getById(1)).thenReturn(Optional.of(kvaUnrealizedValue));
        assertEquals(new ResponseEntity<>(kvaUnrealizedValue, HttpStatus.OK), tester.getById(1), "getById must be HttpStatus.OK");
    }

    @Test
    void TestSaveWithoutData() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new KVAUnrealizedValue()), "save must be HttpStatus.CREATED");
    }

    @Test
    void TestSaveWithData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        when(kvaUnrealizedValueService.save(kvaUnrealizedValue)).thenReturn(kvaUnrealizedValue);
        assertEquals(new ResponseEntity<>(kvaUnrealizedValue, HttpStatus.CREATED), tester.save(kvaUnrealizedValue), "save must be HttpStatus.CREATED");
    }
}

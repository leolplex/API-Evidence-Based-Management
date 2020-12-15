package com.ebm.web.controller;

import com.ebm.domain.KVACurrentValue;
import com.ebm.domain.KVAUnrealizedValue;
import com.ebm.domain.service.KVACurrentValueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class KVACurrentValueControllerTest {
    KVACurrentValueController tester;
    KVACurrentValueService kvaCurrentValueService;

    @BeforeEach
    void initEach() {
        kvaCurrentValueService = Mockito.mock(KVACurrentValueService.class);
        tester = new KVACurrentValueController(kvaCurrentValueService);
    }

    @Test
    void TestSaveWithoutData() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new KVACurrentValue()), "save must be HttpStatus.CREATED");
    }

    @Test
    void TestSaveWithData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        when(kvaCurrentValueService.save(kvaCurrentValue)).thenReturn(kvaCurrentValue);
        assertEquals(new ResponseEntity<>(kvaCurrentValue, HttpStatus.CREATED), tester.save(kvaCurrentValue), "save must be HttpStatus.CREATED");
    }

    @Test
    void TestUpdateNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.update(1, new KVACurrentValue()), "update must be null");
    }

    @Test
    void TestUpdateWithData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        Optional<KVACurrentValue> kvaCurrentValueOptional = Optional.of(kvaCurrentValue);
        when(kvaCurrentValueService.update(1, kvaCurrentValue)).thenReturn(kvaCurrentValueOptional);

        assertEquals(new ResponseEntity<>(kvaCurrentValue, HttpStatus.OK), tester.update(1, kvaCurrentValue), "update must be new instance kvaCurrentValue");
    }
}

package com.ebm.web.controller;


import com.ebm.domain.KVATimeToMarket;
import com.ebm.domain.service.KVATimeToMarketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class KVATimeToMarketControllerTest {
    KVATimeToMarketController tester;
    KVATimeToMarketService kvaTimeToMarketService;

    @BeforeEach
    void initEach(){
        kvaTimeToMarketService = Mockito.mock(KVATimeToMarketService.class);
        tester = new KVATimeToMarketController(kvaTimeToMarketService);
    }
    @Test
    void TestSaveWithoutData() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new KVATimeToMarket()), "save must be HttpStatus.CREATED");
    }

    @Test
    void TestSaveWithData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();
        when(kvaTimeToMarketService.save(kvaTimeToMarket)).thenReturn(kvaTimeToMarket);
        assertEquals(new ResponseEntity<>(kvaTimeToMarket, HttpStatus.CREATED), tester.save(kvaTimeToMarket), "save must be HttpStatus.CREATED");
    }

    @Test
    void TestUpdateNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.update(1, new KVATimeToMarket()), "update must be null");
    }

    @Test
    void TestUpdateWithData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();
        Optional<KVATimeToMarket> kvaTimeToMarketOptional = Optional.of(kvaTimeToMarket);
        when(kvaTimeToMarketService.update(1, kvaTimeToMarket)).thenReturn(kvaTimeToMarketOptional);

        assertEquals(new ResponseEntity<>(kvaTimeToMarket, HttpStatus.OK), tester.update(1, kvaTimeToMarket), "update must be new instance KVATimeToMarket");
    }

}

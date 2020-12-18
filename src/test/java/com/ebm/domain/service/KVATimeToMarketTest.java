package com.ebm.domain.service;

import com.ebm.domain.KVATimeToMarket;
import com.ebm.domain.repository.KVATimeToMarketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVATimeToMarketTest {
    KVATimeToMarketService tester;
    KVATimeToMarketRepository kvaTimeToMarketRepository;

    @BeforeEach
    void initEach() {
        kvaTimeToMarketRepository = Mockito.mock(KVATimeToMarketRepository.class);
        tester = new KVATimeToMarketService(kvaTimeToMarketRepository);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVATimeToMarket()), "Save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();
        when(kvaTimeToMarketRepository.save(kvaTimeToMarket)).thenReturn(kvaTimeToMarket);
        assertEquals(kvaTimeToMarket, tester.save(kvaTimeToMarket), "save must be a new instance KVATimeToMarket");
    }

    @Test
    void TestUpdateWithOutData() {
        assertEquals(Optional.empty(), tester.update(1, new KVATimeToMarket()), "update must be Optional.empty()");
    }
    @Test
    void TestUpdateWithData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();

        when(kvaTimeToMarketRepository.update(1, kvaTimeToMarket)).thenReturn(Optional.of(kvaTimeToMarket));
        assertEquals(Optional.of(kvaTimeToMarket), tester.update(1, kvaTimeToMarket), "update must be a new instance KVATimeToMarket");
    }
}

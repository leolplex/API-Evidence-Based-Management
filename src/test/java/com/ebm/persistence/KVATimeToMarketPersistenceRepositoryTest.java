package com.ebm.persistence;

import com.ebm.domain.KVATimeToMarket;
import com.ebm.persistence.crud.KVATimeToMarketCrudRepository;
import com.ebm.persistence.entity.EntityKVATimeToMarket;
import com.ebm.persistence.mapper.KVATimeToMarketMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVATimeToMarketPersistenceRepositoryTest {
    KVATimeToMarketPersistenceRepository tester;
    KVATimeToMarketCrudRepository kvaTimeToMarketCrudRepository;
    KVATimeToMarketMapper mapper;

    @BeforeEach
    void initEach() {
        kvaTimeToMarketCrudRepository = Mockito.mock(KVATimeToMarketCrudRepository.class);
        mapper = Mockito.mock(KVATimeToMarketMapper.class);
        tester = new KVATimeToMarketPersistenceRepository(kvaTimeToMarketCrudRepository, mapper);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVATimeToMarket()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();
        EntityKVATimeToMarket entityKVATimeToMarket = new EntityKVATimeToMarket();
        when(mapper.toKVATimeToMarketDomain(kvaTimeToMarket)).thenReturn(entityKVATimeToMarket);
        when(mapper.toKVATimeToMarket(entityKVATimeToMarket)).thenReturn(kvaTimeToMarket);
        when(kvaTimeToMarketCrudRepository.save(entityKVATimeToMarket)).thenReturn(entityKVATimeToMarket);

        assertEquals(kvaTimeToMarket, tester.save(kvaTimeToMarket), "save must be new KVATimeToMarket()");
    }

    @Test
    void TestUpdateWithNullData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();
        EntityKVATimeToMarket entityKVATimeToMarket = new EntityKVATimeToMarket();
        when(kvaTimeToMarketCrudRepository.findById(1)).thenReturn(Optional.of(entityKVATimeToMarket));
        when(mapper.toKVATimeToMarket(entityKVATimeToMarket)).thenReturn(kvaTimeToMarket);
        when(kvaTimeToMarketCrudRepository.save(entityKVATimeToMarket)).thenReturn(entityKVATimeToMarket);

        assertEquals(Optional.of(kvaTimeToMarket), tester.update(1, kvaTimeToMarket), "update must be new KVATimeToMarket()");
    }

    @Test
    void TestUpdateWithEmptyData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();
        EntityKVATimeToMarket entityKVATimeToMarket = new EntityKVATimeToMarket();
        kvaTimeToMarket.setId(null);
        kvaTimeToMarket.setBuildAndIntegrationFrequency("");
        kvaTimeToMarket.setReleaseFrequency("");
        kvaTimeToMarket.setReleaseStabilizationPeriod("");
        kvaTimeToMarket.setMeanTimeToRepair("");
        kvaTimeToMarket.setCycleTime("");
        kvaTimeToMarket.setLeadTime("");
        kvaTimeToMarket.setTimeToLearn("");
        kvaTimeToMarket.setIdTeam(null);
        kvaTimeToMarket.setIdIteration(null);

        when(kvaTimeToMarketCrudRepository.findById(1)).thenReturn(Optional.of(entityKVATimeToMarket));
        when(mapper.toKVATimeToMarket(entityKVATimeToMarket)).thenReturn(kvaTimeToMarket);
        when(kvaTimeToMarketCrudRepository.save(entityKVATimeToMarket)).thenReturn(entityKVATimeToMarket);

        assertEquals(Optional.of(kvaTimeToMarket), tester.update(1, kvaTimeToMarket), "update must be new KVATimeToMarket()");
    }

    @Test
    void TestUpdateWithData() {
        KVATimeToMarket kvaTimeToMarket = new KVATimeToMarket();
        EntityKVATimeToMarket entityKVATimeToMarket = new EntityKVATimeToMarket();
        final Integer id = 42;
        final String buildAndIntegrationFrequency = "10 by week";
        final String releaseFrequency = "Monthly";
        final String releaseStabilizationPeriod = "3 days";
        final String meanTimeToRepair = "3/5";
        final String cycleTime = "1 month";
        final String leadTime = "3 months";
        final String timeToLearn = "1 month";
        final Integer idTeam = 2;
        final Integer idIteration = 6;

        kvaTimeToMarket.setId(id);
        kvaTimeToMarket.setBuildAndIntegrationFrequency(buildAndIntegrationFrequency);
        kvaTimeToMarket.setReleaseFrequency(releaseFrequency);
        kvaTimeToMarket.setReleaseStabilizationPeriod(releaseStabilizationPeriod);
        kvaTimeToMarket.setMeanTimeToRepair(meanTimeToRepair);
        kvaTimeToMarket.setCycleTime(cycleTime);
        kvaTimeToMarket.setLeadTime(leadTime);
        kvaTimeToMarket.setTimeToLearn(timeToLearn);
        kvaTimeToMarket.setIdTeam(idTeam);
        kvaTimeToMarket.setIdIteration(idIteration);

        when(kvaTimeToMarketCrudRepository.findById(1)).thenReturn(Optional.of(entityKVATimeToMarket));
        when(mapper.toKVATimeToMarket(entityKVATimeToMarket)).thenReturn(kvaTimeToMarket);
        when(kvaTimeToMarketCrudRepository.save(entityKVATimeToMarket)).thenReturn(entityKVATimeToMarket);

        assertEquals(Optional.of(kvaTimeToMarket), tester.update(1, kvaTimeToMarket), "update must be new KVATimeToMarket()");
    }
}

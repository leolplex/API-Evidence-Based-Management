package com.ebm.persistence;

import com.ebm.domain.KVAAbilityToInnovate;
import com.ebm.persistence.crud.KVAAbilityToInnovateCrudRepository;
import com.ebm.persistence.entity.EntityKVAAbilityToInnovate;
import com.ebm.persistence.mapper.KVAAbilityToInnovateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVAAbilityToInnovatePersistenceRepositoryTest {
    KVAAbilityToInnovatePersistenceRepository tester;
    KVAAbilityToInnovateCrudRepository kvaAbilityToInnovateCrudRepository;
    KVAAbilityToInnovateMapper mapper;

    @BeforeEach
    void initEach() {
        kvaAbilityToInnovateCrudRepository = Mockito.mock(KVAAbilityToInnovateCrudRepository.class);
        mapper = Mockito.mock(KVAAbilityToInnovateMapper.class);
        tester = new KVAAbilityToInnovatePersistenceRepository(kvaAbilityToInnovateCrudRepository, mapper);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVAAbilityToInnovate()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();
        EntityKVAAbilityToInnovate entityKVAAbilityToInnovate = new EntityKVAAbilityToInnovate();
        when(mapper.toKVAAbilityToInnovateDomain(kvaAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);
        when(mapper.toKVAAbilityToInnovate(entityKVAAbilityToInnovate)).thenReturn(kvaAbilityToInnovate);
        when(kvaAbilityToInnovateCrudRepository.save(entityKVAAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);

        assertEquals(kvaAbilityToInnovate, tester.save(kvaAbilityToInnovate), "save must be new KVAAbilityToInnovate()");
    }

    @Test
    void TestUpdateWithNullData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();
        EntityKVAAbilityToInnovate entityKVAAbilityToInnovate = new EntityKVAAbilityToInnovate();
        when(kvaAbilityToInnovateCrudRepository.findById(1)).thenReturn(Optional.of(entityKVAAbilityToInnovate));
        when(mapper.toKVAAbilityToInnovateDomain(kvaAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);
        when(mapper.toKVAAbilityToInnovate(entityKVAAbilityToInnovate)).thenReturn(kvaAbilityToInnovate);
        when(kvaAbilityToInnovateCrudRepository.save(entityKVAAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);

        assertEquals(Optional.of(kvaAbilityToInnovate), tester.update(1, kvaAbilityToInnovate), "update must be new KVAAbilityToInnovate()");
    }

    @Test
    void TestUpdateWithEmptyData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();
        EntityKVAAbilityToInnovate entityKVAAbilityToInnovate = new EntityKVAAbilityToInnovate();
        kvaAbilityToInnovate.setId(null);
        kvaAbilityToInnovate.setFeatureUsageIndex("");
        kvaAbilityToInnovate.setInnovationRate("");
        kvaAbilityToInnovate.setDefectTrends("");
        kvaAbilityToInnovate.setOnProductIndex("");
        kvaAbilityToInnovate.setInstalledVersionIndex("");
        kvaAbilityToInnovate.setTechnicalDebt("");
        kvaAbilityToInnovate.setProductionIncidentTrends("");
        kvaAbilityToInnovate.setActiveCodeBranchesTimeSpentMergingCodeBetweenBranches("");
        kvaAbilityToInnovate.setTimeSpentContextSwitching("");
        kvaAbilityToInnovate.setIdTeam(null);
        kvaAbilityToInnovate.setIdIteration(null);

        when(kvaAbilityToInnovateCrudRepository.findById(1)).thenReturn(Optional.of(entityKVAAbilityToInnovate));
        when(mapper.toKVAAbilityToInnovateDomain(kvaAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);
        when(mapper.toKVAAbilityToInnovate(entityKVAAbilityToInnovate)).thenReturn(kvaAbilityToInnovate);
        when(kvaAbilityToInnovateCrudRepository.save(entityKVAAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);

        assertEquals(Optional.of(kvaAbilityToInnovate), tester.update(1, kvaAbilityToInnovate), "update must be new KVAAbilityToInnovate()");
    }

    @Test
    void TestUpdateWithData() {
        KVAAbilityToInnovate kvaAbilityToInnovate = new KVAAbilityToInnovate();
        EntityKVAAbilityToInnovate entityKVAAbilityToInnovate = new EntityKVAAbilityToInnovate();
        kvaAbilityToInnovate.setId(1);
        kvaAbilityToInnovate.setFeatureUsageIndex("10%");
        kvaAbilityToInnovate.setInnovationRate("19%");
        kvaAbilityToInnovate.setDefectTrends("+19");
        kvaAbilityToInnovate.setOnProductIndex("60%");
        kvaAbilityToInnovate.setInstalledVersionIndex("3");
        kvaAbilityToInnovate.setTechnicalDebt("40h");
        kvaAbilityToInnovate.setProductionIncidentTrends("5");
        kvaAbilityToInnovate.setActiveCodeBranchesTimeSpentMergingCodeBetweenBranches("15");
        kvaAbilityToInnovate.setTimeSpentContextSwitching("3");
        kvaAbilityToInnovate.setIdTeam(2);
        kvaAbilityToInnovate.setIdIteration(6);

        when(kvaAbilityToInnovateCrudRepository.findById(1)).thenReturn(Optional.of(entityKVAAbilityToInnovate));
        when(mapper.toKVAAbilityToInnovateDomain(kvaAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);
        when(mapper.toKVAAbilityToInnovate(entityKVAAbilityToInnovate)).thenReturn(kvaAbilityToInnovate);
        when(kvaAbilityToInnovateCrudRepository.save(entityKVAAbilityToInnovate)).thenReturn(entityKVAAbilityToInnovate);

        assertEquals(Optional.of(kvaAbilityToInnovate), tester.update(1, kvaAbilityToInnovate), "update must be new KVAAbilityToInnovate()");
    }

}

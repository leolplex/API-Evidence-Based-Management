package com.ebm.persistence;

import com.ebm.domain.KVAUnrealizedValue;
import com.ebm.persistence.crud.KVAUnrealizedValueCrudRepository;
import com.ebm.persistence.entity.EntityKVAUnrealizedValue;
import com.ebm.persistence.mapper.KVAUnrealizedValueMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVAUnrealizedValuePersistenceRepositoryTest {
    KVAUnrealizedValuePersistenceRepository tester;
    KVAUnrealizedValueCrudRepository kvaUnrealizedValueCrudRepository;
    KVAUnrealizedValueMapper mapper;

    @BeforeEach
    void initEach() {
        kvaUnrealizedValueCrudRepository = Mockito.mock(KVAUnrealizedValueCrudRepository.class);
        mapper = Mockito.mock(KVAUnrealizedValueMapper.class);
        tester = new KVAUnrealizedValuePersistenceRepository(kvaUnrealizedValueCrudRepository, mapper);
    }

    @Test
    void TestGetByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getById(1), "getById must be Optional.empty()");
    }

    @Test
    void TestGetByIdWithData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        EntityKVAUnrealizedValue entityKVAUnrealizedValue = new EntityKVAUnrealizedValue();
        when(kvaUnrealizedValueCrudRepository.findById(1)).thenReturn(Optional.of(entityKVAUnrealizedValue));
        when(mapper.toKVAUnrealizedValue(entityKVAUnrealizedValue)).thenReturn(kvaUnrealizedValue);
        assertEquals(Optional.of(kvaUnrealizedValue), tester.getById(1), "getById must be Optional.of(new KVAUnrealizedValue())");
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVAUnrealizedValue()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        EntityKVAUnrealizedValue entityKVAUnrealizedValue = new EntityKVAUnrealizedValue();
        when(mapper.toKVAUnrealizedValueDomain(kvaUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);
        when(mapper.toKVAUnrealizedValue(entityKVAUnrealizedValue)).thenReturn(kvaUnrealizedValue);
        when(kvaUnrealizedValueCrudRepository.save(entityKVAUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);

        assertEquals(kvaUnrealizedValue, tester.save(kvaUnrealizedValue), "save must be new KVAUnrealizedValue()");
    }

    @Test
    void TestUpdateWithOutData() {
        assertEquals(Optional.empty(), tester.update(1, new KVAUnrealizedValue()), "update must be Optional.empty()");
    }

    @Test
    void TestUpdateWithNullData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        EntityKVAUnrealizedValue entityKVAUnrealizedValue = new EntityKVAUnrealizedValue();
        when(kvaUnrealizedValueCrudRepository.findById(1)).thenReturn(Optional.of(entityKVAUnrealizedValue));
        when(mapper.toKVAUnrealizedValue(entityKVAUnrealizedValue)).thenReturn(kvaUnrealizedValue);
        when(mapper.toKVAUnrealizedValueDomain(kvaUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);
        when(kvaUnrealizedValueCrudRepository.save(entityKVAUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);

        assertEquals(Optional.of(kvaUnrealizedValue), tester.update(1, kvaUnrealizedValue), "update must be new KVAUnrealizedValue()");
    }


    @Test
    void TestUpdateWithEmptyData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        EntityKVAUnrealizedValue entityKVAUnrealizedValue = new EntityKVAUnrealizedValue();
        kvaUnrealizedValue.setCustomerSatisfactionGap("");
        kvaUnrealizedValue.setMarketShare("");

        when(kvaUnrealizedValueCrudRepository.findById(1)).thenReturn(Optional.of(entityKVAUnrealizedValue));
        when(mapper.toKVAUnrealizedValue(entityKVAUnrealizedValue)).thenReturn(kvaUnrealizedValue);
        when(mapper.toKVAUnrealizedValueDomain(kvaUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);
        when(kvaUnrealizedValueCrudRepository.save(entityKVAUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);

        assertEquals(Optional.of(kvaUnrealizedValue), tester.update(1, kvaUnrealizedValue), "update must be new KVAUnrealizedValue()");
    }

    @Test
    void TestUpdateWithData() {
        KVAUnrealizedValue kvaUnrealizedValue = new KVAUnrealizedValue();
        EntityKVAUnrealizedValue entityKVAUnrealizedValue = new EntityKVAUnrealizedValue();
        kvaUnrealizedValue.setCustomerSatisfactionGap("My value");
        kvaUnrealizedValue.setMarketShare("My value");
        when(kvaUnrealizedValueCrudRepository.findById(1)).thenReturn(Optional.of(entityKVAUnrealizedValue));
        when(mapper.toKVAUnrealizedValue(entityKVAUnrealizedValue)).thenReturn(kvaUnrealizedValue);
        when(mapper.toKVAUnrealizedValueDomain(kvaUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);
        when(kvaUnrealizedValueCrudRepository.save(entityKVAUnrealizedValue)).thenReturn(entityKVAUnrealizedValue);

        assertEquals(Optional.of(kvaUnrealizedValue), tester.update(1, kvaUnrealizedValue), "update must be new KVAUnrealizedValue()");
    }

}

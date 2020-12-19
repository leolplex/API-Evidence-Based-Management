package com.ebm.persistence;

import com.ebm.domain.KVACurrentValue;
import com.ebm.domain.repository.KVACurrentValueRepository;
import com.ebm.persistence.crud.KVACurrentValueCrudRepository;
import com.ebm.persistence.entity.EntityKVACurrentValue;
import com.ebm.persistence.mapper.KVACurrentValueMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KVACurrentValuePersistenceRepositoryTest {
    KVACurrentValueRepository tester;
    KVACurrentValueCrudRepository kvaCurrentValueCrudRepository;
    KVACurrentValueMapper mapper;

    @BeforeEach()
    void initEach() {
        kvaCurrentValueCrudRepository = Mockito.mock(KVACurrentValueCrudRepository.class);
        mapper = Mockito.mock(KVACurrentValueMapper.class);
        tester = new KVACurrentValuePersistenceRepository(kvaCurrentValueCrudRepository, mapper);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new KVACurrentValue()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        EntityKVACurrentValue entityKVACurrentValue = new EntityKVACurrentValue();
        when(mapper.toKVACurrentValueDomain(kvaCurrentValue)).thenReturn(entityKVACurrentValue);
        when(mapper.toKVACurrentValue(entityKVACurrentValue)).thenReturn(kvaCurrentValue);
        when(kvaCurrentValueCrudRepository.save(entityKVACurrentValue)).thenReturn(entityKVACurrentValue);

        assertEquals(kvaCurrentValue, tester.save(kvaCurrentValue), "save must be new KVACurrentValue()");
    }


    @Test
    void TestUpdateWithNullData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        EntityKVACurrentValue entityKVACurrentValue = new EntityKVACurrentValue();
        when(kvaCurrentValueCrudRepository.findById(1)).thenReturn(Optional.of(entityKVACurrentValue));
        when(mapper.toKVACurrentValue(entityKVACurrentValue)).thenReturn(kvaCurrentValue);
        when(mapper.toKVACurrentValueDomain(kvaCurrentValue)).thenReturn(entityKVACurrentValue);
        when(kvaCurrentValueCrudRepository.save(entityKVACurrentValue)).thenReturn(entityKVACurrentValue);

        assertEquals(Optional.of(kvaCurrentValue), tester.update(1, kvaCurrentValue), "update must be new KVAUnrealizedValue()");
    }

    @Test
    void TestUpdateWithEmptyData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        EntityKVACurrentValue entityKVACurrentValue = new EntityKVACurrentValue();
        kvaCurrentValue.setId(null);
        kvaCurrentValue.setCustomerSatisfaction("");
        kvaCurrentValue.setCustomerUsageIndex("");
        kvaCurrentValue.setEmployeeSatisfaction("");
        kvaCurrentValue.setProductCostRatio("");
        kvaCurrentValue.setRevenuePerEmployee("");
        kvaCurrentValue.setIdTeam(null);
        kvaCurrentValue.setIdIteration(null);

        when(kvaCurrentValueCrudRepository.findById(1)).thenReturn(Optional.of(entityKVACurrentValue));
        when(mapper.toKVACurrentValue(entityKVACurrentValue)).thenReturn(kvaCurrentValue);
        when(mapper.toKVACurrentValueDomain(kvaCurrentValue)).thenReturn(entityKVACurrentValue);
        when(kvaCurrentValueCrudRepository.save(entityKVACurrentValue)).thenReturn(entityKVACurrentValue);

        assertEquals(Optional.of(kvaCurrentValue), tester.update(1, kvaCurrentValue), "update must be new KVAUnrealizedValue()");
    }


    @Test
    void TestUpdateWithData() {
        KVACurrentValue kvaCurrentValue = new KVACurrentValue();
        EntityKVACurrentValue entityKVACurrentValue = new EntityKVACurrentValue();
        final Integer id = 42;
        final String customerSatisfaction = "5/10";
        final String customerUsageIndex = "13";
        final String employeeSatisfaction = "7";
        final String productCostRatio = "134";
        final String revenuePerEmployee = "10000000";
        final int idTeam = 1;
        final int idIteration = 2;


        kvaCurrentValue.setId(id);
        kvaCurrentValue.setCustomerSatisfaction(customerSatisfaction);
        kvaCurrentValue.setCustomerUsageIndex(customerUsageIndex);
        kvaCurrentValue.setEmployeeSatisfaction(employeeSatisfaction);
        kvaCurrentValue.setProductCostRatio(productCostRatio);
        kvaCurrentValue.setRevenuePerEmployee(revenuePerEmployee);
        kvaCurrentValue.setIdTeam(idTeam);
        kvaCurrentValue.setIdIteration(idIteration);

        when(kvaCurrentValueCrudRepository.findById(1)).thenReturn(Optional.of(entityKVACurrentValue));
        when(mapper.toKVACurrentValue(entityKVACurrentValue)).thenReturn(kvaCurrentValue);
        when(mapper.toKVACurrentValueDomain(kvaCurrentValue)).thenReturn(entityKVACurrentValue);
        when(kvaCurrentValueCrudRepository.save(entityKVACurrentValue)).thenReturn(entityKVACurrentValue);

        assertEquals(Optional.of(kvaCurrentValue), tester.update(1, kvaCurrentValue), "update must be new KVAUnrealizedValue()");
    }




}

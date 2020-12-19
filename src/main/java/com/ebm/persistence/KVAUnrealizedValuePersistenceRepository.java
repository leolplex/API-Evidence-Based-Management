package com.ebm.persistence;

import com.ebm.domain.KVAUnrealizedValue;
import com.ebm.domain.repository.KVAUnrealizedValueRepository;
import com.ebm.persistence.crud.KVAUnrealizedValueCrudRepository;
import com.ebm.persistence.entity.EntityKVAUnrealizedValue;
import com.ebm.persistence.mapper.KVAUnrealizedValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KVAUnrealizedValuePersistenceRepository implements KVAUnrealizedValueRepository {
    @Autowired
    private final KVAUnrealizedValueCrudRepository kvaUnrealizedValueCrudRepository;
    @Autowired
    private final KVAUnrealizedValueMapper mapper;

    KVAUnrealizedValuePersistenceRepository(KVAUnrealizedValueCrudRepository kvaUnrealizedValueCrudRepository, KVAUnrealizedValueMapper kvaUnrealizedValueMapper) {
        this.kvaUnrealizedValueCrudRepository = kvaUnrealizedValueCrudRepository;
        this.mapper = kvaUnrealizedValueMapper;
    }

    @Override
    public Optional<KVAUnrealizedValue> getById(int idKVAUnrealizedValue) {
        return kvaUnrealizedValueCrudRepository.findById(idKVAUnrealizedValue).map(mapper::toKVAUnrealizedValue);
    }

    @Override
    public KVAUnrealizedValue save(KVAUnrealizedValue kvaUnrealizedValue) {
        EntityKVAUnrealizedValue entityKVAUnrealizedValue = mapper.toKVAUnrealizedValueDomain(kvaUnrealizedValue);
        return mapper.toKVAUnrealizedValue(kvaUnrealizedValueCrudRepository.save(entityKVAUnrealizedValue));
    }

    @Override
    public Optional<KVAUnrealizedValue> update(int idKVAUnrealizedValue, KVAUnrealizedValue kvaUnrealizedValue) {
        return kvaUnrealizedValueCrudRepository.findById(idKVAUnrealizedValue).map(kvaUnrealizedValueDB -> {

            kvaUnrealizedValue.setId(kvaUnrealizedValueDB.getEntityId());
            kvaUnrealizedValue.setIdIteration(kvaUnrealizedValueDB.getEntityIdIteration());
            kvaUnrealizedValue.setIdTeam(kvaUnrealizedValueDB.getEntityIdTeam());
            kvaUnrealizedValueDB = mapper.toKVAUnrealizedValueDomain(kvaUnrealizedValue);

            return mapper.toKVAUnrealizedValue(kvaUnrealizedValueCrudRepository.save(kvaUnrealizedValueDB));
        });
    }
}

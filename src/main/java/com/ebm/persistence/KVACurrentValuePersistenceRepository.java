package com.ebm.persistence;

import com.ebm.domain.KVACurrentValue;
import com.ebm.domain.repository.KVACurrentValueRepository;
import com.ebm.persistence.crud.KVACurrentValueCrudRepository;
import com.ebm.persistence.entity.EntityKVACurrentValue;
import com.ebm.persistence.mapper.KVACurrentValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KVACurrentValuePersistenceRepository implements KVACurrentValueRepository {
    @Autowired
    private final KVACurrentValueCrudRepository kvaCurrentValueCrudRepository;
    @Autowired
    private final KVACurrentValueMapper mapper;

    KVACurrentValuePersistenceRepository(KVACurrentValueCrudRepository kvaCurrentValueCrudRepository, KVACurrentValueMapper kvaCurrentValueMapper) {
        this.kvaCurrentValueCrudRepository = kvaCurrentValueCrudRepository;
        this.mapper = kvaCurrentValueMapper;
    }

    @Override
    public KVACurrentValue save(KVACurrentValue kvaCurrentValue) {
        EntityKVACurrentValue entityKVACurrentValue = mapper.toKVACurrentValueDomain(kvaCurrentValue);
        return mapper.toKVACurrentValue((kvaCurrentValueCrudRepository.save(entityKVACurrentValue)));
    }

    @Override
    public Optional<KVACurrentValue> update(int idKVACurrentValue, KVACurrentValue kvaCurrentValue) {
        return kvaCurrentValueCrudRepository.findById(idKVACurrentValue).map(kvaCurrentValueDB -> {

            kvaCurrentValue.setId(kvaCurrentValueDB.getEntityId());
            kvaCurrentValue.setIdIteration(kvaCurrentValueDB.getEntityIdIterationCV());
            kvaCurrentValue.setIdTeam(kvaCurrentValueDB.getEntityIdTeamCV());

            kvaCurrentValueDB = mapper.toKVACurrentValueDomain(kvaCurrentValue);

            return mapper.toKVACurrentValue((kvaCurrentValueCrudRepository.save(kvaCurrentValueDB)));
        });
    }
}

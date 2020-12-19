package com.ebm.persistence;

import com.ebm.domain.KVAAbilityToInnovate;
import com.ebm.domain.repository.KVAAbilityToInnovateRepository;
import com.ebm.persistence.crud.KVAAbilityToInnovateCrudRepository;
import com.ebm.persistence.entity.EntityKVAAbilityToInnovate;
import com.ebm.persistence.mapper.KVAAbilityToInnovateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KVAAbilityToInnovatePersistenceRepository implements KVAAbilityToInnovateRepository {
    @Autowired
    private final KVAAbilityToInnovateCrudRepository kvaAbilityToInnovateCrudRepository;
    @Autowired
    private final KVAAbilityToInnovateMapper mapper;

    KVAAbilityToInnovatePersistenceRepository(KVAAbilityToInnovateCrudRepository kvaAbilityToInnovateCrudRepository, KVAAbilityToInnovateMapper kvaAbilityToInnovateMapper) {
        this.kvaAbilityToInnovateCrudRepository = kvaAbilityToInnovateCrudRepository;
        this.mapper = kvaAbilityToInnovateMapper;
    }

    @Override
    public KVAAbilityToInnovate save(KVAAbilityToInnovate kvaAbilityToInnovate) {
        EntityKVAAbilityToInnovate entityKVAAbilityToInnovate = mapper.toKVAAbilityToInnovateDomain(kvaAbilityToInnovate);
        return mapper.toKVAAbilityToInnovate((kvaAbilityToInnovateCrudRepository.save(entityKVAAbilityToInnovate)));
    }

    @Override
    public Optional<KVAAbilityToInnovate> update(int idKVAAbilityToInnovate, KVAAbilityToInnovate kvaAbilityToInnovate) {
        return kvaAbilityToInnovateCrudRepository.findById(idKVAAbilityToInnovate).map(kvaAbilityToInnovateDB -> {

            kvaAbilityToInnovate.setId(kvaAbilityToInnovateDB.getEntityId());
            kvaAbilityToInnovate.setIdIteration(kvaAbilityToInnovateDB.getEntityIdIterationA2I());
            kvaAbilityToInnovate.setIdTeam(kvaAbilityToInnovateDB.getEntityIdTeamA2I());
            kvaAbilityToInnovateDB = mapper.toKVAAbilityToInnovateDomain(kvaAbilityToInnovate);


            return mapper.toKVAAbilityToInnovate(kvaAbilityToInnovateCrudRepository.save(kvaAbilityToInnovateDB));
        });
    }


}

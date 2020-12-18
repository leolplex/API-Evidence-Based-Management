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

            if (isEmptyOrNull(kvaAbilityToInnovate.getFeatureUsageIndex())) {
                kvaAbilityToInnovateDB.setEntityFeatureUsageIndex(kvaAbilityToInnovate.getFeatureUsageIndex());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getInnovationRate())) {
                kvaAbilityToInnovateDB.setEntityInnovationRate(kvaAbilityToInnovate.getInnovationRate());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getDefectTrends())) {
                kvaAbilityToInnovateDB.setEntityDefectTrends(kvaAbilityToInnovate.getDefectTrends());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getOnProductIndex())) {
                kvaAbilityToInnovateDB.setEntityOnProductIndex(kvaAbilityToInnovate.getOnProductIndex());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getInstalledVersionIndex())) {
                kvaAbilityToInnovateDB.setEntityInstalledVersionIndex(kvaAbilityToInnovate.getInstalledVersionIndex());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getTechnicalDebt())) {
                kvaAbilityToInnovateDB.setEntityTechnicalDebt(kvaAbilityToInnovate.getTechnicalDebt());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getProductionIncidentTrends())) {
                kvaAbilityToInnovateDB.setEntityProductionIncidentTrends(kvaAbilityToInnovate.getProductionIncidentTrends());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches())) {
                kvaAbilityToInnovateDB.setEntityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches(kvaAbilityToInnovate.getActiveCodeBranchesTimeSpentMergingCodeBetweenBranches());
            }
            if (isEmptyOrNull(kvaAbilityToInnovate.getTimeSpentContextSwitching())) {
                kvaAbilityToInnovateDB.setEntityTimeSpentContextSwitching(kvaAbilityToInnovate.getTimeSpentContextSwitching());
            }


            return mapper.toKVAAbilityToInnovate(kvaAbilityToInnovateCrudRepository.save(kvaAbilityToInnovateDB));
        });
    }

    private boolean isEmptyOrNull(String value) {
        return value != null && !value.isEmpty();
    }

}

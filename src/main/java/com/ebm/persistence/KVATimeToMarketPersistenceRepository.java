package com.ebm.persistence;

import com.ebm.domain.KVATimeToMarket;
import com.ebm.domain.repository.KVATimeToMarketRepository;
import com.ebm.persistence.crud.KVATimeToMarketCrudRepository;
import com.ebm.persistence.entity.EntityKVATimeToMarket;
import com.ebm.persistence.mapper.KVATimeToMarketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KVATimeToMarketPersistenceRepository implements KVATimeToMarketRepository {
    @Autowired
    private final KVATimeToMarketCrudRepository kvaTimeToMarketCrudRepository;
    @Autowired
    private final KVATimeToMarketMapper mapper;

    KVATimeToMarketPersistenceRepository(KVATimeToMarketCrudRepository kvaTimeToMarketCrudRepository, KVATimeToMarketMapper kvaTimeToMarketMapper) {
        this.kvaTimeToMarketCrudRepository = kvaTimeToMarketCrudRepository;
        this.mapper = kvaTimeToMarketMapper;
    }

    @Override
    public KVATimeToMarket save(KVATimeToMarket kvaTimeToMarket) {
        EntityKVATimeToMarket entityKVATimeToMarket = mapper.toKVATimeToMarketDomain(kvaTimeToMarket);
        return mapper.toKVATimeToMarket((kvaTimeToMarketCrudRepository.save(entityKVATimeToMarket)));
    }

    @Override
    public Optional<KVATimeToMarket> update(int idKVATimeToMarket, KVATimeToMarket kvaTimeToMarket) {
        return kvaTimeToMarketCrudRepository.findById(idKVATimeToMarket).map(kvaTimeToMarketDB -> {
            if (kvaTimeToMarket.getBuildAndIntegrationFrequency() != null && !kvaTimeToMarket.getBuildAndIntegrationFrequency().isEmpty()) {
                kvaTimeToMarketDB.setEntityBuildAndIntegrationFrequency(kvaTimeToMarket.getBuildAndIntegrationFrequency());
            }
            if (kvaTimeToMarket.getReleaseFrequency() != null && !kvaTimeToMarket.getReleaseFrequency().isEmpty()) {
                kvaTimeToMarketDB.setEntityReleaseFrequency(kvaTimeToMarket.getReleaseFrequency());
            }
            if (kvaTimeToMarket.getReleaseStabilizationPeriod() != null && !kvaTimeToMarket.getReleaseStabilizationPeriod().isEmpty()) {
                kvaTimeToMarketDB.setEntityReleaseStabilizationPeriod(kvaTimeToMarket.getReleaseStabilizationPeriod());
            }
            if (kvaTimeToMarket.getMeanTimeToRepair() != null && !kvaTimeToMarket.getMeanTimeToRepair().isEmpty()) {
                kvaTimeToMarketDB.setEntityMeanTimeToRepair(kvaTimeToMarket.getMeanTimeToRepair());
            }
            if (kvaTimeToMarket.getCycleTime() != null && !kvaTimeToMarket.getCycleTime().isEmpty()) {
                kvaTimeToMarketDB.setEntityCycleTime(kvaTimeToMarket.getCycleTime());
            }
            if (kvaTimeToMarket.getLeadTime() != null && !kvaTimeToMarket.getLeadTime().isEmpty()) {
                kvaTimeToMarketDB.setEntityLeadTime(kvaTimeToMarket.getLeadTime());
            }
            if (kvaTimeToMarket.getTimeToLearn() != null && !kvaTimeToMarket.getTimeToLearn().isEmpty()) {
                kvaTimeToMarketDB.setEntityTimeToLearn(kvaTimeToMarket.getTimeToLearn());
            }

            return mapper.toKVATimeToMarket((kvaTimeToMarketCrudRepository.save(kvaTimeToMarketDB)));
        });
    }
}

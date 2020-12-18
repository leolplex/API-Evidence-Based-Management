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
            if (isEmptyOrNull(kvaTimeToMarket.getBuildAndIntegrationFrequency())) {
                kvaTimeToMarketDB.setEntityBuildAndIntegrationFrequency(kvaTimeToMarket.getBuildAndIntegrationFrequency());
            }
            if (isEmptyOrNull(kvaTimeToMarket.getReleaseFrequency())) {
                kvaTimeToMarketDB.setEntityReleaseFrequency(kvaTimeToMarket.getReleaseFrequency());
            }
            if (isEmptyOrNull(kvaTimeToMarket.getReleaseStabilizationPeriod())) {
                kvaTimeToMarketDB.setEntityReleaseStabilizationPeriod(kvaTimeToMarket.getReleaseStabilizationPeriod());
            }
            if (isEmptyOrNull(kvaTimeToMarket.getMeanTimeToRepair())) {
                kvaTimeToMarketDB.setEntityMeanTimeToRepair(kvaTimeToMarket.getMeanTimeToRepair());
            }
            if (isEmptyOrNull(kvaTimeToMarket.getCycleTime())) {
                kvaTimeToMarketDB.setEntityCycleTime(kvaTimeToMarket.getCycleTime());
            }
            if (isEmptyOrNull(kvaTimeToMarket.getLeadTime())) {
                kvaTimeToMarketDB.setEntityLeadTime(kvaTimeToMarket.getLeadTime());
            }
            if (isEmptyOrNull(kvaTimeToMarket.getTimeToLearn())) {
                kvaTimeToMarketDB.setEntityTimeToLearn(kvaTimeToMarket.getTimeToLearn());
            }

            return mapper.toKVATimeToMarket((kvaTimeToMarketCrudRepository.save(kvaTimeToMarketDB)));
        });
    }

    private boolean isEmptyOrNull(String value) {
        return value != null && !value.isEmpty();
    }

}

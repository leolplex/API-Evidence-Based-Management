package com.ebm.domain.service;

import com.ebm.domain.KVATimeToMarket;
import com.ebm.domain.repository.KVATimeToMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KVATimeToMarketService {
    @Autowired
    private final KVATimeToMarketRepository kvaTimeToMarketRepository;

    KVATimeToMarketService(KVATimeToMarketRepository kvaTimeToMarketRepository) {
        this.kvaTimeToMarketRepository = kvaTimeToMarketRepository;
    }

    public KVATimeToMarket save(KVATimeToMarket kvaTimeToMarket) {
        return kvaTimeToMarketRepository.save(kvaTimeToMarket);
    }

    public Optional<KVATimeToMarket> update(int idKVATimeToMarket, KVATimeToMarket kvaTimeToMarket) {
        return kvaTimeToMarketRepository.update(idKVATimeToMarket, kvaTimeToMarket);
    }


}

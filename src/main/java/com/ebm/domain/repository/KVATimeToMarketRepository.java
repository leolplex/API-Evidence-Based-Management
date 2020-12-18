package com.ebm.domain.repository;

import com.ebm.domain.KVATimeToMarket;

import java.util.Optional;

public interface KVATimeToMarketRepository {
    KVATimeToMarket save(KVATimeToMarket kvaTimeToMarket);

    Optional<KVATimeToMarket> update(int idKVATimeToMarket, KVATimeToMarket kvaTimeToMarket);
}

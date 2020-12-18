package com.ebm.domain.repository;

import com.ebm.domain.KVAAbilityToInnovate;

import java.util.Optional;

public interface KVAAbilityToInnovateRepository {
    KVAAbilityToInnovate save(KVAAbilityToInnovate kvaAbilityToInnovate);

    Optional<KVAAbilityToInnovate> update(int idKVAAbilityToInnovate, KVAAbilityToInnovate kvaAbilityToInnovate);
}

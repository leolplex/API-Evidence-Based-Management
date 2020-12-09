package com.ebm.domain.repository;

import com.ebm.domain.KVAUnrealizedValue;

import java.util.Optional;

public interface KVAUnrealizedValueRepository {
    Optional<KVAUnrealizedValue> getById(int idKVAUnrealizedValue);

    KVAUnrealizedValue save(KVAUnrealizedValue kvaUnrealizedValue);

    Optional<KVAUnrealizedValue> update(int idKVAUnrealizedValue, KVAUnrealizedValue kvaUnrealizedValue);
}

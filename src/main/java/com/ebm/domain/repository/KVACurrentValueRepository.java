package com.ebm.domain.repository;

import com.ebm.domain.KVACurrentValue;

import java.util.Optional;

public interface KVACurrentValueRepository {
    KVACurrentValue save(KVACurrentValue kvaCurrentValue);
    Optional<KVACurrentValue> update(int idKVACurrentValue, KVACurrentValue kvaCurrentValue);
}

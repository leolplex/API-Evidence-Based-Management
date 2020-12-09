package com.ebm.domain.service;

import com.ebm.domain.KVAUnrealizedValue;
import com.ebm.domain.repository.KVAUnrealizedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KVAUnrealizedValueService {
    @Autowired
    private final KVAUnrealizedValueRepository kvaUnrealizedValueRepository;

    KVAUnrealizedValueService(KVAUnrealizedValueRepository kvaUnrealizedValueRepository) {
        this.kvaUnrealizedValueRepository = kvaUnrealizedValueRepository;
    }

    public Optional<KVAUnrealizedValue> getById(int idKVAUnrealizedValue) {
        return kvaUnrealizedValueRepository.getById(idKVAUnrealizedValue);
    }

    public KVAUnrealizedValue save(KVAUnrealizedValue kvaUnrealizedValue) {
        return kvaUnrealizedValueRepository.save(kvaUnrealizedValue);
    }

    public Optional<KVAUnrealizedValue> update(int idKVAUnrealizedValue, KVAUnrealizedValue kvaUnrealizedValue) {
        return kvaUnrealizedValueRepository.update(idKVAUnrealizedValue, kvaUnrealizedValue);
    }

}

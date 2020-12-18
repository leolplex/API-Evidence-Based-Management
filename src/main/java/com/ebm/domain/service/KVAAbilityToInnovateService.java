package com.ebm.domain.service;

import com.ebm.domain.KVAAbilityToInnovate;
import com.ebm.domain.repository.KVAAbilityToInnovateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KVAAbilityToInnovateService {
    @Autowired
    private final KVAAbilityToInnovateRepository kvaAbilityToInnovateRepository;

    KVAAbilityToInnovateService(KVAAbilityToInnovateRepository kvaAbilityToInnovateRepository) {
        this.kvaAbilityToInnovateRepository = kvaAbilityToInnovateRepository;
    }

    public KVAAbilityToInnovate save(KVAAbilityToInnovate kvaAbilityToInnovate) {
        return kvaAbilityToInnovateRepository.save(kvaAbilityToInnovate);
    }

    public Optional<KVAAbilityToInnovate> update(int idKVAAbilityToInnovate, KVAAbilityToInnovate kvaAbilityToInnovate) {
        return kvaAbilityToInnovateRepository.update(idKVAAbilityToInnovate, kvaAbilityToInnovate);
    }
}

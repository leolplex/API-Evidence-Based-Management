package com.ebm.domain.service;

import com.ebm.domain.KVACurrentValue;
import com.ebm.domain.repository.KVACurrentValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KVACurrentValueService {
    @Autowired
    private final KVACurrentValueRepository kvaCurrentValueRepository;

    KVACurrentValueService(KVACurrentValueRepository kvaCurrentValueRepository){
        this.kvaCurrentValueRepository = kvaCurrentValueRepository;
    }

    public KVACurrentValue save(KVACurrentValue kvaCurrentValue){
        return  kvaCurrentValueRepository.save(kvaCurrentValue);
    }
    public Optional<KVACurrentValue> update(int idKVACurrentValue, KVACurrentValue kvaCurrentValue){
        return kvaCurrentValueRepository.update(idKVACurrentValue,kvaCurrentValue);
    }
}

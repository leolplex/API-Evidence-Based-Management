package com.ebm.persistence;

import com.ebm.domain.KVACurrentValue;
import com.ebm.domain.repository.KVACurrentValueRepository;
import com.ebm.persistence.crud.KVACurrentValueCrudRepository;
import com.ebm.persistence.entity.EntityKVACurrentValue;
import com.ebm.persistence.mapper.KVACurrentValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KVACurrentValuePersistenceRepository implements KVACurrentValueRepository {
    @Autowired
    private  final KVACurrentValueCrudRepository kvaCurrentValueCrudRepository;
    @Autowired
    private final KVACurrentValueMapper mapper;

    KVACurrentValuePersistenceRepository( KVACurrentValueCrudRepository kvaCurrentValueCrudRepository, KVACurrentValueMapper kvaCurrentValueMapper){
        this.kvaCurrentValueCrudRepository = kvaCurrentValueCrudRepository;
        this.mapper = kvaCurrentValueMapper;
    }

    @Override
    public KVACurrentValue save(KVACurrentValue kvaCurrentValue) {
        EntityKVACurrentValue entityKVACurrentValue = mapper.toKVACurrentValueDomain(kvaCurrentValue);
        return mapper.toKVACurrentValue((kvaCurrentValueCrudRepository.save(entityKVACurrentValue)));
    }

    @Override
    public Optional<KVACurrentValue> update(int idKVACurrentValue, KVACurrentValue kvaCurrentValue) {
        return kvaCurrentValueCrudRepository.findById(idKVACurrentValue).map(kvaCurrentValueDB->{
            if (kvaCurrentValue.getRevenuePerEmployee() != null && !kvaCurrentValue.getRevenuePerEmployee().isEmpty()){
                kvaCurrentValueDB.setEntityRevenuePerEmployee(kvaCurrentValue.getRevenuePerEmployee());
            }
            if (kvaCurrentValue.getProductCostRatio() != null && !kvaCurrentValue.getProductCostRatio().isEmpty()){
                kvaCurrentValueDB.setEntityProductCostRatio(kvaCurrentValue.getProductCostRatio());
            }

            if (kvaCurrentValue.getEmployeeSatisfaction() != null && !kvaCurrentValue.getEmployeeSatisfaction().isEmpty()){
                kvaCurrentValueDB.setEntityEmployeeSatisfaction(kvaCurrentValue.getEmployeeSatisfaction());
            }

            if (kvaCurrentValue.getCustomerSatisfaction() != null && !kvaCurrentValue.getCustomerSatisfaction().isEmpty()){
                kvaCurrentValueDB.setEntityCustomerSatisfaction(kvaCurrentValue.getCustomerSatisfaction());
            }
            if (kvaCurrentValue.getCustomerUsageIndex() != null && !kvaCurrentValue.getCustomerUsageIndex().isEmpty()){
                kvaCurrentValueDB.setEntityCustomerUsageIndex(kvaCurrentValue.getCustomerUsageIndex());
            }

            return mapper.toKVACurrentValue((kvaCurrentValueCrudRepository.save(kvaCurrentValueDB)));
        });
    }
}

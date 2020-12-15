package com.ebm.persistence.mapper;

import com.ebm.domain.KVACurrentValue;
import com.ebm.persistence.entity.EntityKVACurrentValue;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

public interface KVACurrentValueMapper {

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityRevenuePerEmployee", target = "revenuePerEmployee")
    @Mapping(source = "entityProductCostRatio", target = "productCostRatio")
    @Mapping(source = "entityEmployeeSatisfaction", target = "employeeSatisfaction")
    @Mapping(source = "entityCustomerSatisfaction", target = "customerSatisfaction")
    @Mapping(source = "entityCustomerUsageIndex", target = "customerUsageIndex")
    @Mapping(source = "entityIdIteration", target = "idIteration")
    @Mapping(source = "entityIdTeam", target = "idTeam")
    KVACurrentValue toKVACurrentValue(EntityKVACurrentValue entityKVACurrentValue);

    @InheritInverseConfiguration
    EntityKVACurrentValue toKVACurrentValueDomain(KVACurrentValue kvaCurrentValue);

}

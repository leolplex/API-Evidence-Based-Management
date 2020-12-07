package com.ebm.persistence.mapper;

import com.ebm.domain.IterationDomain;
import com.ebm.persistence.entity.EntityIteration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IterationMapper {

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityName", target = "name")
    @Mapping(source = "entityGoal", target = "goal")
    @Mapping(source = "entityStartDate", target = "startDate")
    @Mapping(source = "entityEndDate", target = "endDate")
    @Mapping(source = "entityState", target = "state")
    @Mapping(source = "entityKVAUnrealizedValue.entityId", target = "kva.kvaUnrealizedValue.id")
    @Mapping(source = "entityKVAUnrealizedValue.entityMarketShare", target = "kva.kvaUnrealizedValue.marketShare")
    @Mapping(source = "entityKVAUnrealizedValue.entityCustomerSatisfactionGap", target = "kva.kvaUnrealizedValue.customerSatisfactionGap")
    @Mapping(source = "entityKVACurrentValue.entityId", target = "kva.kvaCurrentValue.id")
    @Mapping(source = "entityKVACurrentValue.entityRevenuePerEmployee", target = "kva.kvaCurrentValue.revenuePerEmployee")
    @Mapping(source = "entityKVACurrentValue.entityProductCostRatio", target = "kva.kvaCurrentValue.productCostRatio")
    @Mapping(source = "entityKVACurrentValue.entityEmployeeSatisfaction", target = "kva.kvaCurrentValue.employeeSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerSatisfaction", target = "kva.kvaCurrentValue.customerSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerUsageIndex", target = "kva.kvaCurrentValue.customerUsageIndex")
    List<IterationDomain> toIterations(List<EntityIteration> iteration);

    @InheritInverseConfiguration
    List<EntityIteration> toIterationsDomain(List<IterationDomain> iterationDomain);

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityName", target = "name")
    @Mapping(source = "entityGoal", target = "goal")
    @Mapping(source = "entityStartDate", target = "startDate")
    @Mapping(source = "entityEndDate", target = "endDate")
    @Mapping(source = "entityState", target = "state")
    @Mapping(source = "entityKVAUnrealizedValue.entityId", target = "kva.kvaUnrealizedValue.id")
    @Mapping(source = "entityKVAUnrealizedValue.entityMarketShare", target = "kva.kvaUnrealizedValue.marketShare")
    @Mapping(source = "entityKVAUnrealizedValue.entityCustomerSatisfactionGap", target = "kva.kvaUnrealizedValue.customerSatisfactionGap")
    @Mapping(source = "entityKVACurrentValue.entityId", target = "kva.kvaCurrentValue.id")
    @Mapping(source = "entityKVACurrentValue.entityRevenuePerEmployee", target = "kva.kvaCurrentValue.revenuePerEmployee")
    @Mapping(source = "entityKVACurrentValue.entityProductCostRatio", target = "kva.kvaCurrentValue.productCostRatio")
    @Mapping(source = "entityKVACurrentValue.entityEmployeeSatisfaction", target = "kva.kvaCurrentValue.employeeSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerSatisfaction", target = "kva.kvaCurrentValue.customerSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerUsageIndex", target = "kva.kvaCurrentValue.customerUsageIndex")
    IterationDomain toIteration(EntityIteration iteration);

    @InheritInverseConfiguration
    @Mapping(target = "entityKVAUnrealizedValue", ignore = true)
    @Mapping(target = "entityKVACurrentValue", ignore = true)
    EntityIteration toIterationDomain(IterationDomain iterationDomain);
}

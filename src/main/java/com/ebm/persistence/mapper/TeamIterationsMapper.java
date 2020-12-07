package com.ebm.persistence.mapper;

import com.ebm.domain.Iteration;
import com.ebm.persistence.entity.EntityIterationTeam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IterationMapper.class})
public interface TeamIterationsMapper {

    @Mapping(source = "entityId.idIteration", target = "id")
    @Mapping(source = "entityIteration.entityName", target = "name")
    @Mapping(source = "entityIteration.entityGoal", target = "goal")
    @Mapping(source = "entityIteration.entityStartDate", target = "startDate")
    @Mapping(source = "entityIteration.entityEndDate", target = "endDate")
    @Mapping(source = "entityIteration.entityState", target = "state")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityId", target = "kva.kvaUnrealizedValue.id")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityMarketShare", target = "kva.kvaUnrealizedValue.marketShare")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityCustomerSatisfactionGap", target = "kva.kvaUnrealizedValue.customerSatisfactionGap")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityId", target = "kva.kvaCurrentValue.id")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityRevenuePerEmployee", target = "kva.kvaCurrentValue.revenuePerEmployee")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityProductCostRatio", target = "kva.kvaCurrentValue.productCostRatio")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityEmployeeSatisfaction", target = "kva.kvaCurrentValue.employeeSatisfaction")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityCustomerSatisfaction", target = "kva.kvaCurrentValue.customerSatisfaction")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityCustomerUsageIndex", target = "kva.kvaCurrentValue.customerUsageIndex")
    Iteration toTeamIteration(EntityIterationTeam iteration);


}

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
    @Mapping(source = "entityIteration.entityIdTeam", target = "idTeam")

    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityId", target = "kva.kvaUnrealizedValue.id")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityMarketShare", target = "kva.kvaUnrealizedValue.marketShare")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityCustomerSatisfactionGap", target = "kva.kvaUnrealizedValue.customerSatisfactionGap")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityIdIteration", target = "kva.kvaUnrealizedValue.idIteration")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityIdTeam", target = "kva.kvaUnrealizedValue.idTeam")

    @Mapping(source = "entityIteration.entityKVACurrentValue.entityId", target = "kva.kvaCurrentValue.id")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityRevenuePerEmployee", target = "kva.kvaCurrentValue.revenuePerEmployee")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityProductCostRatio", target = "kva.kvaCurrentValue.productCostRatio")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityEmployeeSatisfaction", target = "kva.kvaCurrentValue.employeeSatisfaction")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityCustomerSatisfaction", target = "kva.kvaCurrentValue.customerSatisfaction")
    @Mapping(source = "entityIteration.entityKVACurrentValue.entityCustomerUsageIndex", target = "kva.kvaCurrentValue.customerUsageIndex")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityIdIteration", target = "kva.kvaCurrentValue.idIteration")
    @Mapping(source = "entityIteration.entityKVAUnrealizedValue.entityIdTeam", target = "kva.kvaCurrentValue.idTeam")


    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityId", target = "kva.kvaAbilityToInnovate.id")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityFeatureUsageIndex", target = "kva.kvaAbilityToInnovate.featureUsageIndex")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityInnovationRate", target = "kva.kvaAbilityToInnovate.innovationRate")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityDefectTrends", target = "kva.kvaAbilityToInnovate.defectTrends")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityOnProductIndex", target = "kva.kvaAbilityToInnovate.onProductIndex")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityInstalledVersionIndex", target = "kva.kvaAbilityToInnovate.installedVersionIndex")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityTechnicalDebt", target = "kva.kvaAbilityToInnovate.technicalDebt")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityProductionIncidentTrends", target = "kva.kvaAbilityToInnovate.productionIncidentTrends")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches", target = "kva.kvaAbilityToInnovate.activeCodeBranchesTimeSpentMergingCodeBetweenBranches")
    @Mapping(source = "entityIteration.entityKVAAbilityToInnovate.entityTimeSpentContextSwitching", target = "kva.kvaAbilityToInnovate.timeSpentContextSwitching")

    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityId", target = "kva.kvaTimeToMarket.id")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityBuildAndIntegrationFrequency", target = "kva.kvaTimeToMarket.buildAndIntegrationFrequency")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityReleaseFrequency", target = "kva.kvaTimeToMarket.releaseFrequency")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityReleaseStabilizationPeriod", target = "kva.kvaTimeToMarket.releaseStabilizationPeriod")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityMeanTimeToRepair", target = "kva.kvaTimeToMarket.meanTimeToRepair")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityCycleTime", target = "kva.kvaTimeToMarket.cycleTime")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityLeadTime", target = "kva.kvaTimeToMarket.leadTime")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityTimeToLearn", target = "kva.kvaTimeToMarket.timeToLearn")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityIdTeamT2M", target = "kva.kvaTimeToMarket.idTeam")
    @Mapping(source = "entityIteration.entityKVATimeToMarket.entityIdIterationT2M", target = "kva.kvaTimeToMarket.idIteration")
    Iteration toTeamIteration(EntityIterationTeam iteration);


}


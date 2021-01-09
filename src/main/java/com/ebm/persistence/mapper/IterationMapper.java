package com.ebm.persistence.mapper;

import com.ebm.domain.Iteration;
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
    @Mapping(source = "entityIdProduct", target = "idProduct")

    @Mapping(source = "entityKVAUnrealizedValue.entityId", target = "kva.kvaUnrealizedValue.id")
    @Mapping(source = "entityKVAUnrealizedValue.entityMarketShare", target = "kva.kvaUnrealizedValue.marketShare")
    @Mapping(source = "entityKVAUnrealizedValue.entityCustomerSatisfactionGap", target = "kva.kvaUnrealizedValue.customerSatisfactionGap")
    @Mapping(source = "entityKVAUnrealizedValue.entityIdIteration", target = "kva.kvaUnrealizedValue.idIteration")
    @Mapping(source = "entityKVAUnrealizedValue.entityIdTeam", target = "kva.kvaUnrealizedValue.idTeam")

    @Mapping(source = "entityKVACurrentValue.entityId", target = "kva.kvaCurrentValue.id")
    @Mapping(source = "entityKVACurrentValue.entityRevenuePerEmployee", target = "kva.kvaCurrentValue.revenuePerEmployee")
    @Mapping(source = "entityKVACurrentValue.entityProductCostRatio", target = "kva.kvaCurrentValue.productCostRatio")
    @Mapping(source = "entityKVACurrentValue.entityEmployeeSatisfaction", target = "kva.kvaCurrentValue.employeeSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerSatisfaction", target = "kva.kvaCurrentValue.customerSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerUsageIndex", target = "kva.kvaCurrentValue.customerUsageIndex")

    @Mapping(source = "entityKVAAbilityToInnovate.entityId", target = "kva.kvaAbilityToInnovate.id")
    @Mapping(source = "entityKVAAbilityToInnovate.entityFeatureUsageIndex", target = "kva.kvaAbilityToInnovate.featureUsageIndex")
    @Mapping(source = "entityKVAAbilityToInnovate.entityInnovationRate", target = "kva.kvaAbilityToInnovate.innovationRate")
    @Mapping(source = "entityKVAAbilityToInnovate.entityDefectTrends", target = "kva.kvaAbilityToInnovate.defectTrends")
    @Mapping(source = "entityKVAAbilityToInnovate.entityOnProductIndex", target = "kva.kvaAbilityToInnovate.onProductIndex")
    @Mapping(source = "entityKVAAbilityToInnovate.entityInstalledVersionIndex", target = "kva.kvaAbilityToInnovate.installedVersionIndex")
    @Mapping(source = "entityKVAAbilityToInnovate.entityTechnicalDebt", target = "kva.kvaAbilityToInnovate.technicalDebt")
    @Mapping(source = "entityKVAAbilityToInnovate.entityProductionIncidentTrends", target = "kva.kvaAbilityToInnovate.productionIncidentTrends")
    @Mapping(source = "entityKVAAbilityToInnovate.entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches", target = "kva.kvaAbilityToInnovate.activeCodeBranchesTimeSpentMergingCodeBetweenBranches")
    @Mapping(source = "entityKVAAbilityToInnovate.entityTimeSpentContextSwitching", target = "kva.kvaAbilityToInnovate.timeSpentContextSwitching")

    @Mapping(source = "entityKVATimeToMarket.entityId", target = "kva.kvaTimeToMarket.id")
    @Mapping(source = "entityKVATimeToMarket.entityBuildAndIntegrationFrequency", target = "kva.kvaTimeToMarket.buildAndIntegrationFrequency")
    @Mapping(source = "entityKVATimeToMarket.entityReleaseFrequency", target = "kva.kvaTimeToMarket.releaseFrequency")
    @Mapping(source = "entityKVATimeToMarket.entityReleaseStabilizationPeriod", target = "kva.kvaTimeToMarket.releaseStabilizationPeriod")
    @Mapping(source = "entityKVATimeToMarket.entityMeanTimeToRepair", target = "kva.kvaTimeToMarket.meanTimeToRepair")
    @Mapping(source = "entityKVATimeToMarket.entityCycleTime", target = "kva.kvaTimeToMarket.cycleTime")
    @Mapping(source = "entityKVATimeToMarket.entityLeadTime", target = "kva.kvaTimeToMarket.leadTime")
    @Mapping(source = "entityKVATimeToMarket.entityTimeToLearn", target = "kva.kvaTimeToMarket.timeToLearn")
    List<Iteration> toIterations(List<EntityIteration> iteration);

    @InheritInverseConfiguration
    List<EntityIteration> toIterationsDomain(List<Iteration> iteration);

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityName", target = "name")
    @Mapping(source = "entityGoal", target = "goal")
    @Mapping(source = "entityStartDate", target = "startDate")
    @Mapping(source = "entityEndDate", target = "endDate")
    @Mapping(source = "entityState", target = "state")
    @Mapping(source = "entityIdProduct", target = "idProduct")

    @Mapping(source = "entityKVAUnrealizedValue.entityId", target = "kva.kvaUnrealizedValue.id")
    @Mapping(source = "entityKVAUnrealizedValue.entityMarketShare", target = "kva.kvaUnrealizedValue.marketShare")
    @Mapping(source = "entityKVAUnrealizedValue.entityCustomerSatisfactionGap", target = "kva.kvaUnrealizedValue.customerSatisfactionGap")
    @Mapping(source = "entityKVAUnrealizedValue.entityIdIteration", target = "kva.kvaUnrealizedValue.idIteration")
    @Mapping(source = "entityKVAUnrealizedValue.entityIdTeam", target = "kva.kvaUnrealizedValue.idTeam")

    @Mapping(source = "entityKVACurrentValue.entityId", target = "kva.kvaCurrentValue.id")
    @Mapping(source = "entityKVACurrentValue.entityRevenuePerEmployee", target = "kva.kvaCurrentValue.revenuePerEmployee")
    @Mapping(source = "entityKVACurrentValue.entityProductCostRatio", target = "kva.kvaCurrentValue.productCostRatio")
    @Mapping(source = "entityKVACurrentValue.entityEmployeeSatisfaction", target = "kva.kvaCurrentValue.employeeSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerSatisfaction", target = "kva.kvaCurrentValue.customerSatisfaction")
    @Mapping(source = "entityKVACurrentValue.entityCustomerUsageIndex", target = "kva.kvaCurrentValue.customerUsageIndex")

    @Mapping(source = "entityKVAAbilityToInnovate.entityId", target = "kva.kvaAbilityToInnovate.id")
    @Mapping(source = "entityKVAAbilityToInnovate.entityFeatureUsageIndex", target = "kva.kvaAbilityToInnovate.featureUsageIndex")
    @Mapping(source = "entityKVAAbilityToInnovate.entityInnovationRate", target = "kva.kvaAbilityToInnovate.innovationRate")
    @Mapping(source = "entityKVAAbilityToInnovate.entityDefectTrends", target = "kva.kvaAbilityToInnovate.defectTrends")
    @Mapping(source = "entityKVAAbilityToInnovate.entityOnProductIndex", target = "kva.kvaAbilityToInnovate.onProductIndex")
    @Mapping(source = "entityKVAAbilityToInnovate.entityInstalledVersionIndex", target = "kva.kvaAbilityToInnovate.installedVersionIndex")
    @Mapping(source = "entityKVAAbilityToInnovate.entityTechnicalDebt", target = "kva.kvaAbilityToInnovate.technicalDebt")
    @Mapping(source = "entityKVAAbilityToInnovate.entityProductionIncidentTrends", target = "kva.kvaAbilityToInnovate.productionIncidentTrends")
    @Mapping(source = "entityKVAAbilityToInnovate.entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches", target = "kva.kvaAbilityToInnovate.activeCodeBranchesTimeSpentMergingCodeBetweenBranches")
    @Mapping(source = "entityKVAAbilityToInnovate.entityTimeSpentContextSwitching", target = "kva.kvaAbilityToInnovate.timeSpentContextSwitching")

    @Mapping(source = "entityKVATimeToMarket.entityId", target = "kva.kvaTimeToMarket.id")
    @Mapping(source = "entityKVATimeToMarket.entityBuildAndIntegrationFrequency", target = "kva.kvaTimeToMarket.buildAndIntegrationFrequency")
    @Mapping(source = "entityKVATimeToMarket.entityReleaseFrequency", target = "kva.kvaTimeToMarket.releaseFrequency")
    @Mapping(source = "entityKVATimeToMarket.entityReleaseStabilizationPeriod", target = "kva.kvaTimeToMarket.releaseStabilizationPeriod")
    @Mapping(source = "entityKVATimeToMarket.entityMeanTimeToRepair", target = "kva.kvaTimeToMarket.meanTimeToRepair")
    @Mapping(source = "entityKVATimeToMarket.entityCycleTime", target = "kva.kvaTimeToMarket.cycleTime")
    @Mapping(source = "entityKVATimeToMarket.entityLeadTime", target = "kva.kvaTimeToMarket.leadTime")
    @Mapping(source = "entityKVATimeToMarket.entityTimeToLearn", target = "kva.kvaTimeToMarket.timeToLearn")
    Iteration toIteration(EntityIteration iteration);

    @InheritInverseConfiguration
    @Mapping(target = "entityKVAUnrealizedValue", ignore = true)
    @Mapping(target = "entityKVACurrentValue", ignore = true)
    @Mapping(target = "entityKVAAbilityToInnovate", ignore = true)
    @Mapping(target = "entityKVATimeToMarket", ignore = true)
    EntityIteration toIterationDomain(Iteration iteration);
}

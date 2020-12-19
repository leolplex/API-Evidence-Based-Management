package com.ebm.persistence.mapper;

import com.ebm.domain.KVAAbilityToInnovate;
import com.ebm.persistence.entity.EntityKVAAbilityToInnovate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KVAAbilityToInnovateMapper {
    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityFeatureUsageIndex", target = "featureUsageIndex")
    @Mapping(source = "entityInnovationRate", target = "innovationRate")
    @Mapping(source = "entityDefectTrends", target = "defectTrends")
    @Mapping(source = "entityOnProductIndex", target = "onProductIndex")
    @Mapping(source = "entityInstalledVersionIndex", target = "installedVersionIndex")
    @Mapping(source = "entityTechnicalDebt", target = "technicalDebt")
    @Mapping(source = "entityProductionIncidentTrends", target = "productionIncidentTrends")
    @Mapping(source = "entityActiveCodeBranchesTimeSpentMergingCodeBetweenBranches", target = "activeCodeBranchesTimeSpentMergingCodeBetweenBranches")
    @Mapping(source = "entityTimeSpentContextSwitching", target = "timeSpentContextSwitching")
    @Mapping(source = "entityIdTeamA2I", target = "idTeam")
    @Mapping(source = "entityIdIterationA2I", target = "idIteration")
    KVAAbilityToInnovate toKVAAbilityToInnovate(EntityKVAAbilityToInnovate entityKVAAbilityToInnovate);

    @InheritInverseConfiguration
    @Mapping(target = "entityIteration", ignore = true)
    EntityKVAAbilityToInnovate toKVAAbilityToInnovateDomain(KVAAbilityToInnovate kvaAbilityToInnovate);
}

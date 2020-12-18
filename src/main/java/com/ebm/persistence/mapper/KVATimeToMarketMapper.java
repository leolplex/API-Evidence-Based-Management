package com.ebm.persistence.mapper;

import com.ebm.domain.KVATimeToMarket;
import com.ebm.persistence.entity.EntityKVATimeToMarket;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KVATimeToMarketMapper {

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityBuildAndIntegrationFrequency", target = "buildAndIntegrationFrequency")
    @Mapping(source = "entityReleaseFrequency", target = "releaseFrequency")
    @Mapping(source = "entityReleaseStabilizationPeriod", target = "releaseStabilizationPeriod")
    @Mapping(source = "entityMeanTimeToRepair", target = "meanTimeToRepair")
    @Mapping(source = "entityCycleTime", target = "cycleTime")
    @Mapping(source = "entityLeadTime", target = "leadTime")
    @Mapping(source = "entityTimeToLearn", target = "timeToLearn")
    @Mapping(source = "entityIdTeamT2M", target = "idTeam")
    @Mapping(source = "entityIdIterationT2M", target = "idIteration")
    KVATimeToMarket toKVATimeToMarket(EntityKVATimeToMarket entityKVATimeToMarket);

    @InheritInverseConfiguration
    @Mapping(target = "entityIteration", ignore = true)
    EntityKVATimeToMarket toKVATimeToMarketDomain(KVATimeToMarket kvaTimeToMarket);
}

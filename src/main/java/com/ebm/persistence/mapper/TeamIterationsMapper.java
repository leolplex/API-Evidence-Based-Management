package com.ebm.persistence.mapper;

import com.ebm.domain.IterationDomain;
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
    IterationDomain toTeamIteration(EntityIterationTeam iteration);


}

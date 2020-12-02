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
    List<IterationDomain> toIterations(List<EntityIteration> iteration);

    @InheritInverseConfiguration
    List<EntityIteration> toIterationsDomain(List<IterationDomain> iterationDomain);

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityName", target = "name")
    @Mapping(source = "entityGoal", target = "goal")
    @Mapping(source = "entityStartDate", target = "startDate")
    @Mapping(source = "entityEndDate", target = "endDate")
    @Mapping(source = "entityState", target = "state")
    IterationDomain toIteration(EntityIteration iteration);

    @InheritInverseConfiguration
    EntityIteration toIterationDomain(IterationDomain iterationDomain);
}

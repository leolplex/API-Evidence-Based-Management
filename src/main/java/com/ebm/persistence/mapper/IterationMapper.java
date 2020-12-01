package com.ebm.persistence.mapper;

import com.ebm.domain.IterationDomain;
import com.ebm.persistence.entity.Iteration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IterationMapper {

    @Mapping(source = "id", target = "idDomain")
    @Mapping(source = "goal", target = "goalDomain")
    @Mapping(source = "startDate", target = "startDateDomain")
    @Mapping(source = "endDate", target = "endDateDomain")
    @Mapping(source = "state", target = "stateDomain")
    List<IterationDomain> toIterations(List<Iteration> iteration);

    @InheritInverseConfiguration
    List<Iteration> toIterationsDomain(List<IterationDomain> iterationDomain);

    @Mapping(source = "id", target = "idDomain")
    @Mapping(source = "goal", target = "goalDomain")
    @Mapping(source = "startDate", target = "startDateDomain")
    @Mapping(source = "endDate", target = "endDateDomain")
    @Mapping(source = "state", target = "stateDomain")
    IterationDomain toIteration(Iteration iteration);

    @InheritInverseConfiguration
    Iteration toIterationDomain(IterationDomain iterationDomain);
}

package com.ebm.persistence.mapper;

import com.ebm.domain.IterationDomain;
import com.ebm.persistence.entity.Iteration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IterationMapper {

    List<IterationDomain> toIterations(List<Iteration> iteration);

    @InheritInverseConfiguration
    List<Iteration> toIterationsDomain(List<IterationDomain> iterationDomain);

    IterationDomain toIteration(Iteration iteration);

    @InheritInverseConfiguration
    Iteration toIterationDomain(IterationDomain iterationDomain);
}

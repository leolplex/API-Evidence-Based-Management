package com.ebm.persistence.mapper;


import com.ebm.domain.TeamDomain;
import com.ebm.persistence.entity.EntityTeam;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamIterationsMapper.class})
public interface TeamMapper {

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityName", target = "name")
    @Mapping(source = "entityDateJoin", target = "dateJoin")
    @Mapping(source = "entityTeam", target = "iterations")
    TeamDomain toTeam(EntityTeam team);


    @InheritInverseConfiguration
    @Mapping(target = "entityTeam.entityId", ignore = true)
    @Mapping(target = "entityTeam.entityName", ignore = true)
    @Mapping(target = "entityTeam.entityDateJoin", ignore = true)
    @Mapping(target = "entityTeam", ignore = true)
    EntityTeam toTeamDomain(TeamDomain team);


    List<EntityTeam> toTeamsDomain(List<TeamDomain> teams);
    List<TeamDomain> toTeams(List<EntityTeam> teams);

}


package com.ebm.persistence.mapper;


import com.ebm.domain.Team;
import com.ebm.persistence.entity.EntityTeam;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityName", target = "name")
    @Mapping(source = "entityDateJoin", target = "dateJoin")
    Team toTeam(EntityTeam team);


    @InheritInverseConfiguration
    EntityTeam toTeamDomain(Team team);


    List<EntityTeam> toTeamsDomain(List<Team> teams);

    List<Team> toTeams(List<EntityTeam> teams);

}


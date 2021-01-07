package com.ebm.persistence.mapper;

import com.ebm.domain.Users;
import com.ebm.persistence.entity.EntityUsers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityIdRol", target = "idRol")
    @Mapping(source = "entityUserName", target = "username")
    @Mapping(source = "entityPassword", target = "password")
    @Mapping(source = "entityEmail", target = "email")
    Users toUsers(EntityUsers user);

    @InheritInverseConfiguration
    EntityUsers toUsersDomain(Users user);

}

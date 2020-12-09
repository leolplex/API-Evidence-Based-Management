package com.ebm.persistence.mapper;

import com.ebm.domain.KVAUnrealizedValue;
import com.ebm.persistence.entity.EntityKVAUnrealizedValue;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KVAUnrealizedValueMapper {


    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityMarketShare", target = "marketShare")
    @Mapping(source = "entityCustomerSatisfactionGap", target = "customerSatisfactionGap")
    @Mapping(source = "entityIdTeam", target = "idTeam")
    @Mapping(source = "entityIdIteration", target = "idIteration")
    KVAUnrealizedValue toKVAUnrealizedValue(EntityKVAUnrealizedValue entityKVAUnrealizedValue);

    @InheritInverseConfiguration
    @Mapping(target = "entityIteration", ignore = true)
    EntityKVAUnrealizedValue toKVAUnrealizedValueDomain(KVAUnrealizedValue kvaUnrealizedValue);

    List<KVAUnrealizedValue> toKVAsUnrealizedValue(List<EntityKVAUnrealizedValue> entityKVAsUnrealizedValue);
    List<EntityKVAUnrealizedValue> toKVAsUnrealizedValueDomain(List<KVAUnrealizedValue> kvasUnrealizedValue);

}

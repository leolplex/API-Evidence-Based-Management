package com.ebm.persistence.mapper;

import com.ebm.domain.Product;
import com.ebm.persistence.entity.EntityProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamProductMapper.class})
public interface ProductMapper {

    @Mapping(source = "entityId", target = "id")
    @Mapping(source = "entityName", target = "name")
    @Mapping(source = "entityStartDate", target = "startDate")
    @Mapping(source = "entityIdTeam", target = "idTeam")
    @Mapping(source = "entityIterationProducts", target = "iterations")
    Product toProduct(EntityProduct product);

    @InheritInverseConfiguration
    @Mapping(target = "entityIterationProducts", ignore = true)
    EntityProduct toProductDomain(Product product);

    List<EntityProduct> toProductsDomain(List<Product> products);
    List<Product> toProducts(List<EntityProduct> products);

}

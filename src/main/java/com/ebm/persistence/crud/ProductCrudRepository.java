package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<EntityProduct, Integer> {

    List<EntityProduct> findByEntityIdTeam(int idUser);
}

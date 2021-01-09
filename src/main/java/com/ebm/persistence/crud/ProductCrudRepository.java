package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityProduct;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<EntityProduct, Integer> {
}

package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityIterationProduct;
import org.springframework.data.repository.CrudRepository;

public interface IterationProductCrudRepository extends CrudRepository<EntityIterationProduct, Integer> {
}

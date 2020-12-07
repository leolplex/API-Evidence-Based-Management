package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityIteration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IterationCrudRepository extends CrudRepository<EntityIteration, Integer> {


}

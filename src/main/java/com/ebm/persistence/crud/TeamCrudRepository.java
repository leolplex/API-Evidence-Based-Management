package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityTeam;
import org.springframework.data.repository.CrudRepository;


public interface TeamCrudRepository extends CrudRepository<EntityTeam, Integer> {

}

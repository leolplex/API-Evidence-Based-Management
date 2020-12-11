package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityIterationTeam;
import org.springframework.data.repository.CrudRepository;

public interface IterationTeamCrudRepository extends CrudRepository<EntityIterationTeam, Integer> {
}

package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityIteration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IterationCrudRepository extends CrudRepository<EntityIteration, Integer> {

    @Query(value = "SELECT * FROM iteration INNER JOIN iteration_team ON iteration.id = iteration_team.id_iteration WHERE iteration_team.id_team = ?", nativeQuery = true)
    List<EntityIteration> getByIdTeam(int idTeam);
}

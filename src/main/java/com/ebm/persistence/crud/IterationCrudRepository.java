package com.ebm.persistence.crud;

import com.ebm.persistence.entity.Iteration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IterationCrudRepository extends CrudRepository<Iteration, Integer> {

    @Query(value = "SELECT * FROM iteration INNER JOIN iteration_team ON iteration.id = iteration_team.id_iteration WHERE iteration_team.id_team = ?", nativeQuery = true)
    List<Iteration> getByIdTeam(int idTeam);
}

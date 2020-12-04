package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityTeam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamCrudRepository extends CrudRepository<EntityTeam, Integer> {

    @Query(value = "SELECT * FROM team INNER JOIN iteration_team ON team.id = iteration_team.id_team INNER JOIN iteration ON iteration_team.id_iteration = iteration.id;", nativeQuery = true)
    List<EntityTeam> getAll();
}

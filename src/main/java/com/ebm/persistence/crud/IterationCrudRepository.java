package com.ebm.persistence.crud;


import com.ebm.persistence.entity.EntityIteration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IterationCrudRepository extends CrudRepository<EntityIteration, Integer> {

    @Query(value = "SELECT * FROM iteration INNER JOIN iteration_team ON iteration.id = iteration_team.id_iteration INNER JOIN kva_ability_to_innovate ON iteration.id = kva_ability_to_innovate.id_iteration INNER JOIN kva_current_value ON iteration.id = kva_current_value.id_iteration INNER JOIN kva_time_to_market ON iteration.id = kva_time_to_market.id_iteration INNER JOIN kva_unrealized_value ON iteration.id = kva_unrealized_value.id_iteration WHERE iteration_team.id_team = ? ORDER BY end_date DESC LIMIT 1", nativeQuery = true)
    EntityIteration getLastIteration(int idTeam);

}

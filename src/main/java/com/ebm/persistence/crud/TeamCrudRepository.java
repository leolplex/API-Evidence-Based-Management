package com.ebm.persistence.crud;


import com.ebm.persistence.entity.EntityTeam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TeamCrudRepository extends CrudRepository<EntityTeam, Integer> {

    List<EntityTeam> findByEntityIdUser(int idUser);

}

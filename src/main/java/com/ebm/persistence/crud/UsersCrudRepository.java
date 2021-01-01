package com.ebm.persistence.crud;

import com.ebm.domain.Users;
import com.ebm.persistence.entity.EntityUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersCrudRepository extends CrudRepository<EntityUsers, Integer> {

    Optional<EntityUsers> findByEntityUserName(String userName);
}

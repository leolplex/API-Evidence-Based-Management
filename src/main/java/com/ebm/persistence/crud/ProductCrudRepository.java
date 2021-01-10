package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityProduct;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<EntityProduct, Integer> {

    List<EntityProduct> findByEntityIdTeam(int idUser);
}

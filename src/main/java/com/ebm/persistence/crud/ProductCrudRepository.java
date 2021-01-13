package com.ebm.persistence.crud;

import com.ebm.persistence.entity.EntityProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<EntityProduct, Integer> {

    @Query(value = "SELECT * FROM product INNER JOIN team ON product.id_team = team.id WHERE product.id_user = ?", nativeQuery = true)
    List<EntityProduct> findByEntityIdUser(int idUser);
}

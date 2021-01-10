package com.ebm.domain.repository;


import com.ebm.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<Product> getProductById(int idProduct);

    List<Product> getProductsByUserId(int idUser);
}

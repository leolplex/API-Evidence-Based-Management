package com.ebm.persistence;

import com.ebm.domain.Product;
import com.ebm.domain.repository.ProductRepository;
import com.ebm.persistence.crud.ProductCrudRepository;
import com.ebm.persistence.entity.EntityProduct;
import com.ebm.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductPersistenceRepository implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    ProductPersistenceRepository(ProductCrudRepository productCrudRepository, ProductMapper mapper) {
        this.productCrudRepository = productCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getAll() {
        List<EntityProduct> products = (List<EntityProduct>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<Product> getProductById(int idProduct) {
        return productCrudRepository.findById(idProduct).map(product -> mapper.toProduct(product));
    }

    @Override
    public List<Product> getProductsByUserId(int idUser) {
        return mapper.toProducts(productCrudRepository.findByEntityIdUser(idUser));

    }
}

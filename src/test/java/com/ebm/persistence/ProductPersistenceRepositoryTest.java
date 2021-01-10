package com.ebm.persistence;

import com.ebm.domain.Product;
import com.ebm.persistence.crud.ProductCrudRepository;
import com.ebm.persistence.entity.EntityProduct;
import com.ebm.persistence.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductPersistenceRepositoryTest {
    ProductPersistenceRepository tester;
    ProductCrudRepository productCrudRepository;
    ProductMapper mapper;

    @BeforeEach
    void initEach() {
        productCrudRepository = Mockito.mock(ProductCrudRepository.class);
        mapper = Mockito.mock(ProductMapper.class);
        tester = new ProductPersistenceRepository(productCrudRepository, mapper);
    }

    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Product> productsDomain = new ArrayList<>();
        Product productDomain = new Product();
        productsDomain.add(productDomain);

        List<EntityProduct> products = new ArrayList<>();
        EntityProduct product = new EntityProduct();
        products.add(product);

        when(productCrudRepository.findAll()).thenReturn(products);
        when(mapper.toProducts(products)).thenReturn(productsDomain);

        List<Product> productsResult = tester.getAll();

        assertEquals(1, productsResult.size(), "getAll must have a product");
        assertEquals(productDomain, productsResult.toArray()[0], "getAll must have a product equal to object defined");
    }

    @Test
    void TestGetProductByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getProductById(0), "getProductById must be Optional.empty()");
    }

    @Test
    void TestGetByIdTeamWithData() {

        Optional<Product> productDomain = Optional.of(new Product());
        Optional<EntityProduct> products = Optional.of(new EntityProduct());
        when(productCrudRepository.findById(1)).thenReturn(products);
        when(mapper.toProduct(products.get())).thenReturn(productDomain.get());

        Optional<Product> productsResult = tester.getProductById(1);

        assertEquals(productDomain, productsResult, "getProductById must be Optional.of(new EntityProduct())");

    }

    @Test
    void TestGetProductsByUserIdWithOutData() {
        assertEquals(new ArrayList<>(), tester.getProductsByUserId(1), "getProductsByUserId must be []");
    }

    @Test
    void TestGetProductsByUserIdWithData() {
        List<Product> productsDomain = new ArrayList<>();
        Product productDomain = new Product();
        productsDomain.add(productDomain);

        List<EntityProduct> products = new ArrayList<>();
        EntityProduct product = new EntityProduct();
        products.add(product);

        when(productCrudRepository.findByEntityIdTeam(1)).thenReturn(products);
        when(mapper.toProducts(products)).thenReturn(productsDomain);

        List<Product> productsResult = tester.getProductsByUserId(1);

        assertEquals(1, productsResult.size(), "getProductsByUserId must have a product");
        assertEquals(productDomain, productsResult.toArray()[0], "getProductsByUserId must have a product equal to object defined");
    }

}

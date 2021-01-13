package com.ebm.web.controller;

import com.ebm.domain.Product;
import com.ebm.domain.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductControllerTest {
    ProductController tester;
    ProductService productService;

    @BeforeEach
    void initEach() {
        productService = Mockito.mock(ProductService.class);
        tester = new ProductController(productService);
    }

    @Test
    void TestGetAllWithoutData() {
        assertEquals(new ResponseEntity<>(new ArrayList<Product>(), HttpStatus.OK), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        products.add(product);

        when(productService.getAll()).thenReturn(products);

        assertEquals(new ResponseEntity<>(products, HttpStatus.OK), tester.getAll(), "getAll must be new ResponseEntity with a value");
    }


    @Test
    void TestGetTeamByIdWithoutData() {
        int idProduct = 2;
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.getProductById(idProduct), "getProductById must be <404 NOT_FOUND Not Found,[]>");
    }


    @Test
    void TestGetTeamByIdWitData() {
        int idProduct = 2;
        Optional<Product> optionalProduct= Optional.of(new Product());


        when(productService.getProductById(idProduct)).thenReturn(optionalProduct);

        assertEquals(new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK), tester.getProductById(idProduct), "getProductById must be new ResponseEntity with a value and status Ok");
    }

    @Test
    void TestGetByUserIdWithoutData() {
        assertEquals(new ResponseEntity<>(new ArrayList<Product>(), HttpStatus.OK), tester.getByUserId(1), "getByUserId must be []");
    }

    @Test
    void TestGetByUserIdWithData() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        products.add(product);

        when(productService.getProductsByUserId(1)).thenReturn(products);

        assertEquals(new ResponseEntity<>(products, HttpStatus.OK), tester.getByUserId(1), "getByUserId must be new ResponseEntity with a value");
    }


    @Test
    void TestSaveNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.save(new Product()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Product product = new Product();
        when(productService.save(product)).thenReturn(product);

        assertEquals(new ResponseEntity<>(product, HttpStatus.CREATED), tester.save(product), "save must be new instance Product");
    }
}

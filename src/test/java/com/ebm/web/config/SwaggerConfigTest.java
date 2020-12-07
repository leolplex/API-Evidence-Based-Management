package com.ebm.web.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwaggerConfigTest {

    private SwaggerConfig tester;

    @BeforeEach
    void initEach() {
        // Arrange
        tester = new SwaggerConfig();
    }


    @Test
    void api() {
        // Act
        Docket docket = tester.api();
        System.out.println(docket.getDocumentationType());

        // Assert
        assertEquals(DocumentationType.SWAGGER_2, docket.getDocumentationType(), "api must be swagger:2.0");
    }
}

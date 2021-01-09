package com.ebm.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppErrorControllerTest {
    AppErrorController tester;

    @BeforeEach()
    void initEach() {
        tester = new AppErrorController();
    }

    @Test
    void TestGetErrorPath() {
        final String result = tester.getErrorPath();

        assertEquals("No Mapping Found", result, "getErrorPath must be No Mapping Found");
    }
}

package com.ebm.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthenticationResponseTest {
    AuthenticationResponse tester;

    @BeforeEach
    void initEach() {
        tester = new AuthenticationResponse("token", "myusername");
    }

    @Test
    void TestInstanceIterationDefaultValues(){

        // Act & Assert
        assertEquals("token",tester.getJwt(),"getJwt must be token");
        assertEquals("myusername",tester.getUserName(),"getUserName must be myusername");
    }

    @Test
    void getAndSetNewObject() {
        final String userName = "myusername";
        final String jwt = "jwt";


        tester.setUserName(userName);
        tester.setJwt(jwt);

        final String getJwt = tester.getJwt();
        final String getUserName = tester.getUserName();

        assertEquals(jwt, getJwt, "setJwt must be my jwt");
        assertEquals(userName, getUserName, "setUserName must be my myusername");


    }
}

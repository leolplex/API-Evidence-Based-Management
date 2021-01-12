package com.ebm.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthenticationResponseTest {
    AuthenticationResponse tester;

    @BeforeEach
    void initEach() {
        tester = new AuthenticationResponse(1, "token", "myusername");

    }

    @Test
    void TestOnlyTokenConstructor() {
        tester = new AuthenticationResponse("token");
        assertEquals("token", tester.getJwt(), "getJwt must be token");
        assertNull(tester.getUserName(), "getJwt must be null");
        assertNull(tester.getId(), "getJwt must be null");
    }

    @Test
    void TestInstanceIterationDefaultValues() {

        // Act & Assert
        assertEquals("token", tester.getJwt(), "getJwt must be token");
        assertEquals("myusername", tester.getUserName(), "getUserName must be myusername");
        assertEquals(1, tester.getId(), "getId must be 1");
    }

    @Test
    void getAndSetNewObject() {
        final String userName = "myusername";
        final String jwt = "jwt";
        final Integer id = 1;


        tester.setUserName(userName);
        tester.setJwt(jwt);
        tester.setId(id);

        final String getJwt = tester.getJwt();
        final String getUserName = tester.getUserName();
        final Integer getId = tester.getId();

        assertEquals(jwt, getJwt, "setJwt must be my jwt");
        assertEquals(userName, getUserName, "setUserName must be my myusername");
        assertEquals(id, getId, "setId must be my 1");


    }
}

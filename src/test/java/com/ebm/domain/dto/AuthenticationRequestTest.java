package com.ebm.domain.dto;

import com.ebm.domain.Iteration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthenticationRequestTest {
    AuthenticationRequest tester;

    @BeforeEach
    void initEach() {
        tester = new AuthenticationRequest();
    }

    @Test
    void TestInstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getUsername(),"getIdIteration must be null");
        assertNull(tester.getPassword(),"getGoal must be null");
    }

    @Test
    void getAndSetNewObject() {
        final String userName = "myusername";
        final String password = "myusername";


        tester.setUsername(userName);
        tester.setPassword(password);

        final String getPassword = tester.getPassword();
        final String getUsername = tester.getUsername();

        assertEquals(password, getPassword, "setPassword must be my myusername");
        assertEquals(userName, getUsername, "setUsername must be my myusername");


    }
}

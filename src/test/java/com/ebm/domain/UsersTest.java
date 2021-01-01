package com.ebm.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UsersTest {
    Users tester;
    @BeforeEach
    void initEach(){
        tester = new Users();
    }

    @Test
    void InstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getId(),"getId must be null");
        assertNull(tester.getUserName(),"getUserName must be null");
        assertNull(tester.getPassword(),"getPassword must be null");
        assertNull(tester.getEmail(),"getEmail must be null");
        assertNull(tester.getIdRol(),"getIdRol must be null");

    }

    @Test
    void getAndSetNewObject() {
        final Integer id = 42;
        final String userName = "myusername";
        final String password = "myusername";
        final String email = "myusername@gmail.com";
        final Integer idRol = 50;

        tester.setId(id);
        tester.setUserName(userName);
        tester.setPassword(password);
        tester.setEmail(email);
        tester.setIdRol(idRol);

        final Integer getId = tester.getId();
        final Integer getIdRol = tester.getIdRol();
        final String getUserName = tester.getUserName();
        final String getPassword = tester.getPassword();
        final String getEmail = tester.getEmail();

        assertEquals(id, getId, "setId must be my 42");
        assertEquals(idRol, getIdRol, "setIdRol must be my 50");
        assertEquals(userName, getUserName, "setUserName must be my myusername");
        assertEquals(password, getPassword, "setPassword must be my myusername");
        assertEquals(email, getEmail, "setEmail must be my myusername@gmail.com");


    }
}

package com.ebm.persistence.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntityUsersTest {
    EntityUsers tester;

    @BeforeEach
    void initEach(){
        tester = new EntityUsers();
    }

    @Test
    void InstanceIterationDefaultValues(){

        // Act & Assert
        assertNull(tester.getEntityId(),"getEntityId must be null");
        assertNull(tester.getEntityUserName(),"getEntityUserName must be null");
        assertNull(tester.getEntityPassword(),"getEntityPassword must be null");
        assertNull(tester.getEntityEmail(),"getEntityEmail must be null");
        assertNull(tester.getEntityIdRol(),"getEntityIdRol must be null");

    }

    @Test
    void getAndSetNewObject() {
        final Integer id = 42;
        final String userName = "myusername";
        final String password = "myusername";
        final String email = "myusername@gmail.com";
        final Integer idRol = 50;

        tester.setEntityId(id);
        tester.setEntityUserName(userName);
        tester.setEntityPassword(password);
        tester.setEntityEmail(email);
        tester.setEntityIdRol(idRol);

        final Integer getId = tester.getEntityId();
        final Integer getEntityIdRol = tester.getEntityIdRol();
        final String getEntityUserName = tester.getEntityUserName();
        final String getEntityPassword = tester.getEntityPassword();
        final String getEntityEmail = tester.getEntityEmail();

        assertEquals(id, getId, "setEntityId must be my 42");
        assertEquals(idRol, getEntityIdRol, "setEntityIdRol must be my 50");
        assertEquals(userName, getEntityUserName, "setEntityUserName must be my myusername");
        assertEquals(password, getEntityPassword, "setEntityPassword must be my myusername");
        assertEquals(email, getEntityEmail, "setEntityEmail must be my myusername@gmail.com");


    }
}

package com.ebm.domain.service;

import com.ebm.domain.Users;
import com.ebm.domain.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class UsersServiceTest {
    UsersService tester;
    UsersRepository usersRepository;

    @BeforeEach
    void initEach(){
        usersRepository = Mockito.mock(UsersRepository.class);
        tester = new UsersService(usersRepository);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new Users()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Users users = new Users();
        when(usersRepository.save(users)).thenReturn(users);

        assertEquals(users, tester.save(users), "save must be new instance Users");
    }

    @Test
    void TestGetUserByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getUserById(1), "getUserById must be Optional.empty()");
    }

    @Test
    void TestGetUserByIdWithData() {
        Optional<Users> users = Optional.of(new Users());
        when(usersRepository.getUserById(1)).thenReturn(users);

        Optional<Users> usersResult = tester.getUserById(1);

        assertEquals(users, usersResult, "getUserById must have an user");
    }


    @Test
    void TestFindByUserNameWithOutData() {
        assertEquals(Optional.empty(), tester.findByUserName("myusername"), "findByUserName must be Optional.empty()");
    }

    @Test
    void TestFindByUserNameWithData() {
        Optional<Users> users = Optional.of(new Users());
        when(usersRepository.findByUserName("myuser")).thenReturn(users);

        Optional<Users> usersResult = tester.findByUserName("myuser");

        assertEquals(users, usersResult, "findByUserName must have an user");
    }
}

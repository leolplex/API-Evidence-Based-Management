package com.ebm.domain.service;

import com.ebm.domain.Users;
import com.ebm.domain.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class EBMUserDetailServiceTest {
    EBMUserDetailService tester;
    UsersRepository usersRepository;

    @BeforeEach
    void initEach() {
        usersRepository = Mockito.mock(UsersRepository.class);
        tester = new EBMUserDetailService(usersRepository);
    }

    @Test
    void TestLoadUserByUsername() {
        Users user = new Users();
        user.setUsername("myUser");
        user.setPassword("password");
        when(usersRepository.findByUserName("myUser")).thenReturn(Optional.of(user));

        UserDetails result = tester.loadUserByUsername("myUser");

        assertEquals("myUser", result.getUsername(), "loadUserByUsername must contain myUser");
    }

    @ParameterizedTest
    @CsvSource(value = {":", "'':''",  ":user1", "user1:", ":''", "'':","'':user1", "user1:''",}, delimiter = ':')
    void TestLoadUserByUserNameIsNotPresent(String username, String password) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        when(usersRepository.findByUserName("myUser")).thenReturn(Optional.of(user));
        UserDetails result = tester.loadUserByUsername("myUser");
        assertNull(result, "loadUserByUsername must be null");
    }


    @Test
    void TestLoadUserByUsernameFindByUserNameNull() {

        UserDetails result = tester.loadUserByUsername("myUser");

        assertNull(result, "loadUserByUsername must be null");
    }

}

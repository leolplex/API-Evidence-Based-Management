package com.ebm.web.controller;


import com.ebm.domain.Users;
import com.ebm.domain.dto.AuthenticationRequest;
import com.ebm.domain.dto.AuthenticationResponse;
import com.ebm.domain.service.EBMUserDetailService;
import com.ebm.domain.service.UsersService;
import com.ebm.web.security.JWTUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UsersControllerTest {
    UsersController tester;
    UsersService usersService;
    EBMUserDetailService ebmUserDetailService;
    JWTUtil jwtUtil;
    AuthenticationManager authenticationManager;
    PasswordEncoder encoder;

    @BeforeEach()
    void initEach() {
        usersService = Mockito.mock(UsersService.class);
        ebmUserDetailService = Mockito.mock(EBMUserDetailService.class);
        jwtUtil = Mockito.mock(JWTUtil.class);
        authenticationManager = Mockito.mock(AuthenticationManager.class);
        encoder = Mockito.mock(PasswordEncoder.class);
        tester = new UsersController(usersService, ebmUserDetailService, jwtUtil, authenticationManager, encoder);
    }

    @Test
    void TestSaveNull() {
        assertEquals(new ResponseEntity<>(HttpStatus.CREATED), tester.signup(new Users()), "signup must be HttpStatus.CREATED");
    }

    @Test
    void TestSaveWithData() {
        Users users = new Users();
        when(usersService.save(users)).thenReturn(users);

        assertEquals(new ResponseEntity<>(users, HttpStatus.CREATED), tester.signup(users), "signup must be new instance Users");
    }

    @Test
    void TestGetUserByIdWithoutData() {
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND), tester.getUserById(1), "getUserById must be []");
    }

    @Test
    void TestGetUserByIdWithData() {
        Optional<Users> users = Optional.of(new Users());

        when(usersService.getUserById(1)).thenReturn(users);

        assertEquals(new ResponseEntity<>(users.get(), HttpStatus.OK), tester.getUserById(1), "getUserById-1 must be new ResponseEntity with a value");
    }

    @Test
    void TestFindByUserNameWithoutData() {
        assertEquals(new ResponseEntity<>(true, HttpStatus.OK), tester.checkUserName("myuser"), "checkUserName must be []");
    }

    @Test
    void TestFindByUserNameWithData() {
        Optional<Users> users = Optional.of(new Users());

        when(usersService.findByUserName("myuser")).thenReturn(users);

        assertEquals(new ResponseEntity<>(false, HttpStatus.OK), tester.checkUserName("myuser"), "checkUserName must be new ResponseEntity with a value");
    }

    @Test
    void TestAuthenticateUser() {
        Users user = new Users();
        user.setUsername("myuser");
        user.setId(21);
        Optional<Users> users = Optional.of(user);
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("myuser");
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Date dateNow = new Date();
        Date dateExpiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

        when(ebmUserDetailService.loadUserByUsername(authenticationRequest.getUsername())).thenReturn(userDetails);
        when(jwtUtil.generateToken(userDetails, dateNow, dateExpiration)).thenReturn("jwt");
        when(usersService.findByUserName("myuser")).thenReturn(users);

        assertEquals(HttpStatus.OK, tester.authenticateUser(authenticationRequest).getStatusCode(), "authenticateUser must be new ResponseEntity with a value");
    }

    @Test
    void TestAuthenticateUserFail() {
        Optional<Users> users = Optional.of(new Users());
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("myser");
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Date dateNow = new Date();
        Date dateExpiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

        when(ebmUserDetailService.loadUserByUsername(authenticationRequest.getUsername())).thenThrow(BadCredentialsException.class);
        when(jwtUtil.generateToken(userDetails, dateNow, dateExpiration)).thenReturn("jwt");
        when(usersService.findByUserName("myuser")).thenReturn(users);

        assertEquals(HttpStatus.FORBIDDEN, tester.authenticateUser(authenticationRequest).getStatusCode(), "authenticateUser must be FORBIDDEN");
    }

    @Test
    void TestAuthenticateUserFailWithoutUser() {

        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("daniel");
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Date dateNow = new Date();
        Date dateExpiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

        when(ebmUserDetailService.loadUserByUsername(authenticationRequest.getUsername())).thenReturn(userDetails);
        when(jwtUtil.generateToken(userDetails, dateNow, dateExpiration)).thenReturn("jwt");
        when(usersService.findByUserName(null)).thenReturn(null);


        assertEquals(HttpStatus.OK, tester.authenticateUser(authenticationRequest).getStatusCode(), "authenticateUser must be new ResponseEntity with a value");
    }


    @Test
    void TestRenewToken() {
        when(jwtUtil.renewToken("jwt")).thenReturn("jwt");
        AuthenticationResponse authenticationResponse = tester.renewToken("jwt").getBody();
        assert authenticationResponse != null;
        assertEquals("jwt", authenticationResponse.getJwt(), "renewToken must be new ResponseEntity with a value");
    }


    @Test
    void TestRenewTokenFail() {
        when(jwtUtil.renewToken("")).thenReturn("Can't renew token!");
        AuthenticationResponse authenticationResponse = tester.renewToken("").getBody();
        assert authenticationResponse != null;
        assertEquals("Can't renew token!", authenticationResponse.getJwt(), "renewToken must be Can't renew token!");
    }

    @Test
    void TestRenewTokenFailBadCredentials() {
        when(jwtUtil.renewToken("")).thenThrow(BadCredentialsException.class);
        assertEquals(HttpStatus.FORBIDDEN, tester.renewToken("").getStatusCode(), "renewToken must be FORBIDDEN");
    }
}

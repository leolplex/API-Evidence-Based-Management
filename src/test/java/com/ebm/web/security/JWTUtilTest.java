package com.ebm.web.security;

import com.ebm.domain.repository.UsersRepository;
import com.ebm.domain.service.EBMUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class JWTUtilTest {

    private EBMUserDetailService ebmUserDetailService;
    private UsersRepository usersRepository;
    private JWTUtil tester;
    private UserDetails userDetails;
    private Date dateNow = new Date();
    private Date dateExpiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

    @BeforeEach
    void initEach() {
        // Arrange
        tester = new JWTUtil();
        tester.setKey("Ph4nth3r4");
        usersRepository = Mockito.mock(UsersRepository.class);
        ebmUserDetailService = Mockito.mock(EBMUserDetailService.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode("panthera");
        UserDetails userDetailsRTN = new User("Daniel", passwordEncode, new ArrayList<>());
        when((ebmUserDetailService.loadUserByUsername("Daniel"))).thenReturn(userDetailsRTN);
        userDetails = ebmUserDetailService.loadUserByUsername("Daniel");
    }

    @Test
    void generateToken() {
        // Arrange
        final String tokenMock = mockGenerateToken(userDetails.getUsername(), dateNow, dateExpiration);

        // Act
        String token = tester.generateToken(userDetails, dateNow, dateExpiration);

        // Assert
        assertEquals(tokenMock, token, "generateToken must be tokenMock");
    }

    @Test
    void validateTokenTrue() {
        // Arrange
        final String tokenMock = mockGenerateToken(userDetails.getUsername(), dateNow, dateExpiration);

        // Act
        boolean isValid = tester.validateToken(tokenMock, userDetails);

        // Assert
        assertTrue(isValid, "validateToken must be true");
    }


    @Test
    void validateTokenFalseDateExpiredUserError() {
        // Arrange
        Date dateExpired = new Date(System.currentTimeMillis());
        final String tokenMock = mockGenerateToken("MockUser", dateNow, dateExpired);
        boolean isValid = tester.validateToken(tokenMock, userDetails);
        assertFalse(isValid, "validateToken must be false");

    }


    @Test
    void extractUsername() {
        // Arrange
        final String tokenMock = mockGenerateToken(userDetails.getUsername(), dateNow, dateExpiration);

        // Act
        String tokenResult = tester.extractUsername(tokenMock);

        // Assert
        assertEquals("Daniel", tokenResult, "extractUsername must be tokenMock");
    }

    @Test
    void tokenIsNotExpire() {
        // Arrange
        final String tokenMock = mockGenerateToken(userDetails.getUsername(), dateNow, dateExpiration);

        // Act
        boolean isExpired = tester.isTokenExpire(tokenMock);

        // Assert
        assertFalse(isExpired, "isTokenExpire must be false");
    }

    @Test
    void tokenIsExpire() {
        try {
            // Act
            tester.isTokenExpire("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEYW5pZWwiLCJpYXQiOjE2MDI2OTM4NjksImV4cCI6MTYwMjY5Mzg3M30.ITqc1b9xU4Cn64sJ7oqfi9UKP5NXm4O1lS1iYcH48io");
        } catch (ExpiredJwtException e) {

            // Assert
            assertThat(e.getMessage(), CoreMatchers.containsString("JWT expired at 2020-10-14"));
        }
    }

    @Test
    void renewToken() {
        // Arrange
        final String tokenMock = mockGenerateToken(userDetails.getUsername(), dateNow, dateExpiration);
        final String renewTokenMock = mockRenewToken(tokenMock);
        // Act
        String token = tester.renewToken(tokenMock);

        // Assert
        assertEquals(renewTokenMock, token, "generateToken must be tokenMock");
    }


    private String mockGenerateToken(String username, Date dateNow, Date dateExpiration) {
        return Jwts.builder().setSubject(username)
                .setIssuedAt(dateNow)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256, "Ph4nth3r4").compact();
    }

    private String mockRenewToken(String token) {
        Claims claims = mockGetClaims(token);
        Date dateNow = new Date();
        Date dateExpiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10); // 10 hours = 36000 milliseconds
        return Jwts.builder().setClaims(claims).setIssuedAt(dateNow) // new Date()
                .setExpiration(dateExpiration) // new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)
                .signWith(SignatureAlgorithm.HS256, "Ph4nth3r4").compact();
    }

    private Claims mockGetClaims(String token) {
        try {
            return Jwts.parser().setSigningKey("Ph4nth3r4").parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {

            return new DefaultClaims();
        }

    }


}

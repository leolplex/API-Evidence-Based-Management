package com.ebm.web.security;

import com.ebm.domain.service.EBMUserDetailService;
import com.ebm.web.security.filter.JwtFilterRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JwtFilterRequestTest {
    JwtFilterRequest tester;
    private Date dateNow = new Date();
    private Date dateExpiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
    private MockHttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain filterChain;
    private String tokenMock;
    private String tokenWithOutBearer;
    private JWTUtil jwtUtil;
    private EBMUserDetailService ebmUserDetailService;

    @BeforeEach
    void initEach() {
        // Arrange
        jwtUtil = Mockito.mock(JWTUtil.class);
        ebmUserDetailService = Mockito.mock(EBMUserDetailService.class);
        tester = new JwtFilterRequest(jwtUtil, ebmUserDetailService);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        filterChain = new MockFilterChain();
        tokenMock = "Bearer " + mockGenerateToken("Daniel", dateNow, dateExpiration);
        tokenWithOutBearer = tokenMock.substring(7);
    }

    @AfterEach
    void finishEach() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void doFilterInternal() throws ServletException, IOException {
        // Act
        tester.doFilterInternal(request, response, filterChain);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus(), "httpServletResponse.getStatus() must be ok");
    }

    @Test
    void doFilterInternalWithValidRequest() throws ServletException, IOException {
        // Arrange
        request.addHeader("Authorization", tokenWithOutBearer);

        // Act
        tester.doFilterInternal(request, response, filterChain);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus(), "httpServletResponse.getStatus() must be ok");

    }


    @Test
    void doFilterInternalWithValidRequestAndContainBearer() throws ServletException, IOException {
        // Arrange
        request.addHeader("Authorization", tokenMock);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode("panthera");
        UserDetails userDetails = new User("Daniel", passwordEncode, new ArrayList<>());

        when(jwtUtil.extractUsername(tokenWithOutBearer)).thenReturn("Daniel");
        when((ebmUserDetailService.loadUserByUsername("Daniel"))).thenReturn(userDetails);
        when((jwtUtil.validateToken(tokenWithOutBearer, userDetails))).thenReturn(true);
        // Act
        tester.doFilterInternal(request, response, filterChain);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus(), "httpServletResponse.getStatus() must be Ok");

    }


    @Test
    void doFilterInternalWithInvalidUserName() throws ServletException, IOException {
        // Arrange
        request.addHeader("Authorization", tokenMock);

        Mockito.when(jwtUtil.extractUsername(tokenWithOutBearer)).thenReturn(null);

        // Act
        tester.doFilterInternal(request, response, filterChain);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus(), "httpServletResponse.getStatus() must be Ok");

    }

    @Test
    void doFilterInternalWithvalidateTokenFalse() throws ServletException, IOException {
        // Arrange
        request.addHeader("Authorization", tokenMock);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode("panthera");
        UserDetails userDetails = new User("Daniel", passwordEncode, new ArrayList<>());

        when(jwtUtil.extractUsername(tokenWithOutBearer)).thenReturn("Daniel");
        when((ebmUserDetailService.loadUserByUsername("Daniel"))).thenReturn(userDetails);
        when((jwtUtil.validateToken(tokenWithOutBearer, userDetails))).thenReturn(false);


        // Act
        tester.doFilterInternal(request, response, filterChain);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus(), "httpServletResponse.getStatus() must be Ok");

    }

    @Test
    void doFilterInternalWithSecurityContextAndWithoutUserName() throws ServletException, IOException {
        // Arrange
        request.addHeader("Authorization", tokenMock);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode("panthera");
        UserDetails userDetails = new User("Daniel", passwordEncode, new ArrayList<>());

        Mockito.when(jwtUtil.extractUsername(tokenWithOutBearer)).thenReturn(null);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);

        // Act False&&False
        tester.doFilterInternal(request, response, filterChain);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus(), "httpServletResponse.getStatus() must be Ok");

    }

    @Test
    void doFilterInternalWithUserNameAndSecurityContext() throws ServletException, IOException {
        // Arrange
        request.addHeader("Authorization", tokenMock);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode("panthera");
        UserDetails userDetails = new User("Daniel", passwordEncode, new ArrayList<>());

        Mockito.when(jwtUtil.extractUsername(tokenWithOutBearer)).thenReturn("Daniel");
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);

        // Act False&&False
        tester.doFilterInternal(request, response, filterChain);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus(), "httpServletResponse.getStatus() must be Ok");

    }


    private String mockGenerateToken(String username, Date dateNow, Date dateExpiration) {
        return Jwts.builder().setSubject(username)
                .setIssuedAt(dateNow)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256, "Ph4nth3r4").compact();
    }
}

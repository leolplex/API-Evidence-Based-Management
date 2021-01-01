package com.ebm.web.controller;

import com.ebm.domain.Users;
import com.ebm.domain.dto.AuthenticationRequest;
import com.ebm.domain.dto.AuthenticationResponse;
import com.ebm.domain.service.EBMUserDetailService;
import com.ebm.domain.service.UsersService;
import com.ebm.web.security.JWTUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200", "https://leolplex.github.io"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class UsersController {
    @Autowired
    private final UsersService usersService;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private EBMUserDetailService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public UsersController(UsersService usersService, EBMUserDetailService ebmUserDetailService, JWTUtil jwtUtil, AuthenticationManager authenticationManager, PasswordEncoder encoder) {
        this.usersService = usersService;
        this.userDetailService = ebmUserDetailService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
    }

    @PostMapping("/signup")
    @ApiOperation("Create a new user")
    @ApiResponse(code = 200, message = "ok")
    public ResponseEntity<Users> signup(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>(usersService.save(user), HttpStatus.CREATED);
    }


    @GetMapping("/userById/{idUser}")
    @ApiOperation("Get user by id")
    @ApiResponse(code = 200, message = "ok")
    public ResponseEntity<Users> getUserById(@ApiParam(value = "The id of the user", required = true, example = "7") @PathVariable("idUser") int idUser) {
        return usersService.getUserById(idUser).map(userResponse -> new ResponseEntity<>(userResponse, HttpStatus.OK)).orElse(new ResponseEntity<>((HttpStatus.NOT_FOUND)));
    }


    @PostMapping("/signin")
    @ApiOperation("authenticate a user")
    @ApiResponse(code = 200, message = "ok")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
            Date dateNow = new Date();
            Date dateExpiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
            String jwt = jwtUtil.generateToken(userDetails, dateNow, dateExpiration);
            return new ResponseEntity<>(new AuthenticationResponse(jwt, request.getUsername()), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}

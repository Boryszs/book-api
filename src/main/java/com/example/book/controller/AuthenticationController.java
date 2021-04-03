package com.example.book.controller;

import com.example.book.dto.request.AuthenticationRequest;
import com.example.book.dto.request.UserRequest;
import com.example.book.dto.response.AuthenticationResponse;
import com.example.book.dto.response.UserResponse;
import com.example.book.security.JwtTokenUtil;
import com.example.book.service.UserService;
import com.example.book.service.impl.JwtUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserServiceImpl jwtUserService;
    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserServiceImpl jwtUserService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserService = jwtUserService;
        this.userService = userService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> authenticationUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            final UserDetails userDetails = jwtUserService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            UserResponse userResponse = userService.findByUsername(authenticationRequest.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(userResponse.getId(), token));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


    @PostMapping(value = "/register")
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) throws Exception {
        userService.save(userRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

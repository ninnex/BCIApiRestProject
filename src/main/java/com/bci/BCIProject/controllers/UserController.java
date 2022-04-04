package com.bci.BCIProject.controllers;

import com.bci.BCIProject.exception.ItemNotFoundException;
import com.bci.BCIProject.model.ErrorResponse;
import com.bci.BCIProject.model.User;
import com.bci.BCIProject.models.AuthenticationRequest;
import com.bci.BCIProject.models.AuthenticationResponse;
import com.bci.BCIProject.service.JwtUtil;
import com.bci.BCIProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private         final JwtUtil tokenUtil;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User us = service.saveUser(user);
        return new ResponseEntity<User>(us, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return new ResponseEntity<User>(service.getUser(UUID.fromString(id)), HttpStatus.FOUND);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = tokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

}

package com.bci.BCIProject.controllers;

import com.bci.BCIProject.exception.ItemNotFoundException;
import com.bci.BCIProject.model.ErrorResponse;
import com.bci.BCIProject.model.User;
import com.bci.BCIProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

            user.setCreatedTime(OffsetDateTime.now().now());
            user.setModifiedTime(OffsetDateTime.now());
            user.setLastLogin(OffsetDateTime.now());
            User us = service.saveUser(user);

        System.out.println("user = " + user);
        return new ResponseEntity<User>(us, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return new ResponseEntity<User>(service.getUser(UUID.fromString(id))
            .orElseThrow(ItemNotFoundException::new), HttpStatus.FOUND);
    }

}

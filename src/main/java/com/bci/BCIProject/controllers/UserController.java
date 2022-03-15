package com.bci.BCIProject.controllers;

import com.bci.BCIProject.model.ErrorResponse;
import com.bci.BCIProject.model.User;
import com.bci.BCIProject.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User us;
        try {
            user.setCreatedTime(OffsetDateTime.now().now());
            us = service.saveUser(user);
        }catch (DataIntegrityViolationException e){
            return new ResponseEntity(new ErrorResponse("500", "Item duplicado, ya existe el correo"), HttpStatus.ALREADY_REPORTED);
        }
        catch (TransactionSystemException e){
            e.printStackTrace();
            return new ResponseEntity(new ErrorResponse("500", "Email inválido o password inseguro"), HttpStatus.ALREADY_REPORTED);
        }
        System.out.println("user = " + user);
        return new ResponseEntity<User>(us, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id){
        return service.getUser(UUID.fromString(id)).map( user ->
            new ResponseEntity<User>(user, HttpStatus.FOUND)
        ).orElseGet( ()->
            new ResponseEntity(new ErrorResponse("404", "Item no encontrado"), HttpStatus.NOT_FOUND)
        );
    }
}

package com.bci.BCIProject.controllers;

import com.bci.BCIProject.model.Phone;
import com.bci.BCIProject.model.User;
import com.bci.BCIProject.repository.UserRepository;
import com.bci.BCIProject.services.UserService;
import com.bci.BCIProject.services.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    UserController userController;
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;

    private AutoCloseable closeable;

    @BeforeEach
    void initService(){
        userController = new UserController(userService);
    }

    @Test
    void createUser() {
        User user = User.builder()
            .uuid(UUID.fromString("567a8d95-eeed-402b-b7cc-2e16128fe1d8"))
            .name("Eduardo Barreto")
            .email("ebarreto@nisum.com")
            .isActive(true)
            .createdTime(OffsetDateTime.now())
            .phones(Arrays.asList(Phone.builder()
                .cityCode("0276")
                .id(1L)
                .number("55555")
                .countryCode("57")
                .build())
            ).build();

//        when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
        ResponseEntity<User> response = userController.createUser(user);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }


}
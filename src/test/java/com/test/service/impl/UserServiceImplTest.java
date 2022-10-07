package com.test.service.impl;

import com.test.model.Entity.Phone;
import com.test.model.Entity.User;
import com.test.model.UserRequest;
import com.test.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test_JUnit() {

        String url = "/users";
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@test.com");
        userRequest.setName("Test");
        userRequest.setPassword("passwordcorrect");
        List<Phone> phoneList = new ArrayList<>();
        Phone phone = new Phone();
        phone.setNumber("23456732");
        phone.setCityCode("52");
        phone.setCityCode("94300");
        phoneList.add(phone);
        userRequest.setPhones(phoneList);

        Mockito.when(userRepository.save(any(User.class))).thenReturn(new User());
        assertNotNull(userService.saveUser(userRequest));
    }

}
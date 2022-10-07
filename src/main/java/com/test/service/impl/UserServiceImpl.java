package com.test.service.impl;

import com.test.model.Entity.User;
import com.test.model.UserRequest;
import com.test.model.UserResponse;
import com.test.repository.UserRepository;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private User mapRequestToEntity(UserRequest userRequest){

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhones(userRequest.getPhones());

        return user;
    }

    public UserResponse saveUser(UserRequest UserRequest){

        User user = mapRequestToEntity(UserRequest);
        return mapToResponse(userRepository.save(user));

    }

    private UserResponse mapToResponse(User user){

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setActive(true);
        response.setCreated(response.getCreated());
        response.setModified(response.getModified());
        response.setToken("");
        return response;

    }





}

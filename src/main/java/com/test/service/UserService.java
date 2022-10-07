package com.test.service;

import com.test.model.UserRequest;
import com.test.model.UserResponse;

public interface UserService {

    UserResponse saveUser(UserRequest UserRequest);
}

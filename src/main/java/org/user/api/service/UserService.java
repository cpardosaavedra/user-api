package org.user.api.service;

import org.user.api.domain.LoginResponse;
import org.user.api.domain.RequestLogin;
import org.user.api.domain.user.CreateUserRequest;
import org.user.api.domain.user.CreateUserResponse;
import org.user.api.domain.user.UserRequest;
import org.user.api.domain.user.UserResponse;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);

    LoginResponse login(RequestLogin requestLogin);

    UserResponse getUserInformation(String email);
}

package org.user.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.user.api.domain.LoginResponse;
import org.user.api.domain.RequestLogin;
import org.user.api.domain.user.CreateUserRequest;
import org.user.api.domain.user.CreateUserResponse;
import org.user.api.domain.user.UserResponse;
import org.user.api.entity.User;
import org.user.api.enums.StatusEnum;
import org.user.api.repository.UserRepository;
import org.user.api.utils.JwtUtils;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        try {
            this.userRepository.save(this.buildUserEntity(createUserRequest));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return new CreateUserResponse(StatusEnum.OK.getValue());
    }

    @Override
    public LoginResponse login(RequestLogin requestLogin) {
        User user = this.userRepository
                .findByUserNameAndPassword(requestLogin.getUserName(),
                        requestLogin.getPassword());

        if (Objects.nonNull(user)) {
            return LoginResponse.builder()
                    .status(StatusEnum.OK.getValue())
                    .token(JwtUtils.generateJwt(user.getEmail()))
                    .build();
        }

        throw new RuntimeException("invalid user!");
    }

    @Override
    public UserResponse getUserInformation(String email) {
       return this.buildUserResponse(this.userRepository.findByEmail(email));
    }

    private UserResponse buildUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .nickName(user.getNick())
                .email(user.getEmail())
                .dni(user.getDni())
                .build();
    }

    private User buildUserEntity(CreateUserRequest createUserRequest) {
        return User.builder()
                .dni(createUserRequest.getDni())
                .email(createUserRequest.getEmail())
                .name(createUserRequest.getName())
                .lastName(createUserRequest.getLastName())
                .nick(createUserRequest.getNick())
                .password(createUserRequest.getPassword())
                .build();
    }
}

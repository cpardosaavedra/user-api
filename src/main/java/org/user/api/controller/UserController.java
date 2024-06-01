package org.user.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.user.api.configuration.Header;
import org.user.api.domain.LoginResponse;
import org.user.api.domain.RequestLogin;
import org.user.api.domain.user.CreateUserRequest;
import org.user.api.domain.user.CreateUserResponse;
import org.user.api.domain.user.UserResponse;
import org.user.api.enums.StatusEnum;
import org.user.api.service.UserService;
import org.user.api.utils.JwtUtils;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final Header header;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> doLogin(@RequestBody RequestLogin requestLogin) {
        try {
            return ResponseEntity.ok(this.userService.login(requestLogin));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(LoginResponse.builder()
                    .status(StatusEnum.FAILED.getValue())
                    .errorDetails("login impossible, cause by: " + exception.getMessage())
                    .build());
        }
    }
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            return ResponseEntity.ok(this.userService.createUser(createUserRequest));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(new CreateUserResponse(StatusEnum.FAILED.getValue()));
        }
    }

    @GetMapping(value = "/getUserData")
    public ResponseEntity<UserResponse> getUserData() {
        try {
            if (Objects.isNull(header.getToken())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            String email = JwtUtils.getSubjectFromJwt(header.getToken());

            return ResponseEntity.ok(this.userService.getUserInformation(email));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}

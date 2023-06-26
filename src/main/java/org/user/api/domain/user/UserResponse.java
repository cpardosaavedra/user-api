package org.user.api.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserResponse {

    private String name;

    private String lastName;

    private String dni;

    private String nickName;

    private String email;
}

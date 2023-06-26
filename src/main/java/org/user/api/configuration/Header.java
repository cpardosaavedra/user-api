package org.user.api.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Data
@Component
public class Header {

    private String token;

    private String client;

    private String appName;
}

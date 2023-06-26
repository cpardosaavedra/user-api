package org.user.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    OK("ok"),
    FAILED("failed");

    private String value;
}

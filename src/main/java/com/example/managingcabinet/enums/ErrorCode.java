package com.example.managingcabinet.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    NOT_ALL_REQUIRED_FIELDS_FOUND(400),
    USER_NOT_FOUND(404),
    USER_ALREADY_CONFIRMED(400),
    CODE_EXPIRED(400),
    WRONG_CODE(400),
    INVALID_PASSWORD(400),
    CODE_NOT_FOUND(404),
    USERNAME_TAKEN(409),
    MISSING_ACCESS_TOKEN(401),
    ACCESS_DENIED(403),
    INVALID_ACCESS_TOKEN(401);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }
}

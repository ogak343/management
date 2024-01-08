package com.example.managingcabinet.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthLoginReqDto {

    @NotNull
    private String username;
    @NotNull
    private String password;
}

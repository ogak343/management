package com.example.managingcabinet.dto.auth;

import com.example.managingcabinet.enums.AuthType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthResendReqDto {
    @NotNull
    private AuthType type;
    @NotNull
    private Long userId;
}

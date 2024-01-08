package com.example.managingcabinet.dto.auth;

import lombok.Data;

@Data
public class AuthRespDto {
    private String accessToken;
    private String refreshToken;

    public AuthRespDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}

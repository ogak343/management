package com.example.managingcabinet.dto.auth;

import lombok.Data;

@Data
public class AuthCreateRespDto {
    private Long userId;

    public AuthCreateRespDto(Long userId) {
        this.userId = userId;
    }
}

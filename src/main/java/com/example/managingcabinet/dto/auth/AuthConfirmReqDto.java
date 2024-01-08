package com.example.managingcabinet.dto.auth;

import com.example.managingcabinet.enums.AuthType;
import lombok.Data;

@Data
public class AuthConfirmReqDto {
    private Long userId;
    private AuthType type;
    private Integer code;

}

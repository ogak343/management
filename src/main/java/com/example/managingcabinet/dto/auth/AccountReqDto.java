package com.example.managingcabinet.dto.auth;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class AccountReqDto {
    @Size(min = 12, max = 12)
    @Pattern(regexp = "^998\\d{9}")
    private String phone;
    @Email
    private String email;

}

package com.example.managingcabinet.model;

import com.example.managingcabinet.enums.Role;
import lombok.Data;

@Data
public class Auth {
    private Long userId;
    private Role role;
}

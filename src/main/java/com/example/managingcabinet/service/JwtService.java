package com.example.managingcabinet.service;

import com.example.managingcabinet.dto.auth.AuthRespDto;
import com.example.managingcabinet.model.User;

public interface JwtService {
    AuthRespDto generateToken(User user);

    void authenticate(String request);
}

package com.example.managingcabinet.service;

import com.example.managingcabinet.enums.AuthType;
import com.example.managingcabinet.model.ConfirmationCode;
import com.example.managingcabinet.model.User;

public interface ConfirmationTokenService {
    void setConfirmationCode(User model, AuthType type);

    ConfirmationCode findByUserId(Long userId);
}

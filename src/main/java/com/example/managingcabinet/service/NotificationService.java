package com.example.managingcabinet.service;

import com.example.managingcabinet.model.ConfirmationCode;

public interface NotificationService {
    void send(ConfirmationCode confirmationCode);
}

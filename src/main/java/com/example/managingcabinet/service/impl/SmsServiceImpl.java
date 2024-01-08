package com.example.managingcabinet.service.impl;

import com.example.managingcabinet.model.ConfirmationCode;
import com.example.managingcabinet.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("SMS")
@RequiredArgsConstructor
public class SmsServiceImpl implements NotificationService {

    @Override
    public void send(ConfirmationCode confirmationCode) {

    }
}

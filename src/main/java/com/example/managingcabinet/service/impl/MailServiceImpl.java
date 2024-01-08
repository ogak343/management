package com.example.managingcabinet.service.impl;

import com.example.managingcabinet.model.ConfirmationCode;
import com.example.managingcabinet.service.NotificationService;
import org.springframework.stereotype.Service;

@Service("MAIL")
public class MailServiceImpl implements NotificationService {
    @Override
    public void send(ConfirmationCode confirmationCode) {

    }
}

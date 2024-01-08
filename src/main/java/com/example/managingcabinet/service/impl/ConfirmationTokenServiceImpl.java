package com.example.managingcabinet.service.impl;

import com.example.managingcabinet.infastructure.exception.ApplicationException;
import com.example.managingcabinet.enums.AuthType;
import com.example.managingcabinet.enums.ErrorCode;
import com.example.managingcabinet.enums.NotificationType;
import com.example.managingcabinet.model.ConfirmationCode;
import com.example.managingcabinet.model.User;
import com.example.managingcabinet.repo.ConfirmationCodeRepository;
import com.example.managingcabinet.service.NotificationService;
import com.example.managingcabinet.service.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final Map<String, NotificationService> notificationService;
    private final ConfirmationCodeRepository repository;

    @Override
    public void setConfirmationCode(User model, AuthType type) {

        ConfirmationCode confirmationCode = repository.findByUserId(model.getId()).orElse(new ConfirmationCode(
                new Random().nextInt(),
                model,
                OffsetDateTime.now(),
                OffsetDateTime.now().plusMinutes(5),
                NotificationType.valueOf(type)
        ));

        confirmationCode = repository.save(confirmationCode);

        getNotificationService(confirmationCode.getType().name()).send(confirmationCode);

        model.setConfirmationCode(confirmationCode);
    }

    @Override
    public ConfirmationCode findByUserId(Long userId) {
        return repository.findByUserId(userId).orElseThrow(
                () -> ApplicationException.error(ErrorCode.CODE_NOT_FOUND));
    }

    private NotificationService getNotificationService(String type) {
        return notificationService.get(type);
    }
}

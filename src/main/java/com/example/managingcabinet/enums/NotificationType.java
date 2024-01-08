package com.example.managingcabinet.enums;

import lombok.Getter;

@Getter
public enum NotificationType {
    SMS,
    MAIL;

    public static NotificationType valueOf(AuthType type) {
        return switch (type) {
            case PHONE -> NotificationType.SMS;
            case EMAIL -> NotificationType.MAIL;
        };
    }
}

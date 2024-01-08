package com.example.managingcabinet.model;

import com.example.managingcabinet.enums.NotificationType;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ConfirmationCode {
    private Long id;
    private Integer code;
    private User user;
    private OffsetDateTime createdAt;
    private OffsetDateTime expiredAt;
    private OffsetDateTime confirmedAt;
    private NotificationType type;

    public ConfirmationCode(Integer code, User user, OffsetDateTime created,
                            OffsetDateTime expired, NotificationType type) {
        this.code = code;
        this.user = user;
        this.createdAt = created;
        this.expiredAt = expired;
        this.type = type;
    }
}

package com.example.managingcabinet.entity;

import com.example.managingcabinet.enums.NotificationType;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Table(name = "codes")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConfirmationCodeEntity {

    @Id
    private Long id;
    private Integer code;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "expired_at")
    private OffsetDateTime expiredAt;
    @Column(name = "confirmed_at")
    private OffsetDateTime confirmedAt;
    @Enumerated(EnumType.STRING)
    private NotificationType type;
}

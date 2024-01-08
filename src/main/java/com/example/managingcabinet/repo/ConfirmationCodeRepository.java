package com.example.managingcabinet.repo;

import com.example.managingcabinet.model.ConfirmationCode;

import java.util.Optional;

public interface ConfirmationCodeRepository {
    Optional<ConfirmationCode> findByUserId(Long id);

    ConfirmationCode save(ConfirmationCode confirmationCode);

}

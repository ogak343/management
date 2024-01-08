package com.example.managingcabinet.validator.impl;

import com.example.managingcabinet.infastructure.exception.ApplicationException;
import com.example.managingcabinet.enums.ErrorCode;
import com.example.managingcabinet.repo.UserRepository;
import com.example.managingcabinet.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidatorImpl implements UserValidator {

    private final UserRepository repository;

    @Override
    public void validateExists(String username) {

        if (!repository.existsByUsername(username)) {
            throw ApplicationException.error(ErrorCode.USERNAME_TAKEN);
        }
    }
}

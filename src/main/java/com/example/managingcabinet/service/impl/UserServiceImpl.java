package com.example.managingcabinet.service.impl;

import com.example.managingcabinet.dto.auth.AuthCreateRespDto;
import com.example.managingcabinet.enums.AuthType;
import com.example.managingcabinet.infastructure.Utils;
import com.example.managingcabinet.repo.UserRepository;
import com.example.managingcabinet.service.ConfirmationTokenService;
import com.example.managingcabinet.service.UserService;
import com.example.managingcabinet.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import com.example.managingcabinet.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserValidator validator;

    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public AuthCreateRespDto create(User model, AuthType type) {

        validator.validateExists(model.getUsername());

        confirmationTokenService.setConfirmationCode(model, type);

        var save = repository.save(model);

        return new AuthCreateRespDto(save.getId());
    }

    @Override
    public User update(User update) {

        validator.validateExists(update.getUsername());

        return repository.update(update);
    }

    @Override
    public User patch(User model) {

        Optional.ofNullable(model.getUsername()).ifPresent(validator::validateExists);

        return repository.patch(model);
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete() {

        var authId = Utils.getAuthId();

        repository.deleteById(authId);
    }
}

package com.example.managingcabinet.service.impl;

import com.example.managingcabinet.infastructure.exception.ApplicationException;
import com.example.managingcabinet.dto.auth.AuthCreateRespDto;
import com.example.managingcabinet.dto.auth.AuthRespDto;
import com.example.managingcabinet.dto.auth.AuthConfirmReqDto;
import com.example.managingcabinet.dto.auth.AuthLoginReqDto;
import com.example.managingcabinet.dto.auth.AuthResendReqDto;
import com.example.managingcabinet.enums.ErrorCode;
import com.example.managingcabinet.repo.UserRepository;
import com.example.managingcabinet.service.AuthService;
import com.example.managingcabinet.service.JwtService;
import com.example.managingcabinet.service.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final ConfirmationTokenService confirmationTokenService;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AuthRespDto confirm(AuthConfirmReqDto confirm) {

        var confirmCode = confirmationTokenService.findByUserId(confirm.getUserId());

        if (confirmCode.getConfirmedAt() != null || confirmCode.getUser().isEnabled()) {
            throw ApplicationException.error(ErrorCode.USER_ALREADY_CONFIRMED);
        }

        if (confirmCode.getExpiredAt().isAfter(OffsetDateTime.now())) {
            throw ApplicationException.error(ErrorCode.CODE_EXPIRED);
        }

        if (!Objects.equals(confirmCode.getCode(), confirm.getCode())) {
            throw ApplicationException.error(ErrorCode.WRONG_CODE);
        }
        var user = confirmCode.getUser();

        user.setEnabled(true);

        repository.save(user);

        return jwtService.generateToken(user);
    }

    @Override
    public AuthRespDto login(AuthLoginReqDto login) {

        var user = repository.findByUsername(login.getUsername());

        if (!passwordEncoder.matches(login.getPassword(), user.getPassword())) {
            throw ApplicationException.error(ErrorCode.INVALID_PASSWORD);
        }

        return jwtService.generateToken(user);
    }

    @Override
    public AuthCreateRespDto resend(AuthResendReqDto resend) {

        var code = confirmationTokenService.findByUserId(resend.getUserId());

        confirmationTokenService.setConfirmationCode(code.getUser(), resend.getType());

        return new AuthCreateRespDto(code.getUser().getId());
    }

}

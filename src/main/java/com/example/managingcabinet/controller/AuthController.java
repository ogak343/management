package com.example.managingcabinet.controller;

import com.example.managingcabinet.dto.auth.AuthCreateRespDto;
import com.example.managingcabinet.dto.auth.AuthRespDto;
import com.example.managingcabinet.dto.auth.AuthConfirmReqDto;
import com.example.managingcabinet.dto.auth.AuthLoginReqDto;
import com.example.managingcabinet.dto.auth.AuthResendReqDto;
import com.example.managingcabinet.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/confirm")
    @Operation(summary = "Method to confirm user with confirmation code")
    public ResponseEntity<AuthRespDto> confirm(@RequestBody @Valid AuthConfirmReqDto confirm) {

        log.info("AuthConfirmReqDto : {}", confirm);

        return ResponseEntity.ok(authService.confirm(confirm));
    }

    @PostMapping("/login")
    @Operation(summary = "Login")
    public ResponseEntity<AuthRespDto> login(@RequestBody @Valid AuthLoginReqDto login) {

        log.info("[AuthLogin] username : {}", login.getUsername());

        return ResponseEntity.ok(authService.login(login));
    }


    @PostMapping("/resend")
    @Operation(summary = "Method to resend confirmation code to user")
    public ResponseEntity<AuthCreateRespDto> resend(@RequestBody @Valid AuthResendReqDto resend) {

        log.info("AuthResendReqDto : {}", resend);

        return ResponseEntity.ok(authService.resend(resend));
    }

}

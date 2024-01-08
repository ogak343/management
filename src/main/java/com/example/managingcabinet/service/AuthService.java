package com.example.managingcabinet.service;

import com.example.managingcabinet.dto.auth.AuthCreateRespDto;
import com.example.managingcabinet.dto.auth.AuthRespDto;
import com.example.managingcabinet.dto.auth.AuthConfirmReqDto;
import com.example.managingcabinet.dto.auth.AuthLoginReqDto;
import com.example.managingcabinet.dto.auth.AuthResendReqDto;

public interface AuthService {
    AuthRespDto confirm(AuthConfirmReqDto confirm);

    AuthRespDto login(AuthLoginReqDto login);

    AuthCreateRespDto resend(AuthResendReqDto resend);
}

package com.example.managingcabinet.service;

import com.example.managingcabinet.dto.auth.AuthCreateRespDto;
import com.example.managingcabinet.enums.AuthType;
import com.example.managingcabinet.model.User;

public interface UserService {
    AuthCreateRespDto create(User create, AuthType type);

    User update(User update);

    User patch(User patch);

    User getById(Long id);

    void delete();
}

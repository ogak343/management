package com.example.managingcabinet.infastructure;

import com.example.managingcabinet.enums.ErrorCode;
import com.example.managingcabinet.infastructure.exception.ApplicationException;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
    public static Long getAuthId() {
        Long authId;
        try {
            authId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (NullPointerException e) {
            throw ApplicationException.error(ErrorCode.INVALID_ACCESS_TOKEN);
        }
        return authId;
    }
}

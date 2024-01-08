package com.example.managingcabinet.infastructure.exception;

import com.example.managingcabinet.enums.ErrorCode;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public class ApplicationException extends ErrorResponseException {
    public ApplicationException(ProblemDetail detail) {
        super(HttpStatusCode.valueOf(detail.getStatus()), detail, null);
    }

    public static ApplicationException error(ErrorCode errorCode) {
        return new ApplicationException(ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(errorCode.getCode()), errorCode.name()));
    }

    public static ApplicationException unhandled(@NotNull Exception e) {
        return new ApplicationException(ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(500), e.getMessage()));
    }
}

package com.example.managingcabinet.dto.user;

import com.example.managingcabinet.infastructure.exception.ApplicationException;
import com.example.managingcabinet.dto.auth.AccountReqDto;
import com.example.managingcabinet.enums.AuthType;
import com.example.managingcabinet.enums.ErrorCode;
import com.example.managingcabinet.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserCreateReqDto extends AccountReqDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotNull
    private AuthType type;
    @NotNull
    private Role role;

    public void validateFields() {
        if (this.getType() == AuthType.EMAIL && (this.getEmail() == null || this.getEmail().isEmpty())) {
            throw ApplicationException.error(ErrorCode.NOT_ALL_REQUIRED_FIELDS_FOUND);
        } else if (this.getType() == AuthType.PHONE && (this.getPhone() == null || this.getPhone().isEmpty())) {
            throw ApplicationException.error(ErrorCode.NOT_ALL_REQUIRED_FIELDS_FOUND);
        }
    }
}

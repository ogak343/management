package com.example.managingcabinet.dto.user;

import com.example.managingcabinet.dto.auth.AccountReqDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserUpdateReqDto extends AccountReqDto {
    @NotNull
    private Long id;
    @NotEmpty
    private String username;
}

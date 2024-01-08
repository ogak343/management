package com.example.managingcabinet.dto.user;

import com.example.managingcabinet.dto.auth.AccountReqDto;
import com.example.managingcabinet.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserPatchReqDto extends AccountReqDto {

    @NotNull
    private Long id;
    private String username;
    private Role role;
}

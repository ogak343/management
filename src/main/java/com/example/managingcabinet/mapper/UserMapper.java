package com.example.managingcabinet.mapper;

import com.example.managingcabinet.dto.user.UserCreateReqDto;
import com.example.managingcabinet.dto.user.UserPatchReqDto;
import com.example.managingcabinet.dto.user.UserRespDto;
import com.example.managingcabinet.dto.user.UserUpdateReqDto;
import com.example.managingcabinet.entity.UserEntity;
import com.example.managingcabinet.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        implementationName = "UserMapperImpl",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toModel(UserCreateReqDto create);

    UserRespDto toRespDto(User model);

    User toModel(UserUpdateReqDto update);

    User toModel(UserPatchReqDto patch);

    UserEntity toEntity(User model);

    User toModel(UserEntity save);

    @Mapping(target = "authorities", ignore = true)
    void update(@MappingTarget User entity, User update);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "authorities", ignore = true)
    void patch(@MappingTarget User entity, User model);
}

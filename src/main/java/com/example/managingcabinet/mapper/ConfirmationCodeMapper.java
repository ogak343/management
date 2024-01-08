package com.example.managingcabinet.mapper;

import com.example.managingcabinet.entity.ConfirmationCodeEntity;
import com.example.managingcabinet.model.ConfirmationCode;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        implementationName = "ConfirmationCodeMapperImpl",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ConfirmationCodeMapper {
    ConfirmationCode toModel(ConfirmationCodeEntity entity);

    ConfirmationCodeEntity toEntity(ConfirmationCode model);
}

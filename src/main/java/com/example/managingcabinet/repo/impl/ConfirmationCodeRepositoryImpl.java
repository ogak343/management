package com.example.managingcabinet.repo.impl;

import com.example.managingcabinet.dao.ConfirmationCodeDao;
import com.example.managingcabinet.mapper.ConfirmationCodeMapper;
import com.example.managingcabinet.model.ConfirmationCode;
import com.example.managingcabinet.repo.ConfirmationCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConfirmationCodeRepositoryImpl implements ConfirmationCodeRepository {

    private final ConfirmationCodeDao dao;
    private final ConfirmationCodeMapper mapper;
    @Override
    public Optional<ConfirmationCode> findByUserId(Long id) {
        return dao.findById(id).map(mapper::toModel);
    }

    @Override
    public ConfirmationCode save(ConfirmationCode model) {

        return mapper.toModel(dao.save(mapper.toEntity(model)));
    }
}

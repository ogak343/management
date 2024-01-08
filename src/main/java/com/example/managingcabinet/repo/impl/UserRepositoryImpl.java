package com.example.managingcabinet.repo.impl;

import com.example.managingcabinet.infastructure.exception.ApplicationException;
import com.example.managingcabinet.dao.UserDao;
import com.example.managingcabinet.enums.ErrorCode;
import com.example.managingcabinet.mapper.UserMapper;
import com.example.managingcabinet.model.Auth;
import com.example.managingcabinet.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import com.example.managingcabinet.model.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper mapper;
    private final UserDao dao;

    @Override
    public User findByUsername(String username) {
        return mapper.toModel(dao.findByUsername(username)
                .orElseThrow(() -> ApplicationException.error(ErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public boolean existsByUsername(String username) {
        return dao.existsByUsername(username);
    }

    @Override
    public User save(User model) {
        return mapper.toModel(dao.save(mapper.toEntity(model)));
    }

    @Override
    public User findById(Long id) {
        return mapper.toModel(dao.findById(id).orElseThrow(() -> ApplicationException.error(ErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public User update(User update) {

        var entity = findById(update.getId());

        mapper.update(entity, update);

        return mapper.toModel(dao.save(mapper.toEntity(entity)));
    }

    @Override
    public void deleteById(Long id) {
        dao.delete(id);
    }

    @Override
    public User patch(User model) {

        var entity = findById(model.getId());

        mapper.patch(entity, model);

        return mapper.toModel(dao.save(mapper.toEntity(entity)));
    }

    @Override
    public Auth getAuthById(String userId) {
        return dao.getAuthById(userId).orElseThrow(()->ApplicationException.error(ErrorCode.ACCESS_DENIED));
    }
}

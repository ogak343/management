package com.example.managingcabinet.repo;

import com.example.managingcabinet.model.Auth;
import com.example.managingcabinet.model.User;

public interface UserRepository {
    User findByUsername(String username);

    boolean existsByUsername(String username);

    User save(User model);

    User findById(Long id);

    User update(User update);

    void deleteById(Long id);

    User patch(User model);

    Auth getAuthById(String userId);
}

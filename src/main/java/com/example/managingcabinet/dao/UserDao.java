package com.example.managingcabinet.dao;

import com.example.managingcabinet.entity.UserEntity;
import com.example.managingcabinet.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);

    @Query(value = "SELECT id AS userId, role AS role FROM users WHERE id = :userId", nativeQuery = true)
    Optional<Auth> getAuthById(String userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE users SET deleted_at = now() WHERE id = :id")
    void delete(@Param("id") Long id);
}

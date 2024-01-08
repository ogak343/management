package com.example.managingcabinet.dao;

import com.example.managingcabinet.entity.ConfirmationCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface ConfirmationCodeDao extends JpaRepository<ConfirmationCodeEntity, Long>,
        JpaSpecificationExecutor<ConfirmationCodeEntity> {
}

package com.example.dota.repository;

import com.example.dota.entity.CurrierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CurrierRepository extends JpaRepository<CurrierEntity, Long>, JpaSpecificationExecutor<CurrierEntity> {
}

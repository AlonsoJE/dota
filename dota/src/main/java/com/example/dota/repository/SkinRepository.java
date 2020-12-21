package com.example.dota.repository;

import com.example.dota.entity.SkinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SkinRepository extends JpaRepository<SkinEntity, Long>, JpaSpecificationExecutor<SkinEntity> {
}

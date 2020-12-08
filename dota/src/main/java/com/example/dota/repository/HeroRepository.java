package com.example.dota.repository;

import com.example.dota.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeroRepository extends JpaRepository<HeroEntity, Long>, JpaSpecificationExecutor<HeroEntity> {
}

package com.example.dota.repository;

import com.example.dota.entity.ItemHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemHeroRepository extends JpaRepository<ItemHero, Long>, JpaSpecificationExecutor<ItemHero> {
}

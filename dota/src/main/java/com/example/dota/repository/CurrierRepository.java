package com.example.dota.repository;

import com.example.dota.entity.CurrierEntity;
import com.example.dota.resource.CurrierResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CurrierRepository extends JpaRepository<CurrierEntity, Long>, JpaSpecificationExecutor<CurrierEntity> {

    //consulta JPA
    public CurrierEntity findTopByOrderByIdDesc();

    // query nativa
    @Query(value = "SELECT * FROM currier where name like %:name%", nativeQuery = true)
    public List<CurrierEntity> nativeQuery(@Param(value = "name") String name);

    // hql ou jpql
    @Query(value = "FROM CurrierEntity currier where currier.name like %:name%")
    public List<CurrierEntity> hql(@Param(value = "name") String name);

}

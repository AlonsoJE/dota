package com.example.dota.repository;

import com.example.dota.entity.BlobBase64Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BloblBase64Repository extends JpaRepository<BlobBase64Entity, Long>, JpaSpecificationExecutor<BlobBase64Entity> {
}

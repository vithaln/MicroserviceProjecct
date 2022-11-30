package com.vitu.code.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitu.code.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Long> {

	Optional<ImageData> findByfileName(String fileName);
}

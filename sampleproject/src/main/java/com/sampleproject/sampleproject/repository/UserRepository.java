package com.sampleproject.sampleproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampleproject.sampleproject.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

	boolean existsByEmail(String email);
	UserEntity findByEmail(String email);
	Optional<UserEntity> findById(Long userid);
	
}

package com.ftvtraining.repository;

import com.ftvtraining.enity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
          Page<UserEntity> findAll(Pageable pageable);
}

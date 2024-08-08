package com.example.springApi.SignupRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springApi.SignupEntity.SignupEntity;

public interface SignupRepository extends JpaRepository<SignupEntity, Long> {
    SignupEntity findByUsername(String username);
}

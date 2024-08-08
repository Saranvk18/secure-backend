package com.example.springApi.SignupRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springApi.SignupEntity.Registration;
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}

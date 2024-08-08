package com.example.springApi.SignupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springApi.SignupEntity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package com.example.springApi.SignupMapper;

import com.example.springApi.SignupDto.SignupDto;
import com.example.springApi.SignupEntity.SignupEntity;

public class SignupMapper {

    public static SignupDto mapToSignupDto(SignupEntity signup) {
        return new SignupDto(
                signup.getId(),
                signup.getUsername(),
                signup.getEmail(),
                signup.getPassword()
        );
    }

    public static SignupEntity mapToSignup(SignupDto signupDto) {
        return new SignupEntity(
                signupDto.getId(),
                signupDto.getUsername(),
                signupDto.getEmail(),
                signupDto.getPassword()
        );
    }
}

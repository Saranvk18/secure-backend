package com.example.springApi.SignupService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springApi.SignupDto.SignupDto;
import com.example.springApi.SigninDto.SigninDto;

@Service
public interface SignupService {
    SignupDto createSignup(SignupDto signupDto);

    SignupDto getSignupById(Long signupId);

    List<SignupDto> getAllSignup();

    SignupDto updateSignup(Long signupId, SignupDto updatedSignup);

    void deleteSignup(Long signupId);

    boolean validateUser(SigninDto signinDto);
}

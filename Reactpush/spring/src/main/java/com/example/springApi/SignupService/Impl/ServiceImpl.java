package com.example.springApi.SignupService.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.springApi.SignupDto.SignupDto;
import com.example.springApi.SignupEntity.SignupEntity;
import com.example.springApi.SignupException.SignupException;
import com.example.springApi.SignupMapper.SignupMapper;
import com.example.springApi.SignupRepository.SignupRepository;
import com.example.springApi.SignupService.SignupService;
import com.example.springApi.SigninDto.SigninDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceImpl implements SignupService {

    private SignupRepository signupRepository;

    @Override
    public SignupDto createSignup(SignupDto signupDto) {
        SignupEntity signup = SignupMapper.mapToSignup(signupDto);
        SignupEntity savedsignup = signupRepository.save(signup);
        return SignupMapper.mapToSignupDto(savedsignup);
    }

    @Override
    public SignupDto getSignupById(Long signupId) {
        SignupEntity signup = signupRepository.findById(signupId).orElseThrow(
                () -> new SignupException("Signup not exists with a given id: " + signupId)
        );
        return SignupMapper.mapToSignupDto(signup);
    }

    @Override
    public List<SignupDto> getAllSignup() {
        List<SignupEntity> signup = signupRepository.findAll();
        return signup.stream().map(SignupMapper::mapToSignupDto)
                .collect(Collectors.toList());
    }

    @Override
    public SignupDto updateSignup(Long signupId, SignupDto updatedSignup) {
        SignupEntity signup = signupRepository.findById(signupId).orElseThrow(
                () -> new SignupException("Signup not exists with a given id: " + signupId)
        );

        signup.setUsername(updatedSignup.getUsername());
        signup.setEmail(updatedSignup.getEmail());
        signup.setPassword(updatedSignup.getPassword());

        SignupEntity savedSignup = signupRepository.save(signup);
        return SignupMapper.mapToSignupDto(savedSignup);
    }

    @Override
    public void deleteSignup(Long signupId) {
        SignupEntity signup = signupRepository.findById(signupId).orElseThrow(
                () -> new SignupException("Signup not exists with a given id: " + signupId)
        );

        signupRepository.deleteById(signupId);
    }

    @Override
    public boolean validateUser(SigninDto signinDto) {
        SignupEntity signup = signupRepository.findByUsername(signinDto.getUsername());
        return signup != null && signup.getPassword().equals(signinDto.getPassword());
    }
}

package com.example.springApi.SignupController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springApi.SignupDto.SignupDto;
import com.example.springApi.SignupService.SignupService;
import com.example.springApi.SigninDto.SigninDto;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class SignupController {

    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<SignupDto> createSignup(@RequestBody SignupDto signupDto){
        SignupDto signup = signupService.createSignup(signupDto);
        return new ResponseEntity<>(signup, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SigninDto signinDto) {
        boolean isValid = signupService.validateUser(signinDto);
        if (isValid) {
            return ResponseEntity.ok("Sign-in successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<SignupDto> getSignupById(@PathVariable("id") Long signupId){
        SignupDto signupDto = signupService.getSignupById(signupId);
        return ResponseEntity.ok(signupDto);
    }

    @GetMapping("/get")
    public ResponseEntity<List<SignupDto>> getAllSignup(){
        List<SignupDto> signup = signupService.getAllSignup();
        return ResponseEntity.ok(signup);
    }

    @PutMapping("{id}")
    public ResponseEntity<SignupDto> updateSignup(@PathVariable("id") Long signupId,
                                                  @RequestBody SignupDto updatedSignup){
        SignupDto signupDto = signupService.updateSignup(signupId, updatedSignup);
        return ResponseEntity.ok(signupDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSignup(@PathVariable("id") Long signupId){
        signupService.deleteSignup(signupId);
        return ResponseEntity.ok("Signup deleted successfully!");
    }
}


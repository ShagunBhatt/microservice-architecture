package com.example.demo.controller;

import com.example.demo.DTOs.LoginResponse;
import com.example.demo.DTOs.LoginUserDto;
import com.example.demo.DTOs.RegisterUserDto;
import com.example.demo.entity.AppUsers;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JWTService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<AppUsers> register(@RequestBody RegisterUserDto registerUserDto) {
        //Create a user
        AppUsers registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) throws Exception {
        //Check if user is present
        AppUsers authenticatedUser = authenticationService.authenticate(loginUserDto);

        //Generate a token for it
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}

package com.example.roleauthorizedemo.controller;

import com.example.roleauthorizedemo.dto.LoginDto;
import com.example.roleauthorizedemo.dto.LoginResponse;
import com.example.roleauthorizedemo.dto.RegisterDto;
import com.example.roleauthorizedemo.entity.User;
import com.example.roleauthorizedemo.service.AuthenticationService;
import com.example.roleauthorizedemo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto dto){
        User user = service.register(dto);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginUserDto) {
        User authenticatedUser = service.login(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}

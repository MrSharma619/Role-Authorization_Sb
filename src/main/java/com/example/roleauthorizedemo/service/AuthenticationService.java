package com.example.roleauthorizedemo.service;

import com.example.roleauthorizedemo.dto.LoginDto;
import com.example.roleauthorizedemo.dto.RegisterDto;
import com.example.roleauthorizedemo.entity.Role;
import com.example.roleauthorizedemo.entity.User;
import com.example.roleauthorizedemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(RegisterDto dto){
        if (dto == null)
            return null;

        User user = new User(
                dto.getName(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getRole()
        );

        return repo.save(user);

    }

    public User login(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return repo.findByEmail(input.getEmail())
                .orElseThrow();
    }

}

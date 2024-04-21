package com.example.roleauthorizedemo;

import com.example.roleauthorizedemo.dto.LoginDto;
import com.example.roleauthorizedemo.dto.RegisterDto;
import com.example.roleauthorizedemo.entity.Role;
import com.example.roleauthorizedemo.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//simple authorization wont do
// so implementing authentication as well

//role based done

//permission based done
@SpringBootApplication
public class RoleAuthorizeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleAuthorizeDemoApplication.class, args);
	}

}

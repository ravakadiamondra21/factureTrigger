package com.example.FactureTrigger.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FactureTrigger.Dto.LoginResponseDto;
import com.example.FactureTrigger.Dto.UserLoginDto;
import com.example.FactureTrigger.Dto.UserRequestDto;
import com.example.FactureTrigger.Service.AuthService;
import com.example.FactureTrigger.Service.UserServiceTest;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "${app.cors.allowed-origin}")
public class UserController {
	
	private final UserServiceTest userService;
	private final AuthService auth;

	public UserController(UserServiceTest userService, AuthService auth) {
		super();
		this.userService = userService;
		this.auth = auth;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserRequestDto dto) {
		this.userService.createUser(dto);
		return ResponseEntity.ok("User created with success");
	}
	
	@PostMapping("/login")
	public LoginResponseDto login(@RequestBody UserLoginDto dto) {
		return this.auth.login(dto);
	}
}

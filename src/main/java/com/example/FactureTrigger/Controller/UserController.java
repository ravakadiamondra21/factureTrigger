package com.example.FactureTrigger.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FactureTrigger.Dto.UserRequestDto;
import com.example.FactureTrigger.Service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserRequestDto dto) {
		this.userService.createUser(dto);
		return ResponseEntity.ok("User created with success");
	}
}

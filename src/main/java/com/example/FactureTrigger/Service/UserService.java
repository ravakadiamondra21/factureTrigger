package com.example.FactureTrigger.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.FactureTrigger.Dto.UserDto;
import com.example.FactureTrigger.Dto.UserRequestDto;
import com.example.FactureTrigger.Model.User;
import com.example.FactureTrigger.Repository.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	private final PasswordEncoder pwdEncoder;
	
	public UserService(UserRepo userRepo, PasswordEncoder pwdEncoder) {
		super();
		this.userRepo = userRepo;
		this.pwdEncoder = pwdEncoder;
	}
	
	public void createUser(UserRequestDto dto) {
		
		if(this.userRepo.findByUserEmail(dto.getEmail()).isPresent()) {
			throw new RuntimeException("User already exists");
		}
		
		User user = new User();
		user.setUserEmail(dto.getEmail());
		user.setUserName(dto.getName());
		user.setPassword(this.pwdEncoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());
		
		this.userRepo.save(user);
	}
}

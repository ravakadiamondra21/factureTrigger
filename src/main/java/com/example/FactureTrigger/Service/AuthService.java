package com.example.FactureTrigger.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.FactureTrigger.Dto.LoginResponseDto;
import com.example.FactureTrigger.Dto.UserDto;
import com.example.FactureTrigger.Dto.UserLoginDto;
import com.example.FactureTrigger.Model.User;
import com.example.FactureTrigger.Repository.UserRepo;

@Service
public class AuthService {

	private final JwtService jwtService;
	private final UserRepo userRepo;
	private final PasswordEncoder passEnc;
	
	public AuthService(JwtService jwtService, UserRepo userRepo, PasswordEncoder passEnc) {
		super();
		this.jwtService = jwtService;
		this.userRepo = userRepo;
		this.passEnc = passEnc;
	}
	
	
	public LoginResponseDto login(UserLoginDto dto) {
		System.out.println("eto");
		System.out.println(dto.getUserEmail());
		System.out.println("sy eto");
		User user = this.userRepo.findByUserEmail(dto.getUserEmail()).orElseThrow();
		
		if(!passEnc.matches(dto.getPassword(), user.getPassword())) {
			throw new RuntimeException("password failed");
		}
		
		String token = this.jwtService.generateToken(user.getUserEmail());
		
		return new LoginResponseDto(user.getId_user(), user.getUserEmail(), user.getUserName(), token, user.getRole().name());
	}
	
}

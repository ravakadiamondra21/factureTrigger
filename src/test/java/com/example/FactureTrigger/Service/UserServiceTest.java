package com.example.FactureTrigger.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.FactureTrigger.Dto.UserRequestDto;
import com.example.FactureTrigger.Model.User;
import com.example.FactureTrigger.Repository.UserRepo;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Test
	void test() {
		
	}
	
	@Mock
	private UserRepo userRepo;
	
	@Mock
	private PasswordEncoder pwdEnc;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	void createUserTest() {
		
		UserRequestDto dto = new UserRequestDto();
        dto.setEmail("test@gmail.com");
        dto.setName("Test");
        dto.setPassword("1234");
        dto.setRole(null);
        
        when(userRepo.findByUserEmail(dto.getEmail()))
        	.thenReturn(Optional.empty());
        
        when(pwdEnc.encode("1234"))
        	.thenReturn("encodedPwd");
        
        userService.createUser(dto);
        
        verify(userRepo).save(any(User.class));
        

	}
	
	@Test
	void existUserTest() {
		UserRequestDto dto = new UserRequestDto();
        dto.setEmail("test@gmail.com");
        
        when(userRepo.findByUserEmail(dto.getEmail()))
        	.thenReturn(Optional.of(new User()));
        
        assertThrows(RuntimeException.class, () -> {
            userService.createUser(dto);
        });
	}

}

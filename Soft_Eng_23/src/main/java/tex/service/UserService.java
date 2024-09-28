package tex.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import tex.controller.dto.UserRegistrationDto;
import tex.model.User;

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	
	
}

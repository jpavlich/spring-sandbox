package com.example.demo.security;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class RESTAuthenticationProvider implements AuthenticationProvider {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		logger.info("Name = " + name + " ,Password = " + password);

		User user = findUser(name);
		if (user != null && password.equals(user.getPassword())) {
			logger.info("Succesful authentication!");
			return new UsernamePasswordAuthenticationToken(user, user.getPassword(), new ArrayList<>());
		} else {
			logger.info("Login fail!");
			return null;
		}
	}

	private User findUser(String username) {
		// TODO En este método debería recuperarlse la info del usuario desde la base de datos
		if (username.equals("user")) {
			return new User("user", "userPass");
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

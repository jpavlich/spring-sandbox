package com.example.demo.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController()
@RequestMapping("/api")
public class TestService {
	@RequestMapping(value = "/test", produces = "application/json")
	public String test() {
		return "{'value': 'ok'}";
	}
	
	@RequestMapping(value = "/current-user", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public User currentUserName(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user;
    }
	
}

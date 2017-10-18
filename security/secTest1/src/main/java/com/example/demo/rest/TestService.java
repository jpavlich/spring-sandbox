package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class TestService {
	@RequestMapping(value = "/test", produces = "application/json")
	public String test() {
		return "{'value': 'ok'}";
	}
}

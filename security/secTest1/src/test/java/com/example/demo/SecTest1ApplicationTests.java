package com.example.demo;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


// ver https://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SecTest1Application.class)
//@AutoConfigureMockMvc
public class SecTest1ApplicationTests {
	@Autowired
	private WebApplicationContext context;
	
//	@Autowired
//	private FilterChainProxy filterChain;
	

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(springSecurity())
//				.addFilter(filterChain)
				.build();
	}

	@Test
	public void authSuccess() throws Exception {
		mvc.perform(post("/login").param("username", "user").param("password", "password"))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void authWrongUser() throws Exception {
		mvc.perform(post("/login").param("username", "wrongUser").param("password", "userPass"))
			.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void authWrongPasswordr() throws Exception {
		mvc.perform(post("/login").param("username", "user").param("password", "wrongPass"))
			.andExpect(status().isUnauthorized());
	}

	
	@Test
	@WithUserDetails
	public void authorizedAction() throws Exception {
		mvc.perform(get("/api/test")).andExpect(status().isOk());
	}
	
	@Test
	@WithUserDetails
	public void logout() throws Exception {
		mvc.perform(get("/logout")).andExpect(status().isOk());
		mvc.perform(get("/api/test")).andExpect(status().isUnauthorized());
	}
	
	@Test
	@WithUserDetails
	public void getUserInfo() throws Exception {
		MvcResult result = mvc.perform(get("/api/current-user")).andExpect(status().isOk())
				.andExpect(content().json("{\"username\":\"user\",\"password\":\"password\"}"))
				.andReturn();
		
		System.out.println("Retrieved user: " + result.getResponse().getContentAsString());
		
	}
	
	

}

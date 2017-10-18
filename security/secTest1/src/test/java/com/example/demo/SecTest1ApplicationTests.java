package com.example.demo;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SecTest1Application.class)
@AutoConfigureMockMvc
public class SecTest1ApplicationTests {
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private FilterChainProxy filterChain;
	

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
		mvc.perform(post("/login").param("username", "user").param("password", "userPass"))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void authFail() throws Exception {
		mvc.perform(post("/login").param("username", "wrong_user").param("password", "userPass"))
			.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void authCookie() throws Exception {
		mvc.perform(post("/login").param("username", "user").param("password", "userPass"))
		.andExpect(cookie().exists("SESSION"));
	}
	
	@Test 
	public void authorizedAction() throws Exception {
		MvcResult result = mvc.perform(post("/login").param("username", "user").param("password", "userPass")).andReturn();
		Cookie c = result.getResponse().getCookie("SESSION");
		mvc.perform(get("/api/test").cookie(c)).andExpect(status().isOk());
	}

}

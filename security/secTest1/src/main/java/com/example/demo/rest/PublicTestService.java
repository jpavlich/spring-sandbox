package com.example.demo.rest;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/public")
public class PublicTestService {
	
	@RequestMapping(value = "/test", produces = "application/json")
	public String test() {
		return "{'value': 'ok'}";
	}
	
	 @RequestMapping(value = "/index.jsp")
	 public String index() {
		 return "index";
	 }
	@RequestMapping(value = "/report_viewer.jsp")
	public String viewer() {
	    return "report_viewer";
	}
	@RequestMapping(value = "/test.jsp")
	public String test2() {
	    return "test";
	}


	
}

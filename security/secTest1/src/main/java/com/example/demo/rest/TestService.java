package com.example.demo.rest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController()
@RequestMapping("/api")
public class TestService {

	@RequestMapping(value = "/test1", produces = "application/json")
	public String test() {
		return "{\"value\": \"ok\"}";
	}
	
	@RequestMapping(value = "/current-user", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public User currentUserName(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user;
    }
	@RequestMapping(value = "/test", produces = "application/xml")
	public String test2() {
		return "<service xmlns=\"http://www.w3.org/2007/app\" xmlns:atom=\"http://www.w3.org/2005/Atom\" xml:base=\"http://services.odata.org/V3/(S(p5nseo0mmpccjs4wb0w3bgx2))/OData/OData.svc/\">\n" + 
				"<workspace>\n" + 
				"<atom:title>Default</atom:title>\n" + 
				"<collection href=\"Products\">\n" + 
				"<atom:title>Products</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"ProductDetails\">\n" + 
				"<atom:title>ProductDetails</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Categories\">\n" + 
				"<atom:title>Categories</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Suppliers\">\n" + 
				"<atom:title>Suppliers</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Persons\">\n" + 
				"<atom:title>Persons</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"PersonDetails\">\n" + 
				"<atom:title>PersonDetails</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Advertisements\">\n" + 
				"<atom:title>Advertisements</atom:title>\n" + 
				"</collection>\n" + 
				"</workspace>\n" + 
				"</service>";
	}
}

package com.example.demo.security;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

class AuthorizationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		 HttpSession session = request.getSession(true);
		 System.out.println("Controlling access to " +
		 session.getAttribute("LOGGED_USER"));
		//
		/*System.out.println("##########\nRequest " + request.getMethod());

		printRequest(request);*/
		chain.doFilter(request, resp);
	}

	private void printRequest(HttpServletRequest httpRequest) {
		System.out.println("receive " + httpRequest.getMethod() + " notification for " + httpRequest.getRequestURI());

		System.out.println(" \n\n Headers");

		Enumeration headerNames = httpRequest.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			System.out.println(headerName + " = " + httpRequest.getHeader(headerName));
		}

		System.out.println("\n\nParameters");

		Enumeration params = httpRequest.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			System.out.println(paramName + " = " + httpRequest.getParameter(paramName));
		}

		System.out.println("\n\n Row data");
//		 System.out.println(extractPostRequestBody(httpRequest));
	}

	static String extractPostRequestBody(HttpServletRequest request) {
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			System.out.println("******" + request.getMethod());
			try {
				return  (request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		return "";
	}
}
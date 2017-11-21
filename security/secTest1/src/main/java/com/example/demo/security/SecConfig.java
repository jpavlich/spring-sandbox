package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RESTAuthenticationProvider authenticationProvider;
	
	@Autowired
	private RESTAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private RESTLogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	private RESTUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
		.and()
		/*.headers().frameOptions().disable()
		.disable();*/
			.csrf().disable()  // TODO Activar CSRF más adelante
			.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint)
			.and()
				.authorizeRequests()
					.antMatchers("/public/**", "/login/**","/example.svc/**","/api/**").permitAll()
					.anyRequest().authenticated()
			.and()
				.formLogin()
					.successHandler(authenticationSuccessHandler)
					.failureHandler(new SimpleUrlAuthenticationFailureHandler())
			.and()
				.logout()
					.logoutSuccessHandler(logoutSuccessHandler);
				
		
		http.addFilterAfter(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		//http.addFilterBefore(new CorsFilter(), SessionManagementFilter.class); //adds your custom CorsFilter
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return userDetailsService;
	}

	
}

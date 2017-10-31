package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name="user_prueba")
public class User implements UserDetails {
	@Id
	private String username;
	@Basic
	private String password;
	@Basic
	private boolean accountNonExpired;
	@Basic
	private boolean accountNonLocked;
	@Basic
	private boolean credentialsNonExpired;
	@Basic
	private boolean enabled;
	

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}


}

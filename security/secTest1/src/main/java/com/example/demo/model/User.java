package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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
	
	public User() {}
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

	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//@Column(nullable = true)
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	//@Column(nullable = true)
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	//@Column(nullable = true)
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	//@Column(nullable = true)
	public boolean isEnabled() {
		return enabled;
	}

	/*@Override

	public List<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


}

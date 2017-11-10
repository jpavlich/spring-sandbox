/**
 * 
 */
package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Emmanuel Neiza
 *
 */
@Entity(name="mytable")
public class EntidadNueva {
	@Id
	private int id;
	@Basic
	private String name;
	@Basic
	private String lastname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}

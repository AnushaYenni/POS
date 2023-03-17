package com.jsp.model;

/**
 * User.java
 * This is a model class represents a User entity
 *
 *
 */
public class User {
	protected int id;
	protected String name;
	protected String role;
	protected String login;
	
	public User() {
	}
	
	public User(String name, String role, String login) {
		super();
		this.name = name;
		this.role = role;
		this.login = login;
	}

	public User(int id, String name, String role, String login) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.login = login;
	}

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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
}

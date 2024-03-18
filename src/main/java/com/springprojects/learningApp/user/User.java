package com.springprojects.learningApp.user;


import java.util.List;

import com.springprojects.learningApp.todo.Todo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity  // map User bean to database table
public class User {
	
	public User() {
		
	}
	
	@Id  // primary key
	@GeneratedValue
	private int id;
	
	private String username;
	
	private String password;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Todo> todos;
	
	public User(int id, String username, String password, List<Todo> todos) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.todos = todos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", password=" + password;
	}
	
}
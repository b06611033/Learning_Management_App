package com.springprojects.learningApp.user;


import java.util.List;
import java.util.Set;

import com.springprojects.learningApp.course.Course;
import com.springprojects.learningApp.school.School;
import com.springprojects.learningApp.todo.Todo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Todo> todos;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "takes")
	Set<Course> courses;
	
	
	
	public User(int id, String username, String password, List<Todo> todos, School school, Set<Course> courses) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.todos = todos;
		this.school = school;
		this.courses = courses;
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
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", password=" + password;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
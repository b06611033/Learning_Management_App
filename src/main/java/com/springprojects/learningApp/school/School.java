package com.springprojects.learningApp.school;

import java.util.List;
import com.springprojects.learningApp.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity  // map User bean to database table
public class School {
	
	public School() {
		
	}
	
	@Id  // primary key
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String location;
	
	@OneToMany(mappedBy="school", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> students;
	
	public School(int id, String name, String location, List<User> students) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.students = students;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
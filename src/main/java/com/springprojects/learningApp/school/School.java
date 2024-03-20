package com.springprojects.learningApp.school;


import java.util.Set;

import com.springprojects.learningApp.course.Course;
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
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="school")
	private Set<User> students;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="school")
	private Set<Course> courses;
	
	
	public School(int id, String name, String location, Set<User> students, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.students = students;
		this.courses = courses;
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

	public 	Set<User> getStudents() {
		return students;
	}

	public void setStudents(Set<User> students) {
		this.students = students;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}
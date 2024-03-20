package com.springprojects.learningApp.course;

import java.util.Set;

import com.springprojects.learningApp.school.School;
import com.springprojects.learningApp.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id  // primary key
	@GeneratedValue
	private int id;
	
	public Course(int id, String coursename, String instructor, Set<User> takes, School school) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.instructor = instructor;
		this.takes = takes;
	}

	private String coursename;
	
	private String instructor;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			  name = "taken_by", 
			  joinColumns = @JoinColumn(name = "course_id"), 
			  inverseJoinColumns = @JoinColumn(name = "student_id"))
	Set<User> takes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Set<User> getTakes() {
		return takes;
	}

	public void setTakes(Set<User> takes) {
		this.takes = takes;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public Course() {
		
	}
	
}

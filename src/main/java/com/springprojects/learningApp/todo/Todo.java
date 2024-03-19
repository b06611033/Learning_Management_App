package com.springprojects.learningApp.todo;

import java.time.LocalDate;

import com.springprojects.learningApp.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity  // map Todo bean to database table
public class Todo {
	
	public Todo() {
		
	}
	
	@Id  // primary key
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private String description;
	
	private LocalDate targetDate;
	
	private boolean done;
	
	public Todo(int id, User user, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
}

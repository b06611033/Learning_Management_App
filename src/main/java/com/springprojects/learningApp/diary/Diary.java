package com.springprojects.learningApp.diary;

import java.time.LocalDate;

import com.springprojects.learningApp.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Diary {
	@Id  // primary key
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private String content;
	
	private LocalDate updateDate;
	
	public Diary(int id, User user, String content, LocalDate updateDate) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.updateDate = updateDate;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	
	public Diary() {
		
	}

}

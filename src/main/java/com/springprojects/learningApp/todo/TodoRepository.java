package com.springprojects.learningApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprojects.learningApp.user.User;


public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	public List<Todo> findByUser(User user);
}

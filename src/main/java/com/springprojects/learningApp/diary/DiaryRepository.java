package com.springprojects.learningApp.diary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springprojects.learningApp.user.User;

public interface DiaryRepository extends JpaRepository<Diary, Integer>{
	public List<Diary> findByUser(User user);
}

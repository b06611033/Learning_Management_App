package com.springprojects.learningApp.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprojects.learningApp.school.School;


public interface CourseRepository extends JpaRepository<Course, Integer>{
	public List<Course> findBySchool(School school);
}

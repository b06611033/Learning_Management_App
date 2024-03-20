package com.springprojects.learningApp.course;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springprojects.learningApp.user.User;

@Controller
@SessionAttributes({"name", "user"})
public class CourseController {
	
	private CourseRepository courseRepository;
	
	public CourseController(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	@RequestMapping(value="course",method = RequestMethod.GET)
	public String gotoCoursePage(ModelMap model) {
		User user = (User) model.get("user");
		//Set<Course> courses = user.getCourses();
		List<Course> allCourses = courseRepository.findAll();
		Set<Course> courses = new HashSet<>();
		for(Course c: allCourses) {
			Set<User> students = c.getTakes();
			for(User student: students) {
				if(student.getId() == user.getId()) {
					courses.add(c);
					break;
				}
			}
		}
		if(courses == null || courses.size()==0) {
			return "welcome";
		}
		user.setCourses(courses);
		model.addAttribute("courses", courses);
		return "listCourses";
	}
	
	@RequestMapping(value="add-course",method = RequestMethod.GET)
	public String gotoAddCoursePage(ModelMap model) {
		List<Course> courses = courseRepository.findAll();
		model.addAttribute("courses", courses);
		return "addCourse";
	}
	
	@RequestMapping(value="update-course",method = RequestMethod.GET)
	public String addCourse(@RequestParam int id, ModelMap model) {
		Course course = courseRepository.findById(id).get();
		User user = (User) model.get("user");
		int courseId = course.getId();
		Set<Course> courseTaken = user.getCourses();
		for(Course c: courseTaken) {
			if(c.getId() == courseId) return "welcome";
		}
		user.getCourses().add(course);
		course.getTakes().add(user);
		courseRepository.save(course);
		return "welcome";
	}
	
	@RequestMapping("delete-course")
	public String deleteCourse(@RequestParam int id, ModelMap model) {
		System.out.println("xxxxxxx");
		User user = (User) model.get("user");
		Course course = courseRepository.findById(id).get();
		int courseId = course.getId();
		Set<Course> courseTaken = user.getCourses();
		for(Course c: courseTaken) {
			if(c.getId() == courseId) {
				courseTaken.remove(c);
				break;
			}
		}
		Set<User> students = course.getTakes();
		for(User student: students) {
			if(student.getId() == user.getId()) {
				students.remove(student);
				break;
			}
		}
		courseRepository.save(course);
		return "redirect:course";
	}
}

package com.springprojects.learningApp.school;

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
public class SchoolController {
	
	private SchoolRepository schoolRepository;
	
	public SchoolController(SchoolRepository schoolRepository) {
		super();
		this.schoolRepository = schoolRepository;
	}
	
	@RequestMapping(value="school",method = RequestMethod.GET)
	public String gotoSchoolPage(ModelMap model) {
		User user = (User) model.get("user");
		School school = user.getSchool();
		if(school == null) {
			return "welcome";
		}
		model.addAttribute("school", school);
		return "listSchool";
	}
	
	@RequestMapping("delete-school")
	public String deleteSchool(ModelMap model) {
		System.out.println("xxxxxxx");
		User user = (User) model.get("user");
		School school = user.getSchool();
		Set<User> students = school.getStudents();
		user.setSchool(null);
		for(User s: students) {
			if(s.getId() == user.getId()) {
				students.remove(s);
				break;
			}
		}
		System.out.println(school.getName());
		schoolRepository.save(school);
		return "welcome";
	}
	
	@RequestMapping(value="add-school",method = RequestMethod.GET)
	public String gotoAddSchoolPage(ModelMap model) {
		List<School> schools = schoolRepository.findAll();
		model.addAttribute("schools", schools);
		return "addSchool";
	}
	
	@RequestMapping(value="update-school",method = RequestMethod.GET)
	public String addSchool(@RequestParam int id, ModelMap model) {
		System.out.println("--------");
		User user = (User) model.get("user");
		School school = schoolRepository.findById(id).get();
		Set<User> students = school.getStudents();
		for(User s: students) {
			if(s.getId() == user.getId()) {
				return "welcome";
			}
		}
		students.add(user);
		user.setSchool(school);
		System.out.println(user.getSchool().getName());
		schoolRepository.save(school);
		return "welcome";
	}
	
}

package com.springprojects.learningApp.school;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springprojects.learningApp.user.User;
import com.springprojects.learningApp.user.UserRepository;

@Controller
@SessionAttributes({"name", "user"})
public class SchoolController {
	
	private SchoolRepository schoolRepository;
	private UserRepository userRepository;
	
	public SchoolController(SchoolRepository schoolRepository, UserRepository userRepository) {
		super();
		this.schoolRepository = schoolRepository;
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value="school",method = RequestMethod.GET)
	public String gotoSchoolPage(ModelMap model) {
		User user = (User) model.get("user");
		School school = user.getSchool();
		if(school == null) {
			System.out.println("entered");
			return "welcome";
		}
		System.out.println(school.getLocation());
		model.addAttribute("school", school);
		return "listSchool";
	}
	
	@RequestMapping("delete-school")
	public String deleteTodo(ModelMap model) {
		User user = (User) model.get("user");
		user.setSchool(null);
		System.out.println(user.getSchool());
		userRepository.save(user);
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
		School school = schoolRepository.findById(id).get();
		User user = (User) model.get("user");
		user.setSchool(school);
		userRepository.save(user);
		return "welcome";
	}
	
}

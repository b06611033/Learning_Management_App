package com.springprojects.learningApp.school;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springprojects.learningApp.todo.Todo;
import com.springprojects.learningApp.user.User;

@Controller
@SessionAttributes({"name", "user"})
public class SchoolController {
	@RequestMapping(value="school",method = RequestMethod.GET)
	public String gotoSchoolPage(ModelMap model) {
		User user = (User) model.get("user");
		School school = user.getSchool();
		if(school == null) {
			return "addSchool";
		}
		System.out.println(school.getLocation());
		model.addAttribute("school", school);
		return "listSchool";
	}
	
}

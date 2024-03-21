package com.springprojects.learningApp.diary;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springprojects.learningApp.user.User;

@Controller
@SessionAttributes({"name", "user"})
public class DiaryController {
	public DiaryController(DiaryRepository diaryRepository) {
		super();
		this.diaryRepository = diaryRepository;
	}
	
	private DiaryRepository diaryRepository;
	
	@RequestMapping("list-diaries")
	public String listAllDiaries(ModelMap model) {
		User user = getLoggedInUsername(model);
		
		List<Diary> diaries = diaryRepository.findByUser(user);
		model.addAttribute("diaries", diaries);
		return "listDiaries";
	}

	private User getLoggedInUsername(ModelMap model) {
		
		return (User) model.get("user");
	}
	
	@RequestMapping(value="add-diary", method = RequestMethod.GET)
	public String showNewDiaryPage(ModelMap model) {
		User user = getLoggedInUsername(model);
		Diary diary = new Diary(0, user, "", LocalDate.now());
		model.put("diary", diary);
		return "diary";
	}
	
	@RequestMapping(value="add-diary", method = RequestMethod.POST)
	public String createNewDiary(Diary diary, ModelMap model, BindingResult result) {
		//input todo is binded with the info in todo.jsp
		User user = getLoggedInUsername(model);
		diary.setUser(user);
		diaryRepository.save(diary);
		return "redirect:list-diaries";
	}
	
	@RequestMapping("delete-diary")
	public String deleteDiary(@RequestParam int id) {
		diaryRepository.deleteById(id);
		return "redirect:list-diaries";
	}
	
	@RequestMapping(value = "update-diary", method = RequestMethod.GET)
	public String showUpdateDiaryPage(@RequestParam int id, ModelMap model) {
		Diary diary = diaryRepository.findById(id).get();
		model.addAttribute("diary", diary); // the found todo is binded with info on todo.jsp
		return "diary";
	}
	
	@RequestMapping(value = "update-diary", method = RequestMethod.POST)
	public String updateDiary(Diary diary, ModelMap model, BindingResult result) {
		User user = getLoggedInUsername(model);
		diary.setUser(user);
		diaryRepository.save(diary);
		return "redirect:list-diaries";
	}
}

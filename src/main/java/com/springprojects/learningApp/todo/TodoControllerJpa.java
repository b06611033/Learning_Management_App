package com.springprojects.learningApp.todo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springprojects.learningApp.user.User;



@Controller
@SessionAttributes({"name", "user"})
public class TodoControllerJpa {
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	
	private TodoRepository todoRepository;
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		User user = getLoggedInUsername(model);
		
		List<Todo> todos = todoRepository.findByUser(user);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	private User getLoggedInUsername(ModelMap model) {
		
		return (User) model.get("user");
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		User user = getLoggedInUsername(model);
		Todo todo = new Todo(0, user, "", LocalDate.now(), false);
		System.out.println("user is: ");
		System.out.println(todo.getUser());
		System.out.println(user);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String createNewTodo(Todo todo, ModelMap model, BindingResult result) {
		//input todo is binded with the info in todo.jsp
		System.out.println("user now is: ");
		System.out.println(todo.getUser());
		User user = getLoggedInUsername(model);
		todo.setUser(user);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo); // the found todo is binded with info on todo.jsp
		return "todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(Todo todo, ModelMap model, BindingResult result) {
		User user = getLoggedInUsername(model);
		todo.setUser(user);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
}

package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// /list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {

		List<Todo> listTodos = todoService.findByUsername(getLoggedinUsername());

		model.put("listTodos", listTodos);
		return "listTodos";

	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {

		Todo todo = new Todo(0, (String) model.get("name"), "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);

		return "todo";

	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo) {

		todoService.addTodo((String) model.get("name"), todo.getDescription(), todo.getTargetDate(), false);

		return "redirect:list-todos";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todoById = todoService.findTodoById(id);

		if (todoById != null)
			model.put("todo", todoById);

		return "todo";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, ModelMap model) {

		todo.setUsername((String) model.get("name"));
		todoService.updateTodo(todo);

		return "redirect:list-todos";

	}

	@RequestMapping("del-todo")
	public String delTodo(@RequestParam int id) {

		todoService.delTodoById(id);

		return "redirect:list-todos";

	}

	private String getLoggedinUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();

	}
}

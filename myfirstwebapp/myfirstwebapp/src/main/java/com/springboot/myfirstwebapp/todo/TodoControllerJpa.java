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

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	// Created an instance of todoRepository and injected it in the constructor as
	// well
	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;

	}

	// Declared findByUsername method in todoRepository interface and then called in
	// listAllTodos method
	// List<Todo> listTodos = todoRepository.findByUsername(getLoggedinUsername());
	// http:localhost:8080/list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {

		List<Todo> listTodos = todoRepository.findByUsername(getLoggedinUsername());

		model.put("listTodos", listTodos);
		return "listTodos";

	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {

		Todo todo = new Todo(0, (String) model.get("name"), "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);

		return "todo";

	}

	// Set the username in todo bean and then saved the
	// entire todo bean in the h2 db using todoRepository.save(todo)
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo) {

		todo.setUsername(getLoggedinUsername());
		todoRepository.save(todo);

		// todoService.addTodo((String) model.get("name"), todo.getDescription(),
		// todo.getTargetDate(), todo.isDone());

		return "redirect:list-todos";

	}

	// Found a todo bean object using todoRepository.findById(id).get()
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todoById = todoRepository.findById(id).get();
//		Todo todoById = todoService.findTodoById(id);

		if (todoById != null)
			model.put("todo", todoById);

		return "todo";

	}

	// Updated the todo using todoRepository.save(todo);
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, ModelMap model) {

		todo.setUsername((String) model.get("name"));
		todoRepository.save(todo);
//		todoService.updateTodo(todo);

		return "redirect:list-todos";

	}

	// Deleted todo using todoRepository.deleteById(id)
	@RequestMapping("del-todo")
	public String delTodo(@RequestParam int id) {

		todoRepository.deleteById(id);
		// todoService.delTodoById(id);

		return "redirect:list-todos";

	}

	private String getLoggedinUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();

	}
}

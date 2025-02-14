package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int todosCount = 0;

	static {

		todos.add(new Todo(++todosCount, "in28Minutes", "Learning AWS", LocalDate.now().plusYears(1), false));

		todos.add(new Todo(++todosCount, "in28Minutes", "Learning Spring Boot", LocalDate.now().plusYears(1), false));

		todos.add(new Todo(++todosCount, "in28Minutes", "Learning Full Stack Devlopment", LocalDate.now().plusYears(3),
				false));

	}

	
	public List<Todo> findByUsername(String username) {

		List<Todo> todosList = new ArrayList<>();

		for (int i = 0; i < todos.size(); i++) {

			if (todos.get(i).getUsername().equalsIgnoreCase(username)) {

				todosList.add(todos.get(i));
			}

		}

		return todosList;

	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {

		todos.add(new Todo(++todosCount, username, description, targetDate, done));

	}

	public Todo findTodoById(int id) {

		for (int i = 0; i < todos.size(); i++) {

			if (todos.get(i).getId() == id) {

				return todos.get(i);

			}
		}

		return null;

	}

	public void delTodoById(int id) {
		
		for (int i = 0; i < todos.size(); i++) {
			
			if (todos.get(i).getId() == id) {
				
				todos.remove(i);
				
			}
		}
		
//		Predicate<? super Todo> predicate=todo->todo.getId()==id;
//		todos.removeIf(predicate);
		
	}
	
//	public void updateTodo(int id, String description) {
//
//		for (int i = 0; i < todos.size(); i++) {
//
//			if (todos.get(i).getId() == id) {
//
//				todos.get(i).setDescription(description);
//
//			}
//		}
//
//	}

	public void updateTodo(Todo todo) {

		delTodoById(todo.getId());

		todos.add(todo);

	}

}

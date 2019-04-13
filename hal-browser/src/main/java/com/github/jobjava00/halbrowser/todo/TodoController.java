package com.github.jobjava00.halbrowser.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jobjava00
 */
@RestController
@RequestMapping("/api/v1")
public class TodoController {
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/users/{name}/todos")
	public List<Todo> getTodos(@PathVariable String name){
		var todos = List.of(todoService.create(1L, name, "내용"), todoService.create(2L, name, "내용2"));
		return todos;
	}
}

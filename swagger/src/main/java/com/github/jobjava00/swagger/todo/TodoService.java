package com.github.jobjava00.swagger.todo;

import org.springframework.stereotype.Service;

/**
 * @author jobjava00
 */
@Service
public class TodoService {
	public Todo create(Long id, String name, String detail){
		return new Todo(id, name, detail);
	}
}

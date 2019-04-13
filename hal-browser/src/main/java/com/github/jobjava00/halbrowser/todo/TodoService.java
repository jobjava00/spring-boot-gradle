package com.github.jobjava00.halbrowser.todo;

import com.github.jobjava00.halbrowser.configuration.ApplicationConfiguration;
import org.springframework.stereotype.Service;

/**
 * @author jobjava00
 */
@Service
public class TodoService {
	private final ApplicationConfiguration applicationConfiguration;

	public TodoService(ApplicationConfiguration applicationConfiguration) {
		this.applicationConfiguration = applicationConfiguration;
	}

	public Todo create(Long id, String name, String detail){
		System.out.println(applicationConfiguration.getName());
		System.out.println(applicationConfiguration.getUserId());
		System.out.println(applicationConfiguration.getTimeout());
		return new Todo(id, name, detail);
	}
}

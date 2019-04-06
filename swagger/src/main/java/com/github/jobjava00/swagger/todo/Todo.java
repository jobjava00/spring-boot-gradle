package com.github.jobjava00.swagger.todo;

import lombok.Getter;

import java.time.OffsetDateTime;

/**
 * @author jobjava00
 */
@Getter
public class Todo {
	private Long id;
	private String name;
	private String detail;
	private OffsetDateTime createDt;

	public Todo(Long id, String name, String detail) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.createDt = OffsetDateTime.now();
	}
}

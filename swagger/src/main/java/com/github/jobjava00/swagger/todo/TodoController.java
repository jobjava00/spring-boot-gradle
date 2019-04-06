package com.github.jobjava00.swagger.todo;

import io.swagger.annotations.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jobjava00
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;

	@GetMapping("/users/{name}/todos")
	@ApiOperation(
			value = "이름으로 유저의 모든 todos 검색",
			notes = "일치하는 todos 리스트가 반환된다. 현재 페이징은 지원되지 않는다."
	)
	public List<Todo> getTodos(@ApiParam(value = "이름") @PathVariable String name){
		var todos = List.of(todoService.create(1L, name, "내용"), todoService.create(2L, name, "내용2"));
		return todos;
	}

	@GetMapping("/users/{name}/todos/{id}")
	@ApiOperation(
			value = "이름으로 유저의 todo 검색",
			notes = "일치하는 todo 가 반환된다."
	)
	public Todo getTodo(@ApiParam(value = "이름") @PathVariable String name,
			@ApiParam(value = "아이디") @PathVariable Long id,
			@ApiParam(value = "내용") @RequestParam(defaultValue = "내용") String detail){
		return todoService.create(id, name, detail);
	}

	@PostMapping("/users")
	@ApiOperation(value = "회원 생성")
	public void create(UserRequest user){
		return;
	}

	@Getter
	@Setter
	public static class UserRequest{
		@ApiModelProperty(value = "이름")
		private String name;

		@ApiModelProperty(value = "나이")
		private int age;

		@ApiModelProperty(value = "생성일")
		private OffsetDateTime createDt;
	}
}

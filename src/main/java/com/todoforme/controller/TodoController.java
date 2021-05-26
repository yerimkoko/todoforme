package com.todoforme.controller;

import com.todoforme.domain.Todo;
import com.todoforme.dto.TodoRequestDto;
import com.todoforme.dto.TodoResponseDto;
import com.todoforme.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/api/v1/todo")
    public ApiResponse<Long> saveBoard(@RequestBody TodoRequestDto dto) {
        return ApiResponse.success(todoService.save(dto));
    }

    @GetMapping("/api/v1/todo/{id}")
    public ApiResponse<TodoResponseDto> retrieveTodo(@PathVariable Long id) {
        return ApiResponse.success(todoService.retrieveTodo(id));
    }

    @PutMapping("/api/v1/todo/{id}")
    public ApiResponse<TodoResponseDto> updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto dto) {
        return ApiResponse.success(todoService.reviseTodo(id, dto));
    }

    @DeleteMapping("/api/v1/todo/{id}")
    public ApiResponse<String> removeTodo(@PathVariable Long id) {
        todoService.removeTodo(id);
        return ApiResponse.OK;
    }

    @GetMapping("/api/v1/todo")
    public ApiResponse<List<TodoResponseDto>> retriveBoard() {
        return ApiResponse.success(todoService.retrieveALlTodoBoard());
    }

}

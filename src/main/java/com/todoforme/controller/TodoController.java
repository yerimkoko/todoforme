package com.todoforme.controller;

import com.todoforme.domain.Todo;
import com.todoforme.dto.TodoRequestDto;
import com.todoforme.dto.TodoResponseDto;
import com.todoforme.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/api/v1/todo")
    public Long saveBoard(@RequestBody TodoRequestDto dto) {
        return todoService.save(dto);
    }

    @GetMapping("/api/v1/todo/{id}")
    public TodoResponseDto retrieveTodo(@PathVariable Long id) {
        return todoService.retrieveTodo(id);
    }

    @PutMapping("/api/v1/todo/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto dto) {
        return todoService.reviseTodo(id, dto);
    }



}

package com.todoforme.service;

import com.todoforme.domain.Todo;
import com.todoforme.domain.TodoRepository;
import com.todoforme.dto.TodoRequestDto;
import com.todoforme.dto.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    @Transactional
    public Long save(TodoRequestDto dto) {
        return repository.save(dto.toEntity()).getId();
    }

    @Transactional
    public TodoResponseDto retrieveTodo(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 되는 게시물이 없습니다. id + " + id));
        return new TodoResponseDto(todo);
    }

    @Transactional
    public TodoResponseDto reviseTodo(Long id, TodoRequestDto dto) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 되는 게시물이 없습니다. id + " + id));
        todo.update(dto.getContent());
        return new TodoResponseDto();

    }
}

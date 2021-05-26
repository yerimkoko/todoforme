package com.todoforme.service;

import com.todoforme.domain.Todo;
import com.todoforme.domain.TodoRepository;
import com.todoforme.dto.TodoRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository repository;

    @AfterEach
    public void cleanUp() {
        repository.deleteAll();
    }

    @Test
    void todo에_게시글을_저장한다() {
        // given
        TodoRequestDto dto = TodoRequestDto.builder()
                .content("투두 만들기")
                .memberId(1L)
                .build();

        // when
        todoService.save(dto);

        // then
        Todo todo = repository.findAll().get(0);
        assertThat(todo.getContent()).isEqualTo(dto.getContent());
        assertThat(todo.getMemberId()).isEqualTo(dto.getMemberId());

    }

    @Test
    void todo에_게시글을_수정한다() {
        //given
        Todo todo = repository.save(Todo.builder()
                .content("승호")
                .memberId(1L)
                .build()
        );

        String content = "투두만들기";
        Long memberId = 1L;
        TodoRequestDto dto = TodoRequestDto.builder()
                .content(content)
                .memberId(memberId)
                .build();

        // when
        todoService.reviseTodo(todo.getId(), dto);

        // then
        Todo getTodo = repository.findAll().get(0);
        assertThat(getTodo.getContent()).isEqualTo(dto.getContent());
    }

    @Test
    void todo에_게시물을_삭제한다() {
        //given
        String content = "애슐리 가기";
        Long memberId = 1L;

        repository.save(Todo.builder()
                .content(content)
                .memberId(memberId)
                .build());
        //when
        todoService.removeTodo(memberId);

        //then
        assertThat(repository.findAll()).isEmpty();
    }



}

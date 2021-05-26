package com.todoforme.dto;

import com.todoforme.domain.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoResponseDto {

    private Long id;
    private Long memberId;
    private String content;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.memberId = todo.getMemberId();
        this.content = todo.getContent();
    }

}

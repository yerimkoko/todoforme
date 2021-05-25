package com.todoforme.dto;

import com.todoforme.domain.Todo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TodoRequestDto {

    private Long memberId;
    private String content;

    @Builder
    public TodoRequestDto (Long memberId, String content) {

        this.memberId = memberId;
        this.content = content;

    }

    public Todo toEntity() {
        return Todo.builder()
                .content(content)
                .memberId(memberId)
                .build();
    }

}

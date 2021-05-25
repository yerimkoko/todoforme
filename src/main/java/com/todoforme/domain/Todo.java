package com.todoforme.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Todo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String content;

    private boolean isDeleted;

    @Builder
    public Todo (Long memberId, String content) {
        this.memberId = memberId;
        this.content = content;
        this.isDeleted = false;
    }
    public void update(String content) {
        this.content = content;
    }

}

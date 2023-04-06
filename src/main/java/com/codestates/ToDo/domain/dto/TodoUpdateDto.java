package com.codestates.ToDo.domain.dto;

import lombok.Getter;

@Getter
public class TodoUpdateDto {
    private Long todoId;

    private String title;

    private int todo_order;

    private boolean completed;

}

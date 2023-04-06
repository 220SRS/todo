package com.codestates.ToDo.domain.dto;

import com.codestates.ToDo.domain.Todo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoResponseDto {

    private Long todoId;

    private String title;

    private int todo_order;

    private boolean completed;

    public static TodoResponseDto of(Todo todo) {
        TodoResponseDto todoResponseDto = new TodoResponseDto();
        todoResponseDto.setTodoId(todo.getTodoId());
        todoResponseDto.setTitle(todo.getTitle());
        todoResponseDto.setTodo_order(todo.getTodoOrder());
        todoResponseDto.setCompleted(todo.isCompleted());

        return todoResponseDto;
    }
}
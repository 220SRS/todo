package com.codestates.ToDo.domain;

import com.codestates.ToDo.domain.dto.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    private String title;

    private int todoOrder;

    private boolean completed;

    public static Todo of(TodoCreateDto todoCreateDto) {
        Todo todo = new Todo();

        todo.setTitle(todoCreateDto.getTitle());
        todo.setTodoOrder(todoCreateDto.getTodo_order());
        todo.setCompleted(false);
        return todo;
    }

    public void update(TodoUpdateDto todoUpdateDto) {
        if(todoUpdateDto.getTitle() != null) {
            this.title = todoUpdateDto.getTitle();
        }

        if(todoUpdateDto.getTodo_order() != 0) {
            this.todoOrder = todoUpdateDto.getTodo_order();
        }

        this.completed = todoUpdateDto.isCompleted();
    }
}

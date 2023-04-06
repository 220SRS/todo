package com.codestates.ToDo.domain.dto;

import com.codestates.ToDo.domain.Todo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoResponseDtoList {
    private List<TodoResponseDto> todoResponseDtoList;

    public static TodoResponseDtoList of(List<Todo> todoList) {

        TodoResponseDtoList response = new TodoResponseDtoList();
        List<TodoResponseDto> todoResponseDtos = todoList.stream()
                .map(TodoResponseDto::of)
                .collect(Collectors.toList());

        response.setTodoResponseDtoList(todoResponseDtos);

        return response;
    }
}

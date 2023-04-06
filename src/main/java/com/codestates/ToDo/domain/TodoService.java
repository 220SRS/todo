package com.codestates.ToDo.domain;

import com.codestates.ToDo.domain.dto.TodoCreateDto;
import com.codestates.ToDo.domain.dto.TodoResponseDto;
import com.codestates.ToDo.domain.dto.TodoResponseDtoList;
import com.codestates.ToDo.domain.dto.TodoUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto create(TodoCreateDto todoCreateDto) {
        Todo todo = Todo.of(todoCreateDto);

        todoRepository.save(todo);

        return TodoResponseDto.of(todo);
    }


    public TodoResponseDtoList findTodoList() {
        return TodoResponseDtoList.of(todoRepository.findAll());
    }


    public TodoResponseDto findTodo(Long id) {

        Todo findTodo = todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        return TodoResponseDto.of(findTodo);
    }


    @Transactional
    public TodoResponseDto updateTodo(TodoUpdateDto todoUpdateDto) {
        Todo todo = todoRepository.findById(todoUpdateDto.getTodoId()).orElseThrow(IllegalArgumentException::new);

        todo.update(todoUpdateDto);

        return TodoResponseDto.of(todo);
    }

    @Transactional
    public void deleteAllTodo() {
        todoRepository.deleteAll();
    }

    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}

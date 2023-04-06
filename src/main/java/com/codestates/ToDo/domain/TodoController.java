package com.codestates.ToDo.domain;

import com.codestates.ToDo.domain.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> CreateTodo (@RequestBody TodoCreateDto todoCreateDto) {

        TodoResponseDto todoResponseDto = todoService.create(todoCreateDto);

        return ResponseEntity.ok(todoResponseDto);
    }

    @GetMapping
    public ResponseEntity<TodoResponseDtoList> getTodoList () {

        TodoResponseDtoList todoResponseDtoList = todoService.findTodoList();

        return ResponseEntity.ok(todoResponseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getTodo (@PathVariable("id") Long id) {

        TodoResponseDto todoResponseDto = todoService.findTodo(id);

        return ResponseEntity.ok(todoResponseDto);
    }

    @PatchMapping
    public ResponseEntity<TodoResponseDto> updateTodo (@RequestBody TodoUpdateDto todoUpdateDto) {

        TodoResponseDto todoResponseDto = todoService.updateTodo(todoUpdateDto);

        return ResponseEntity.ok(todoResponseDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll () {

        todoService.deleteAllTodo();

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo (@PathVariable("id") Long id) {

        todoService.deleteTodo(id);

        return ResponseEntity.ok(null);
    }


}

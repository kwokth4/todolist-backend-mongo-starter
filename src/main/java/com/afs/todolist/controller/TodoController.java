package com.afs.todolist.controller;

import com.afs.todolist.controller.dto.TodoCreateRequest;
import com.afs.todolist.controller.dto.TodoUpdateRequest;
import com.afs.todolist.controller.mapper.TodoMapper;
import com.afs.todolist.entity.Todo;
import com.afs.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    List<Todo> getAll() {
        return todoService.findAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Todo createTodo(@RequestBody TodoCreateRequest todoCreateRequest){
        Todo todo = todoMapper.toEntity(todoCreateRequest);
        return todoService.createTodo(todo);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTodo(@PathVariable String id){
        todoService.deleteTodo(id);
    }
    @PutMapping("/{id}")
    Todo updateTodo(@PathVariable String id, @RequestBody TodoUpdateRequest todoUpdateRequest){
        Todo todo = todoMapper.toEntity(todoUpdateRequest);
        return todoService.updateTodo(id, todo);
    }
}

//@CrossOrigin method
//@CrossOrigin controller
//WebMvcConfigure
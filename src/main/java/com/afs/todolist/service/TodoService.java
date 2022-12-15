package com.afs.todolist.service;

import com.afs.todolist.entity.Todo;
import com.afs.todolist.exception.InvalidIdException;
import com.afs.todolist.exception.TodoNotFoundException;
import com.afs.todolist.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    private void validateObjectId(String id){
        if(!ObjectId.isValid(id)){
            throw new InvalidIdException(id);
        }
    }
    public void deleteTodo(String id) {
        validateObjectId(id);
        todoRepository.deleteById(id);
    }
    public Todo findById(String id){
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }
    public Todo updateTodo(String id, Todo todo) {
        Todo targetTodo = findById(id);
        targetTodo.setText(todo.getText());
        targetTodo.setDone(todo.getDone());
        return todoRepository.save(targetTodo);
    }
}

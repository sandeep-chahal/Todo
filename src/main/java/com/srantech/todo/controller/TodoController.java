package com.srantech.todo.controller;

import com.srantech.todo.model.TodoPojo;
import com.srantech.todo.repository.TodoRepository;
import com.srantech.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.srantech.todo.exception.UserNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class TodoController {


    private TodoService todoService;
    private TodoRepository todoRepository;
    private TodoPojo todoPojo;


    @Autowired
    public TodoController(TodoService todoService, TodoRepository todoRepository ) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;

    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoPojo>> getAll(){

       return todoService.getAllTodos() ;
   }

   @PostMapping("/todos")
    public ResponseEntity<TodoPojo> addNewTodo(@RequestBody TodoPojo todoPojo){

       return todoService.addNewTodo(todoPojo);
   }

   @GetMapping("/todos/{id}")
    public ResponseEntity<TodoPojo> getById(@PathVariable Long id){

        return todoService.getTodoById(id);
    }

   @PutMapping("/todos/{id}")
    public ResponseEntity<TodoPojo> updateTodo(@PathVariable Long id,@RequestBody TodoPojo todoPojo){

        return todoService.updateTodo(id,todoPojo);
   }

   @DeleteMapping("/todos/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteTodoById(@PathVariable Long id){

       return todoService.deleteTodo(id);
   }


}

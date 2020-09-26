package com.srantech.todo.controller;

import com.srantech.todo.model.TodoPojo;
import com.srantech.todo.repository.TodoRepository;
import com.srantech.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {


    private TodoService todoService;
    private TodoRepository todoRepository;


    @Autowired
    public TodoController(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/allTodos")
    public List<TodoPojo>  getAll(){

       return todoService.getAllTodos();
   }

}

package com.srantech.todo.controller;

import com.srantech.todo.model.TodoPojo;
import com.srantech.todo.repository.TodoRepository;
import com.srantech.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TodoController {


    private TodoService todoService;
    private TodoRepository todoRepository;


    @Autowired
    public TodoController(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public List<TodoPojo>  getAll(){

       return todoService.getAllTodos();
   }

   @PostMapping("/todos")
    public TodoPojo addNewTodo(@RequestBody TodoPojo todoPojo){

        return todoService.addNewTodo(todoPojo);
   }

   @GetMapping("/todos/{id}")
    public TodoPojo getById(@PathVariable Long id){
        return todoService.getTodoById(id);
   }

   @PutMapping("/todos/{id}")
    public TodoPojo updateTodo(@PathVariable Long id,@RequestBody TodoPojo todoPojo){
        return todoService.updateTodo(todoPojo);
   }

   @DeleteMapping("/todos/{id}")
    public void deleteTodoById(@PathVariable Long id){
        todoService.deleteTodo(id);
   }


}

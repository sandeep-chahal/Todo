package com.srantech.todo.controller;

import com.srantech.todo.model.TodoPojo;
import com.srantech.todo.repository.TodoRepository;
import com.srantech.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<TodoPojo>>  getAll(){

        List<TodoPojo> list = todoService.getAllTodos();

        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

       return ResponseEntity.of(Optional.of(list));
   }

   @PostMapping("/todos")
    public ResponseEntity<TodoPojo> addNewTodo(@RequestBody TodoPojo todoPojo){

        if(todoPojo == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(todoService.addNewTodo(todoPojo)));
   }

   @GetMapping("/todos/{id}")
    public ResponseEntity<TodoPojo> getById(@PathVariable Long id){
           try{
           TodoPojo p = null;
          p =  this.todoService.getTodoById(id);
           return ResponseEntity.ok().body(p);
       }
       catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

   @PutMapping("/todos/{id}")
    public TodoPojo updateTodo(@PathVariable Long id,@RequestBody TodoPojo todoPojo){

        return todoService.updateTodo(todoPojo);
   }

   @DeleteMapping("/todos/{id}")
    public ResponseEntity<TodoPojo> deleteTodoById(@PathVariable Long id){

       try{
          this.todoService.deleteTodo(id);
           return ResponseEntity.ok().build()   ;
       }
       catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
   }


}

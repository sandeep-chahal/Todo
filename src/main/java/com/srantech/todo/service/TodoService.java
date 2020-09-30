package com.srantech.todo.service;

import com.srantech.todo.exception.UserNotFoundException;
import com.srantech.todo.model.TodoPojo;
import com.srantech.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public ResponseEntity<List<TodoPojo>> getAllTodos(){

        List<TodoPojo> list = todoRepository.findAll();

        if(list.size() != 0){

            return ResponseEntity.ok().body(list);

        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    public ResponseEntity<TodoPojo> addNewTodo(TodoPojo todoPojo){

        TodoPojo p = null;

        if(p == null){

            ResponseEntity.of(Optional.of(HttpStatus.BAD_REQUEST));

        }

        return ResponseEntity.ok(todoRepository.save(todoPojo));

    }

    public ResponseEntity<TodoPojo> getTodoById(Long id){

        TodoPojo todoPojo = todoRepository.findById(id).orElseThrow(()->
                new UserNotFoundException("User does not exist with id  " + id ));
        return ResponseEntity.ok(todoPojo);

    }

    public ResponseEntity<TodoPojo> updateTodo(Long id , TodoPojo todoPojo){

      TodoPojo todo = todoRepository.findById(id).orElseThrow(()->
              new UserNotFoundException("User not found with id " + id));

       todo.setTask(todo.getTask());
       todo.setDescription(todo.getDescription());
       todo.setDate(todo.getDate());

       TodoPojo updatePojo = todoRepository.save(todo);
        return  ResponseEntity.ok(updatePojo);
    }

    public ResponseEntity<Map<String,Boolean>> deleteTodo(Long id){

       TodoPojo todo =  todoRepository.findById(id).orElseThrow(()->
               new UserNotFoundException("User not found with id " + id));


       todoRepository.delete(todo);
       Map<String,Boolean> response = new HashMap<>();
       response.put("deleted",Boolean.TRUE);
       return ResponseEntity.ok(response);

    }
}

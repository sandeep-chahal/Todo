package com.srantech.todo.service;

import com.srantech.todo.model.TodoPojo;
import com.srantech.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoPojo> getAllTodos(){
        return todoRepository.findAll();
    }


}

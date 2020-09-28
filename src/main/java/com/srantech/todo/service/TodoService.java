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

    public TodoPojo addNewTodo(TodoPojo todoPojo){
        return todoRepository.save(todoPojo);
    }

    public TodoPojo getTodoById(Long id){
        return todoRepository.getOne(id);
    }

    public TodoPojo updateTodo(TodoPojo todoPojo){
        return todoRepository.save(todoPojo);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}

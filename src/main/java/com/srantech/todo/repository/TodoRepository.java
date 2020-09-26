package com.srantech.todo.repository;

import com.srantech.todo.model.TodoPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoPojo,Long> {

}

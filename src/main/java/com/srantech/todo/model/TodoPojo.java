package com.srantech.todo.model;

import java.time.LocalDate;

public class TodoPojo {

    private long id;

    private String task;

    private String description;

    private LocalDate date;

    public TodoPojo(){

    }

    public TodoPojo(long id, String task, String description, LocalDate date) {
        this.id = id;
        this.task = task;
        this.description = description;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TodoPojo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}

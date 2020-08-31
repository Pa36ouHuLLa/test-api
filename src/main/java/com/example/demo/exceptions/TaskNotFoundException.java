package com.example.demo.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public TaskNotFoundException(String msg) {
        super(msg);
    }

}

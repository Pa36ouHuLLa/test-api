package com.example.demo.controllers;

import com.example.demo.entities.Task;
import com.example.demo.entities.TaskDto;
import com.example.demo.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(service.getTasks());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task task = service.getById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody TaskDto task) {
        return ResponseEntity.ok(service.addTask(task));
    }

    @PutMapping("/tasks")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return ResponseEntity.ok(service.updateTask(task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(service.removeTask(id));
    }

    @DeleteMapping("/tasks")
    public ResponseEntity<List<Task>> deleteTasks(@RequestBody List<Task> tasks) {
        return ResponseEntity.ok(service.removeTasks(tasks));
    }
}

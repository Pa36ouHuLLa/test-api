package com.example.demo.services.impl;

import com.example.demo.entities.Task;
import com.example.demo.entities.TaskDto;
import com.example.demo.exceptions.TaskNotFoundException;
import com.example.demo.factories.TaskFactory;
import com.example.demo.repository.TaskRepository;
import com.example.demo.services.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskFactory factory;

    public TaskServiceImpl(TaskRepository repository, TaskFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public List<Task> getTasks() {
        return repository.findAll();
    }

    public Task addTask(TaskDto dto) {
        Task task = factory.getTask(dto);
        return repository.save(task);
    }

    @Override
    public List<Task> addTasks(List<TaskDto> dtoList) {
        return repository.saveAll(dtoList.stream()
                .map(factory::getTask)
                .collect(Collectors.toList()));
    }

    @Transactional
    public Task updateTask(Task task) {
        Optional<Task> forUpdate = repository.findById(task.getId());
        if (forUpdate.isEmpty()) {
            throw new TaskNotFoundException(String.format("Task with id: %s doesn't exists", task.getId()));
        }
        Task updated = forUpdate.get();
        updated.setText(task.getText());
        return updated;
    }

    @Override
    public List<Task> updateTasks(List<Task> taskList) {
        return null;
    }

    public Task getById(long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException(String.format("Task with id: %s doesn't exists", id));
        }
        return task.get();
    }

    public Task removeTask(long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException(String.format("Task with id: %s doesn't exists", id));
        }
        repository.deleteById(id);
        return task.get();
    }

    public List<Task> removeTasks(List<Task> taskList) {
        repository.deleteAll(taskList);
        return taskList;
    }


}

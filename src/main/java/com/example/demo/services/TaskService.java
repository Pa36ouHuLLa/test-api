package com.example.demo.services;

import com.example.demo.entities.Task;
import com.example.demo.entities.TaskDto;
import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    Task addTask(TaskDto dto);

    List<Task> addTasks(List<TaskDto> dtoList);

    Task updateTask(Task task);

    List<Task> updateTasks(List<Task> taskList);

    Task getById(long id);

    Task removeTask(long id);

    List<Task> removeTasks(List<Task> taskList);
}

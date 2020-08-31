package com.example.demo.factories;

import com.example.demo.entities.Task;
import com.example.demo.entities.TaskDto;

public interface TaskFactory {
    Task getTask(TaskDto dto);
}

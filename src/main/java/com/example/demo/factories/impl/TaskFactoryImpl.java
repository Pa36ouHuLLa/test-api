package com.example.demo.factories.impl;

import com.example.demo.entities.Task;
import com.example.demo.entities.TaskDto;
import com.example.demo.factories.TaskFactory;
import org.springframework.stereotype.Component;

@Component
public class TaskFactoryImpl implements TaskFactory {
    @Override
    public Task getTask(TaskDto dto) {
        Task task = new Task();
        task.setText(dto.getText());
        return task;
    }
}

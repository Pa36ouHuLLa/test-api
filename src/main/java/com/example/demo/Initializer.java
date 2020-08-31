package com.example.demo;

import com.example.demo.entities.TaskDto;
import com.example.demo.services.TaskService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Initializer {

    public final TaskService taskService;

    public Initializer(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostConstruct
    private void init(){
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(TaskDto.builder()
                .text("Initial task 1")
                .build());
        taskDtoList.add(TaskDto.builder()
                .text("Initial task 2")
                .build());
        taskDtoList.add(TaskDto.builder()
                .text("Initial task 3")
                .build());
        taskService.addTasks(taskDtoList);
    }
}

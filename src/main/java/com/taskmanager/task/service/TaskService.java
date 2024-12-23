package com.taskmanager.task.service;

import com.taskmanager.task.models.Task;
import com.taskmanager.task.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    ITaskRepository taskRepository;

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
}

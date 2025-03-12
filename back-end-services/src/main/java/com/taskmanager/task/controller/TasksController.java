package com.taskmanager.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.task.models.TaskDTO;
import com.taskmanager.task.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/tasks")
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Object> listTasks(){
        return taskService.getTasks();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> listTask(@PathVariable Long id){   
        return taskService.getTask(id);
    }
    @PostMapping
    public ResponseEntity<Object> createTask(@RequestBody TaskDTO task){
        return taskService.createTask(task);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateTask(@RequestBody TaskDTO task,@PathVariable Long id){
        return taskService.updateTask(task, id);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
}

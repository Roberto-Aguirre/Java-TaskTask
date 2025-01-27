package com.taskmanager.task.service;

import com.taskmanager.task.models.TaskDTO;
import com.taskmanager.task.models.Status;
import com.taskmanager.task.models.Task;
import com.taskmanager.task.repository.IStatusRepository;
import com.taskmanager.task.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    ITaskRepository taskRepository;
    @Autowired
    IStatusRepository statusRepository;

    ResponseEntity<Object> not_found = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    public ResponseEntity<Object> getTasks() {
        return new ResponseEntity<>(taskRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Object> getTask(Long id) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return new ResponseEntity<>(optionalTask.get(),HttpStatus.OK);
        }
        return not_found;

    }

    public ResponseEntity<Object> createTask(TaskDTO newTask) {
        Status embebedStatus = statusRepository.findById(newTask.getStatus_id()).get();
        Task createdTask = new Task(newTask, embebedStatus);
        try {
            return new ResponseEntity<>(taskRepository.save(createdTask),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> updateTask(TaskDTO updatedTask, Long id) {
        
        Optional<Status> embebedStatus = statusRepository.findById(updatedTask.getStatus_id());
        if (!embebedStatus.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        Task createdTask = new Task(updatedTask, embebedStatus.get());

        Optional<Task> oldTask = taskRepository.findById(id);
        if (oldTask.isPresent()) {
           try {
            Task taskToUpdate = oldTask.get();
            taskToUpdate.update(createdTask);
            return new ResponseEntity<>(taskRepository.save(taskToUpdate),HttpStatus.OK) ;
           } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
           }
            
        }
        return not_found;
    }

    public ResponseEntity<Object> deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
        try {
            taskRepository.deleteById(id);
            return ResponseEntity.ok(new HashMap<String, String>().put("Mensaje", "Eliminado correctamente"));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
        return not_found;
    }
}

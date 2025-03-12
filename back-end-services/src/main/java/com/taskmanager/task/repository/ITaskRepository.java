package com.taskmanager.task.repository;

import com.taskmanager.task.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task,Long> {
    
}

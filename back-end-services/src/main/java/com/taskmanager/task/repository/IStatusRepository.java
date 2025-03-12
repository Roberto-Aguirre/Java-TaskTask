package com.taskmanager.task.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.task.models.Status;

public interface IStatusRepository extends JpaRepository<Status,Long>{

}

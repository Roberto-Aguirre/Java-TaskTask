package com.taskmanager.task.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name = "finish_date")
    private LocalDate finishDate;
    @ManyToOne(targetEntity = Status.class)
    private Status status;
    private Boolean priority;


    public void update(Task newTask){
        this.id= newTask.getId();
        this.title= newTask.getTitle();
        this.description= newTask.getDescription();
        this.startDate= newTask.getStartDate();
        this.finishDate= newTask.getFinishDate();
        this.status= newTask.getStatus();
        this.priority= newTask.getPriority();
    }
    public Task(TaskDTO dto,Status status){
        this.id= dto.getId();
        this.title= dto.getTitle();
        this.description= dto.getDescription();
        this.startDate= dto.getStartDate();
        this.finishDate= dto.getFinishDate();
        this.status= status;
        this.priority= dto.getPriority();
    }
}

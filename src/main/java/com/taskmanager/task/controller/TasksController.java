package com.taskmanager.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TasksController {


    @GetMapping("/home")
    public String getIndex(){
        return "home";
    }

}

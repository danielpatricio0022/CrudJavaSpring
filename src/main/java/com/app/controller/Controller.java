package com.app.controller;

import com.app.entity.Task;
import com.app.repository.TaskRepositoryInterface;
import com.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class Controller {

    @Autowired
    TaskService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})//response
    public List<Task> findAll(){
        return service.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public Task create(@RequestBody Task task){
    return service.createTask(task);
    }

}

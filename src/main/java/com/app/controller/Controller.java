package com.app.controller;

import com.app.entity.Task;
import com.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
//http://localhost:8080/api/task
public class Controller {

    @Autowired
    TaskService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})//response
    public List<Task> findAll(){
        return service.findAll();
    }


//http://localhost:8080/api/task/id
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) //response formated
    public Task findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }


//Header Accept = application/json
//       ContentType = application/json
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},//request
                 produces = {MediaType.APPLICATION_JSON_VALUE}) //response formated
    public Task create(@RequestBody Task task){
    return service.createTask(task);
    }
    /* {
        "title": "buy groceries",
        "description": "buy milk, bread, and eggs",
        "status": true
    }*/


    //Header Accept = application/json
//    ContentType = application/json
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},//request
                produces = {MediaType.APPLICATION_JSON_VALUE}) //response formated
    public Task update(@RequestBody Task task){
        return service.update(task);
    }

    //http://localhost:8080/api/task/id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

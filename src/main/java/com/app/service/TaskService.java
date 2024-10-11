package com.app.service;

import com.app.entity.Task;
import com.app.repository.TaskRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

  private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

@Autowired
  TaskRepositoryInterface repository;

public List<Task> findAll(){
    List<Task> listEntity = repository.findAll();
    logger.info("Finding all task!");
    return listEntity;
}

public Task createTask(Task task){
  if(task == null){
    logger.error("error, task cant is null");
    throw new RuntimeException("task null");
  }
  var entity = repository.save(task);
  return entity;
}







}

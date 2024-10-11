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
  logger.info("Finding all task!");
    List<Task> listEntity = repository.findAll();
    return listEntity;
}

public Task findById(Long id){
  var task = repository.findById(id);

  if (task.isPresent()) {
    return task.get();
  } else {
    throw new RuntimeException("Task not found with id: " + id);
  }
}

public Task createTask(Task task){
  if(task == null){
    logger.error("error, task cant is null");
    throw new RuntimeException("task null");
  }
   repository.save(task);
  return task;
}

  public Task update(Task task) {
    if (task == null) throw new RuntimeException("Task cannot be null");
    logger.info("Updating one task!");

    Task entity = repository.findById(task.getId()).orElseThrow
            (() -> new RuntimeException("not found id"));
    entity.setTitle(task.getTitle());
    entity.setDescription(task.getDescription());
    entity.setStatus(task.getStatus());

    return repository.save(entity);
  }

  public void delete(Long id){
    logger.info("Deleting Task!");
    var entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("No records found for this ID!"));
    repository.delete(entity);

  }




}

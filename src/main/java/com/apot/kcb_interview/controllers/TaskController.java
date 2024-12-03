package com.apot.kcb_interview.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apot.kcb_interview.models.entities.Task;
import com.apot.kcb_interview.services.TaskService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/tasks")
public class TaskController {

  private TaskService taskService;

  TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PutMapping("/{taskId}")
  public void updateTask(@PathVariable Long taskId, @RequestBody Task task) {
    this.taskService.updateTask(taskId, task);
  }

  @DeleteMapping("/{taskId}")
  public void deleteTask(@PathVariable Long taskId) {
    this.taskService.deleteTask(taskId);
  }
}

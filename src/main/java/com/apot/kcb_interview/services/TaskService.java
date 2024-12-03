package com.apot.kcb_interview.services;

import org.springframework.stereotype.Service;

import com.apot.kcb_interview.models.entities.Task;
import com.apot.kcb_interview.repos.TaskRepository;

@Service
public class TaskService {

  private TaskRepository taskRepository;

  TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void updateTask(Long taskId, Task task) {
    // Just incase
    task.setId(taskId);
    taskRepository.save(task);
  }

  public void deleteTask(Long taskId) {
    taskRepository.deleteById(taskId);
  }

}

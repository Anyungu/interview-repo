package com.apot.kcb_interview.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apot.kcb_interview.models.dtos.CreateProjectDto;
import com.apot.kcb_interview.models.dtos.CreateTaskDto;
import com.apot.kcb_interview.models.entities.Project;
import com.apot.kcb_interview.models.entities.Task;
import com.apot.kcb_interview.models.enums.Status;
import com.apot.kcb_interview.services.ProjectService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/projects")
public class ProjectController {

  private ProjectService projectService;

  ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @PostMapping("")
  public Project addProject(@Valid @RequestBody CreateProjectDto createProjectDto) {
    return this.projectService.addProject(createProjectDto);
  }

  @GetMapping("")
  public List<Project> getProjects() {
    return this.projectService.getProjects();
  }

  @GetMapping("/{projectId}")
  public Project getProjectById(@PathVariable Long projectId) {
    return this.projectService.getProjectById(projectId);
  }

  @PostMapping("/{projectId}/tasks")
  public void addTaskToProject(@PathVariable Long projectId, @Valid @RequestBody CreateTaskDto createTaskDto) {
    this.projectService.addTaskToProject(projectId, createTaskDto);
  }

  @GetMapping("/{projectId}/tasks")
  public Page<Task> getProjectTasks(
      @PathVariable Long projectId,
      @RequestParam(required = false) Status status,
      @RequestParam(required = false) Date dueDate,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size) {
    return this.projectService.getProjectTasks(projectId, status, dueDate, page, size);
  }

  @GetMapping("/summary")
  public Object getProjectsSummary() {
    return this.projectService.getProjectsSummarry();
  }

}

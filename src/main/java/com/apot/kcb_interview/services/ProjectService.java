package com.apot.kcb_interview.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apot.kcb_interview.models.dtos.CreateProjectDto;
import com.apot.kcb_interview.models.dtos.CreateTaskDto;
import com.apot.kcb_interview.models.entities.Project;
import com.apot.kcb_interview.models.entities.Task;
import com.apot.kcb_interview.models.enums.Status;
import com.apot.kcb_interview.repos.ProjectRepository;
import com.apot.kcb_interview.repos.TaskRepository;

import org.springframework.data.domain.Pageable;

@Service
public class ProjectService {

  private ProjectRepository projectRepository;
  private TaskRepository taskRepository;

  ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
    this.projectRepository = projectRepository;
    this.taskRepository = taskRepository;
  }

  public Project addProject(CreateProjectDto createProjectDto) {
    Project project = new Project(createProjectDto.getName(), createProjectDto.getDescription());
    return projectRepository.save(project);
  }

  public List<Project> getProjects() {
    return projectRepository.findAll();

  }

  public Project getProjectById(Long projectId) {
    return projectRepository.findById(projectId).orElse(null);
  }

  public Task addTaskToProject(Long projectId, CreateTaskDto createTaskDto) {
    Project project = projectRepository.findById(projectId).orElse(null);
    if (project == null) {
      return null;
    }
    Task task = new Task(createTaskDto.getName(), createTaskDto.getDescription(), createTaskDto.getTitle(),
        createTaskDto.getReleaseDate(), project);
    return taskRepository.save(task);
  }

  public Page<Task> getProjectTasks(Long projectId, Status status, Date releaseDate, int page, int size) {
    Pageable pageable = PageRequest.of(page - 1, size);
    return taskRepository.findByProjectIdAndStatusAndReleaseDate(projectId, status, releaseDate, pageable);
  }

  public Object getProjectsSummarry() {
    return projectRepository.getProjectSummary();
  }

}

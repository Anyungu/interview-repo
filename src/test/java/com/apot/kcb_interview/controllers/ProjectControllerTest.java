package com.apot.kcb_interview.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.apot.kcb_interview.models.dtos.CreateTaskDto;
import com.apot.kcb_interview.models.entities.Project;
import com.apot.kcb_interview.models.entities.Task;
import com.apot.kcb_interview.models.enums.Status;
import com.apot.kcb_interview.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private ProjectService projectService;

    @Test
    void getProjectTasks_shouldReturnPagedTasks() throws Exception {

        Long projectId = 1L;

        Project project = new Project(1L, "test", "test", null);

        Task task1 = new Task(1L, "Task 1", "Description 1", "Title 1", Status.TO_DO, new Date(), project);
        Task task2 = new Task(2L, "Task 2", "Description 2", "Title 2", Status.IN_PROGRESS, new Date(), project);

        // Fixed initialization

        Page<Task> taskPage = new PageImpl<>(Arrays.asList(task1, task2), PageRequest.of(0, 10), 2);

        // Mock service call
        when(projectService.getProjectTasks(eq(projectId), any(), any(), eq(1), eq(10))).thenReturn(taskPage);

        // Perform GET request
        mockMvc.perform(get("/api/v1/projects/{projectId}/tasks", projectId)
                .contentType(MediaType.APPLICATION_JSON)
                .param("page", "1")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.content[0].name", is("Task 1")))
                .andExpect(jsonPath("$.content[1].status", is("IN_PROGRESS")));

        // Verify service interaction
        verify(projectService, times(1)).getProjectTasks(eq(projectId), any(), any(), eq(1), eq(10));
    }
}

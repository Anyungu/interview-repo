package com.apot.kcb_interview.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apot.kcb_interview.models.entities.Task;
import com.apot.kcb_interview.models.enums.Status;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByProjectId(Long projectId);

  Page<Task> findByProjectIdAndStatusAndReleaseDate(
      Long projectId,
      Status status,
      java.util.Date releaseDate,
      Pageable pageable);
}

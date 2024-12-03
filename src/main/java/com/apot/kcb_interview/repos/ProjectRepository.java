package com.apot.kcb_interview.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apot.kcb_interview.models.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT pro.name, pro.description, tas.status AS status, COUNT(tas) AS taskCount FROM Project pro JOIN pro.tasks tas GROUP BY pro.id, tas.status")
    List<Object[]> getProjectSummary();
  

}

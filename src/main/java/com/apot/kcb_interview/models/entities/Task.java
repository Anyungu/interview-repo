package com.apot.kcb_interview.models.entities;

import java.util.Date;

import com.apot.kcb_interview.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NonNull
  private String name;
  @NonNull
  private String description;
  @NonNull
  private String title;

  @Enumerated(EnumType.STRING)
  private Status status = Status.TO_DO;

  @NonNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MM-YYYY")
  private Date releaseDate;

  @JsonIgnore
  @NonNull
  @ManyToOne
  @JoinColumn(name = "projectId")
  private Project project;

}

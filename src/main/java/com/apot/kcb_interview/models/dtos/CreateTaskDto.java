package com.apot.kcb_interview.models.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTaskDto {

  @NotNull(message = "Enter a valid Name")
  private String name;

  @NotNull(message = "Enter a valid Name")
  @Size(min = 20, message = "Description must be at least 20 characters")
  private String description;

  @NotNull(message = "Enter a valid Name")
  private String title;

  @NotNull(message = "Relese Date")
  @PastOrPresent(message = "valid date")
  private Date releaseDate;

  @NotNull(message = "Enter a valid Name")
  @Positive(message = "Invalid")
  private Long projectId;

}

package com.apot.kcb_interview.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProjectDto {

  @NotNull(message = "Enter a valid Name")
  private String name;

  @NotNull(message = "Enter a valid Description")
  private String description;

}

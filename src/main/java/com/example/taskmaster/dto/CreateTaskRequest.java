package com.example.taskmaster.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class CreateTaskRequest {
    @NotBlank
    private String title;

    private String description;
    private LocalDateTime dueDate;
    private Long assignedTo;
    private Long teamId;

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public Long getAssignedTo() { return assignedTo; }
    public void setAssignedTo(Long assignedTo) { this.assignedTo = assignedTo; }

    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }
}
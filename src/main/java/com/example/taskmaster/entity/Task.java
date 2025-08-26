package com.example.taskmaster.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;


    @Column(length = 2000)
    private String description;


    private LocalDateTime dueDate;


    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.OPEN;


    @ManyToOne
    private User assignee;


    @ManyToOne
    private User reporter;


    @ManyToOne
    private Team team;


    private LocalDateTime createdAt = LocalDateTime.now();


    public Task() {}


    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }
    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public User getAssignee() { return assignee; }
    public void setAssignee(User assignee) { this.assignee = assignee; }
    public User getReporter() { return reporter; }
    public void setReporter(User reporter) { this.reporter = reporter; }
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
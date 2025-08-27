package com.example.taskmaster.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    private String fileType;
    private Long fileSize;
    private String filePath;
    private LocalDateTime uploadedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User uploadedBy;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public Long getFileSize() { return fileSize; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }

    public User getUploadedBy() { return uploadedBy; }
    public void setUploadedBy(User uploadedBy) { this.uploadedBy = uploadedBy; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    @PrePersist
    protected void onCreate() {
        uploadedAt = LocalDateTime.now();
    }
}
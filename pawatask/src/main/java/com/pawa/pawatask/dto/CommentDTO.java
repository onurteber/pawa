package com.pawa.pawatask.dto;

public class CommentDTO {
    private String content;
    private String createdBy;
    private String taskId;

    public CommentDTO() {
    }

    public CommentDTO(String content, String createdBy, String taskId) {
        this.content = content;
        this.createdBy = createdBy;
        this.taskId = taskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}

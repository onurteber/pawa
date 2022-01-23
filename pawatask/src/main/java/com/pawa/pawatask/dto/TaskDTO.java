package com.pawa.pawatask.dto;

import com.pawa.pawatask.domain.Priority;

public class TaskDTO {
    private String id;
    private String title;
    private String description;
    private String day;
    private String month;
    private String year;
    private Priority priority;
    private String comment;
    private String createdBy;
    private String lastUpdatedBy;

    public TaskDTO() {
    }

    public TaskDTO(String id, String title, String description, String day, String month, String year, Priority priority, String comment, String createdBy, String lastUpdatedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
        this.priority = priority;
        this.comment = comment;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}

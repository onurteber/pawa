package com.pawa.pawatask.dto;

import com.pawa.pawatask.domain.Priority;

public class TaskBaseDTO {
    private String title;
    private String description;
    private String day;
    private String month;
    private String year;
    private Priority priority;
    private String createdBy;
    private String lastUpdatedBy;

    public TaskBaseDTO() {
    }

    public TaskBaseDTO(String title, String description, String day, String month, String year, Priority priority, String createdBy, String lastUpdatedBy) {
        this.title = title;
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
        this.priority = priority;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
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

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

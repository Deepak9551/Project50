package com.Spring.took.Project50.Todo_List;

import java.time.LocalDateTime;

public class Task implements Comparable<Task>{
    private String title;
    private String description;
    private boolean isDone;
    private LocalDateTime createdAt;

    public Task(String title, String description, boolean isDone, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.createdAt = createdAt;
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(Task o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}

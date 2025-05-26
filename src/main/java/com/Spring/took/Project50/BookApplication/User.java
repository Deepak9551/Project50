package com.Spring.took.Project50.BookApplication;

import java.util.List;

public class User {
    private String userId;
    private String username;
    private String email;
    private List<String> borrowedBookIds;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", borrowedBookIds=" + borrowedBookIds +
                '}';
    }

    public User(String userId, String username, String email, List<String> borrowedBookIds) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.borrowedBookIds = borrowedBookIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getBorrowedBookIds() {
        return borrowedBookIds;
    }

    public void setBorrowedBookIds(List<String> borrowedBookIds) {
        this.borrowedBookIds = borrowedBookIds;
    }
}

package com.example.mocomp;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private String username;
    private String role;
    private int employmentPercent;

    public UserProfile(String username, String role, int employmentPercent) {
        this.username = username;
        this.role = role;
        this.employmentPercent = employmentPercent;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public int getEmploymentPercent() {
        return employmentPercent;
    }
}

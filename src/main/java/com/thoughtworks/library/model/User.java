package com.thoughtworks.library.model;

import static com.thoughtworks.library.model.Role.ADMIN;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Role role;
    private String token;
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String roleName) {
        this.role = Role.parse(roleName);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public boolean isAdmin() {
        return this.getRole().equals(ADMIN);
    }
}

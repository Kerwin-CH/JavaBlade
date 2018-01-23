package com.huruwo.demo.bean;

public class ResUsers {

    // user表主键
    private Integer uid;

    // 用户名称
    private String username;

    // 用户的邮箱
    private String email;

    private String token;

    public ResUsers(Integer uid, String username, String email, String token) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
}

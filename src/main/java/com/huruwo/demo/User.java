package com.huruwo.demo;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;

@Table(value = "t_user")
public class User extends ActiveRecord {

    private Integer id;
    private String  username;
    private String  password;
    private Integer age;
    private String  realName;

    // getter and setter

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}


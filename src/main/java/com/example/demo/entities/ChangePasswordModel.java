package com.example.demo.entities;

public class ChangePasswordModel {
    int id;
    String password;
    String oldpassword;

    public ChangePasswordModel(int id, String password, String oldpassword) {
        this.id = id;
        this.password = password;
        this.oldpassword = oldpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }
}

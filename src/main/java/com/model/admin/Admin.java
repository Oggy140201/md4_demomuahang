package com.model.admin;

public class Admin {
    private String root;
    private String pw;

    public Admin(String root, String pw) {
        this.root = root;
        this.pw = pw;
    }

    public Admin() {
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}

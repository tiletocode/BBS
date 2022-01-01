package com.tiletocode.bbs;

import java.sql.Timestamp;

public class BoardInfo {
    private int n;
    private String title;
    private String id;
    private Timestamp time;
    private String pass;
    private String content;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
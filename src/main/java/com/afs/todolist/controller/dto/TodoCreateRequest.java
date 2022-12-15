package com.afs.todolist.controller.dto;

public class TodoCreateRequest {
    private String text;



    private Boolean done;

    public TodoCreateRequest(String text, Boolean done) {
        this.text = text;
        this.done = done;
    }


    public String getText() {
        return text;
    }
    public Boolean getDone() {
        return done;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void setDone(Boolean done) {
        this.done = done;
    }
}

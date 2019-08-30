package com.example.todolist;

import java.util.UUID;

public class Task {
    private UUID ID = UUID.randomUUID();
    private String Ttile;
    private String date;
    private boolean done;
    private boolean important;
    private String time;

    public String getTtile() {
        return this.Ttile;
    }

    public void setTtile(String ttile) {
        this.Ttile = ttile;
    }

    public UUID getId() {
        return this.ID;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isImportant() {
        return this.important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

}
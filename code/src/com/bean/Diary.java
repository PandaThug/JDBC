package com.bean;

import java.util.Date;

public class Diary {
    private int number;
    private Date date;
    private String content;
    public Diary() {}
    public Diary(int number, Date date, String content) {
        this.number = number;
        this.date = date;
        this.content = content;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Diary{" +
                "number=" + number +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}

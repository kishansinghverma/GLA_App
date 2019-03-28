package com.example.gla_app;

import java.io.Serializable;

public class Question implements Serializable {

    private String que;
    private String[] options;
    private int marks;
    private int selected;
    private int correct;

    public Question() {
        this.que = null;
        this.options = null;
        this.marks = 0;
        this.selected = 0;
        this.correct = 0;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}

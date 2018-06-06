package com.example.insodroid1.myapplication;

import java.util.ArrayList;

public class Model {

    public enum STATE {
        CLOSED,
        OPENED
    }

    String name;
    int level;
    STATE state = STATE.CLOSED;
    String designation;
    ArrayList<Model> models = new ArrayList<>();

    public Model(String name, int level , String designation) {
        this.name = name;
        this.level = level;
        this.designation = designation;
    }

}

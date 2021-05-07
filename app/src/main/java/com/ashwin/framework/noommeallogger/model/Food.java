package com.ashwin.framework.noommeallogger.model;

public class Food {
    private String id;

    private String name;

    public Food(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

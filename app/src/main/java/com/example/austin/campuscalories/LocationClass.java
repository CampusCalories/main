package com.example.austin.campuscalories;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LocationClass implements Serializable{

    public LocationClass(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

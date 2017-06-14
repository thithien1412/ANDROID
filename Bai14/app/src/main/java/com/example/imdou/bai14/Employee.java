package com.example.imdou.bai14;

/**
 * Created by imdou on 6/14/2017.
 */

public class Employee {
    private String id;
    private String name;
    private boolean gender;
    public String getId() {
    return id;
    }
    public void setId(String id) {
    this.id = id;
    }
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
    public boolean isGender() {
    return gender;
    }
    public void setGender(boolean gender) {
    this.gender = gender;
    }
    @Override
    public String toString() {
    return this.id+"-"+this.name;
}

}

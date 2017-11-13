package com.lanou.hr.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Department {
    private String depID;
    private String depName;
    private Set<Post> posts = new HashSet<>();



    public Department(String depID, String depName) {
        this.depID = depID;
        this.depName = depName;
    }

    public Department(String depName) {
        this.depName = depName;
    }

    public Department() {
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID=" + depID +
                ", depName='" + depName + '\'' +
                '}';
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}

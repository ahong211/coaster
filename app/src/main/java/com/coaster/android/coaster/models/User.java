package com.coaster.android.coaster.models;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class User {
    private String name;
    private String email;
    private String id;
    private List<String> friends = new ArrayList<>();

    @Inject
    public User() {
        // Required empty constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addFriend(String email) {
        this.friends.add(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", friends=" + friends +
                '}';
    }
}

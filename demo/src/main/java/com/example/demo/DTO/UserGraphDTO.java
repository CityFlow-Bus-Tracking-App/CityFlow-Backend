package com.example.demo.DTO;

import com.example.demo.Model.Bus;
import com.example.demo.Model.Location;
import com.example.demo.Model.Station;

import java.util.List;

public class UserGraphDTO {
    public Integer id;
    public String name;

    public String lastname;
    public String username;

    public UserGraphDTO(){}

    public UserGraphDTO(Integer id, String name, String lastname, String username) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

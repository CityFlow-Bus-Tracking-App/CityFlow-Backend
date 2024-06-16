package com.example.demo.DTO;

import com.example.demo.Model.Bus;
import com.example.demo.Model.Location;
import com.example.demo.Model.Station;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

public class RouteGraphDTO {
    public Integer id;
    public String name;

    public List<Location> locations;
    public List<Station> stations;
    public List<Bus> buses;
    public RouteGraphDTO(){}

    public RouteGraphDTO(Integer id, String name, List<Location> locations, List<Station> stations, List<Bus> buses) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.stations = stations;
        this.buses = buses;
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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}

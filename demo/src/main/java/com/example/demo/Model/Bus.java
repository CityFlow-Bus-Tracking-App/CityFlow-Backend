package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column
    public String licencePlate;

    @ManyToMany
    @JoinTable(
            name = "bus_route",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    @JsonIgnoreProperties("buses")
    public List<Route> routes;

    public Bus() {
    }

    public Bus(String licencePlate) {
        this.licencePlate = licencePlate;
        this.routes = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}

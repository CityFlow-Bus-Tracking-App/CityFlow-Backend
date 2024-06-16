package rs.ac.uns.acs.nais.GraphDatabaseExample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Location;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl.LocationService;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @PostMapping("/save")
    public Location createLocation(@RequestBody Location location){
        return locationService.save(location);
    }
}

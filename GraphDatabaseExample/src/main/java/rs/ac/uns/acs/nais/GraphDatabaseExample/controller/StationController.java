package rs.ac.uns.acs.nais.GraphDatabaseExample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Station;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl.StationService;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService){
        this.stationService = stationService;
    }

    @PostMapping("/save")
    public Station createStation(@RequestBody Station station){
        return stationService.save(station);
    }
}

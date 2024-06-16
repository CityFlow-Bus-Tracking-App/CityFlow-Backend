package rs.ac.uns.acs.nais.GraphDatabaseExample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Bus;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl.BusService;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService){
        this.busService = busService;
    }

    @PostMapping("/save")
    public Bus createBus(@RequestBody Bus bus){
        return busService.save(bus);
    }
}

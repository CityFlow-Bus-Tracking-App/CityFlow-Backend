package rs.ac.uns.acs.nais.GraphDatabaseExample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Route;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl.RouteService;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @PostMapping("/save")
    public Route createRoute(@RequestBody Route route){
        return routeService.save(route);
    }

    @GetMapping("/findByName")
    public Mono<ResponseEntity<Route>> findByName(@RequestParam String name) {
        return routeService.findByName(name)
                .map(route -> ResponseEntity.ok(route))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteByName")
    public Mono<ResponseEntity<Void>> deleteByName(@RequestParam String name) {
        return routeService.deleteByName(name)
                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/atLeastThreeStations")
    public List<String> getRoutesWithAtLeastThreeStations() {
        return routeService.getRouteNamesWithAtLeastThreeStations();
    }

    @GetMapping("/{routeName}/stations/count")
    public Integer getStationCountForRoute(@PathVariable String routeName) {
        return routeService.countStationsForRoute(routeName);
    }

    @GetMapping("/popular")
    public List<String> getPopularRoutes() {
        return routeService.getMostPopularRouteNames();
    }


    @GetMapping("/longest")
    public String getLongestRouteName() {
        return routeService.findLongestRouteName();
    }
}

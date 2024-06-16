package com.example.demo.Service;

import com.example.demo.DTO.RouteGraphDTO;
import com.example.demo.Model.Bus;
import com.example.demo.Model.Location;
import com.example.demo.Model.Route;
import com.example.demo.Model.Station;
import com.example.demo.Repository.BusRepository;
import com.example.demo.Repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusService busService;

    private final WebClient webClient;


    public Route save(Route route){
        Route savedRoute = routeRepository.save(route);

        RouteGraphDTO routeGraph = new RouteGraphDTO();

        routeGraph.setId(savedRoute.id);
        routeGraph.setName(savedRoute.name);
        routeGraph.setBuses(savedRoute.buses);

        List<Location> locations = new ArrayList<>();
        List<Station> stations = new ArrayList<>();

        locations.add(savedRoute.startingPoint);
        locations.addAll(savedRoute.stations);
        locations.add(savedRoute.endPoint);

        for(Location loc : locations){
            Station station = new Station();
            station.setLocation(loc);
            stations.add(station);
        }
        routeGraph.setLocations(locations);
        routeGraph.setStations(stations);

        sendRouteToGraphDatabase(routeGraph);
        return savedRoute;
    }

    private void sendRouteToGraphDatabase(RouteGraphDTO route) {
        webClient.post()
                .uri("http://localhost:8080/api/routes/save")
                .bodyValue(route)
                .retrieve()
                .bodyToMono(RouteGraphDTO.class)
                .subscribe(
                        result -> System.out.println("Route saved in graph database with ID: " + result.getId()),
                        error -> System.err.println("Failed to save route in graph database: " + error.getMessage())
                );
    }

    public Route findById(Integer id){
        Optional<Route> optionalRoute = routeRepository.findById(id);
        return optionalRoute.orElse(null);
    }
    public Route getById(int id) {
        return routeRepository.findById(id).orElse(null);
    }

    public Route getByStartingPoint(Location startingPoint){
        return routeRepository.getByStartingPoint(startingPoint);
    }
    public void deleteBusFromRoute(Integer routeId, Integer busId){
        Route selectedRoute = findById(routeId);
        Bus busToRemove = this.busService.findById(busId);
        if(selectedRoute != null && busToRemove != null){
            List<Bus> routeBuses = selectedRoute.getBuses();
            List<Route> busRoutes = busToRemove.getRoutes();

            routeBuses.removeIf(bus -> bus.id.equals(busId));
            busRoutes.removeIf(route -> route.id.equals(routeId));

            //save(selectedRoute);
            this.busService.save(busToRemove);
        }
    }
    public Route getByEndPoint(Location endPoint){
        return routeRepository.getByEndPoint(endPoint);
    }

    public List<Route> getAll(){
        return routeRepository.findAll();
    }

    public void deleteById(Integer id){
        Route route = findById(id);
        routeRepository.deleteById(id);
        deleteRouteInGraphDatabase(route.name);
    }
    private void deleteRouteInGraphDatabase(String routeName) {
        webClient.delete()
                .uri(uriBuilder -> uriBuilder.scheme("http")
                        .host("localhost")
                        .port(8080)
                        .path("/api/routes/deleteByName")
                        .queryParam("name", routeName)
                        .build())
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe(
                        result -> System.out.println("Route deleted in graph database: " + routeName),
                        error -> System.err.println("Failed to delete route in graph database: " + error.getMessage())
                );
    }

}

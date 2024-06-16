package com.example.demo.Service;

import com.example.demo.Model.Bus;
import com.example.demo.Model.Location;
import com.example.demo.Model.Station;
import com.example.demo.Repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    private final WebClient webClient;

    public Location save(Location location){
        Location savedLocation = locationRepository.save(location);
        Station station = new Station(savedLocation);
        //sendLocationToGraphDatabase(savedLocation, station);
        return savedLocation;
    }

//    private void sendLocationToGraphDatabase(Location location, Station station) {
//        webClient.post()
//                .uri("http://localhost:8080/api/location/save")
//                .bodyValue(location)
//                .retrieve()
//                .bodyToMono(Location.class)
//                .subscribe(
//                        result -> System.out.println("Location saved in graph database with ID: " + result.getId()),
//                        error -> System.err.println("Failed to save location in graph database: " + error.getMessage())
//                );
//
//        webClient.post()
//                .uri("http://localhost:8080/api/stations/save")
//                .bodyValue(station)
//                .retrieve()
//                .bodyToMono(Station.class)
//                .subscribe(
//                        result -> System.out.println("Station saved in graph database with ID: " + result.getId()),
//                        error -> System.err.println("Failed to save station in graph database: " + error.getMessage())
//                );
//    }

    public Location getByLatitudeAndLongiture(double latitude, double longitude){
        return locationRepository.getByLatitudeAndLongitude(latitude, longitude);
    }

}

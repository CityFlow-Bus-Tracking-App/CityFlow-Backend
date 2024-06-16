package rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Route;
import rs.ac.uns.acs.nais.GraphDatabaseExample.repository.RouteRepository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.IRouteService;

import java.util.List;

@Service
public class RouteService implements IRouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    @Override
    @Transactional
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Mono<Route> findByName(String name){
        return Mono.fromCallable(() -> routeRepository.findByName(name))
                .flatMap(optionalRoute -> optionalRoute.isPresent() ? Mono.just(optionalRoute.get()) : Mono.empty());
    }

    @Override
    @Transactional
    public Mono<Void> deleteByName(String name) {
        return Mono.fromRunnable(() -> routeRepository.deleteByName(name));
    }

    @Override
    public List<String> getRouteNamesWithAtLeastThreeStations() {
        return routeRepository.findRouteNamesWithAtLeastThreeStations();
    }

    @Override
    public Integer countStationsForRoute(String routeName) {
        return routeRepository.countStationsOnRoute(routeName);
    }

    @Override
    public List<String> getMostPopularRouteNames() {
        return routeRepository.findMostPopularRouteNamesByNumberOfUsers();
    }

    @Override
    public String findLongestRouteName() {
        return routeRepository.findLongestRouteNameByTotalDistance();
    }
}

package rs.ac.uns.acs.nais.GraphDatabaseExample.service;

import reactor.core.publisher.Mono;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Route;

import java.util.List;

public interface IRouteService {
    Route save(Route route);
    Mono<Route> findByName(String name);
    Mono<Void> deleteByName(String name);
    List<String> getRouteNamesWithAtLeastThreeStations();
    Integer countStationsForRoute(String routeName);
    List<String> getMostPopularRouteNames();
    String findLongestRouteName();
}

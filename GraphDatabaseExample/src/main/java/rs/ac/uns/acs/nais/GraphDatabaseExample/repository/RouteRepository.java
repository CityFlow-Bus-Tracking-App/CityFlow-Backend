package rs.ac.uns.acs.nais.GraphDatabaseExample.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Route;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface RouteRepository extends Neo4jRepository<Route, Long> {
    Optional<Route> findByName(String name);
    void deleteByName(String name);

    @Query("MATCH (r:Route)-[:PASSES_THROUGH]->(s:Station) WITH r, count(s) AS numberOfStations WHERE numberOfStations >= 3 RETURN r.name")
    List<String> findRouteNamesWithAtLeastThreeStations();

    @Query("MATCH (r:Route)-[:PASSES_THROUGH]->(s:Station) WHERE r.name = $routeName RETURN count(s) AS numberOfStations")
    Integer countStationsOnRoute(@Param("routeName") String routeName);

    @Query("MATCH (u:User)-[:RAN]->(r:Route) WITH r, count(u) AS numUsers ORDER BY numUsers DESC RETURN r.name")
    List<String> findMostPopularRouteNamesByNumberOfUsers();

    @Query("MATCH (r:Route)-[:PASSES_THROUGH]->(s:Station)-[:SITUATED_AT]->(l:Location) " +
            "WITH r, collect(l) AS locations " +
            "UNWIND locations AS l1 " +
            "UNWIND locations AS l2 " +
            "WITH r, sum(point.distance(point({latitude: l1.latitude, longitude: l1.longitude}), point({latitude: l2.latitude, longitude: l2.longitude}))) AS totalDistance " +
            "RETURN r.name ORDER BY totalDistance DESC LIMIT 1")
    String findLongestRouteNameByTotalDistance();

}

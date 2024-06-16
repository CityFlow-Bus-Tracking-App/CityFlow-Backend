package rs.ac.uns.acs.nais.GraphDatabaseExample.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.UserRouteSelection;

import java.util.Optional;

@Repository
public interface UserRouteSelectionRepository extends Neo4jRepository<UserRouteSelection, Long> {
    @Query("MATCH (u:User {username: $username}), (r:Route {name: $routename}) " +
            "MERGE (u)-[s:SELECTED]->(r) " +
            "ON CREATE SET s.selectionCount = 1 " +
            "ON MATCH SET s.selectionCount = s.selectionCount + 1 ")
    void createOrUpdateSelection(@Param("username") String username, @Param("routename") String routename);

    @Query("MATCH (u:User {username: $username}) " +
            "OPTIONAL MATCH (u)-[s:SELECTED]->(r:Route) " +
            "WITH r, s " +
            "ORDER BY s.selectionCount DESC " +
            "LIMIT 1 " +
            "RETURN COALESCE(r.name, 'None') AS routeName")
    String findMostFrequentedRouteByUsername(@Param("username") String username);
}

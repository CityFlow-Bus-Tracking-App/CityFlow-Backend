package rs.ac.uns.acs.nais.GraphDatabaseExample.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Location;

@Repository
public interface LocationRepository extends Neo4jRepository<Location, Long> {
}

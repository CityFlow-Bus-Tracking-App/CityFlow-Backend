package rs.ac.uns.acs.nais.GraphDatabaseExample.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Bus;

@Repository
public interface BusRepository extends Neo4jRepository<Bus, Long> {
}

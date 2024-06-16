package rs.ac.uns.acs.nais.GraphDatabaseExample.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Station {
    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "SITUATED_AT", direction = Relationship.Direction.OUTGOING)
    private Location location;

    @Relationship(type = "PASSES_THROUGH", direction = Relationship.Direction.INCOMING)
    private List<Route> routes;

    public Station() {}

    public Station(Long id, Location location, List<Route> routes) {
        this.id = id;
        this.location = location;
        this.routes = routes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}

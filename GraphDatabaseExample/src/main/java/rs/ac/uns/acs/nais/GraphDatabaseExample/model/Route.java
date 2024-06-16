package rs.ac.uns.acs.nais.GraphDatabaseExample.model;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class Route {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;

    @Relationship(type = "OPERATED_BY", direction = Relationship.Direction.INCOMING)
    private List<Bus> buses;

    @Relationship(type = "PASSES_THROUGH", direction = Relationship.Direction.OUTGOING)
    private List<Station> stations;

    public Route(){}

    public Route(Long id, String name, List<Bus> buses, List<Station> stations) {
        this.id = id;
        this.name = name;
        this.buses = buses;
        this.stations = stations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}

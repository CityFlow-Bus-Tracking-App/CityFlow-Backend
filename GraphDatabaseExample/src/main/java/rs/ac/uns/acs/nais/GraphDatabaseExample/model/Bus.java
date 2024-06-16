package rs.ac.uns.acs.nais.GraphDatabaseExample.model;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;


@Node
public class Bus {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String licencePlate;

    @Relationship(type = "OPERATES_ON", direction = Relationship.Direction.OUTGOING)
    private List<Route> busRoutes;

    public Bus() {
    }

    public Bus(Long id, String licencePlate, List<Route> routes) {
        this.id = id;
        this.licencePlate = licencePlate;
        this.busRoutes = routes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public List<Route> getBusRoutes() {
        return busRoutes;
    }

    public void setBusRoutes(List<Route> busRoutes) {
        this.busRoutes = busRoutes;
    }
}

package rs.ac.uns.acs.nais.GraphDatabaseExample.model;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private double latitude;

    @Property
    private double longitude;

    @Relationship(type = "SITUATED_AT", direction = Relationship.Direction.INCOMING)
    private Station station;

    public Location() {}

    public Location(Long id, double latitude, double longitude, Station station) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.station = station;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}

package rs.ac.uns.acs.nais.GraphDatabaseExample.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class UserRouteSelection {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private Route route;

    private int selectionCount;

    public UserRouteSelection() {
    }

    public UserRouteSelection(Route route, int selectionCount) {
        this.route = route;
        this.selectionCount = selectionCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getSelectionCount() {
        return selectionCount;
    }

    public void setSelectionCount(int selectionCount) {
        this.selectionCount = selectionCount;
    }
}

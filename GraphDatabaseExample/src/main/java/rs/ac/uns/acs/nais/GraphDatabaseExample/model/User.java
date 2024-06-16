package rs.ac.uns.acs.nais.GraphDatabaseExample.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;

    @Property
    private String lastname;

    @Property
    private String username;

    public User(){}

    public User(Long id, String name, String lastname, String username){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

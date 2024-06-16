package rs.ac.uns.acs.nais.GraphDatabaseExample.dto;

public class SearchDTO {
    private String username;
    private String routename;

    public SearchDTO(){}

    public SearchDTO(String username, String routename) {
        this.username = username;
        this.routename = routename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }
}

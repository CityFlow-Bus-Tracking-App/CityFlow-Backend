package rs.ac.uns.acs.nais.GraphDatabaseExample.service;

import rs.ac.uns.acs.nais.GraphDatabaseExample.model.UserRouteSelection;

import java.util.Optional;

public interface IUserRouteSelectionService {
    void createOrUpdateUserRouteSelection(String username, String routename);

    String getMostFrequentedRoute(String username);

}

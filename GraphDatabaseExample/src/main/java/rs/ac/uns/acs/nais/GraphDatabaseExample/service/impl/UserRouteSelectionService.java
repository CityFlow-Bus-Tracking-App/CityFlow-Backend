package rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl;

import org.springframework.stereotype.Service;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.UserRouteSelection;
import rs.ac.uns.acs.nais.GraphDatabaseExample.repository.UserRouteSelectionRepository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.IUserRouteSelectionService;

import java.util.Optional;

@Service
public class UserRouteSelectionService implements IUserRouteSelectionService {

    private final UserRouteSelectionRepository userRouteSelectionRepository;

    public UserRouteSelectionService(UserRouteSelectionRepository userRouteSelectionRepository){
        this.userRouteSelectionRepository = userRouteSelectionRepository;
    }

    @Override
    public void createOrUpdateUserRouteSelection(String username, String routename) {
        userRouteSelectionRepository.createOrUpdateSelection(username, routename);
    }

    @Override
    public String getMostFrequentedRoute(String username) {
        return userRouteSelectionRepository.findMostFrequentedRouteByUsername(username);
    }
}

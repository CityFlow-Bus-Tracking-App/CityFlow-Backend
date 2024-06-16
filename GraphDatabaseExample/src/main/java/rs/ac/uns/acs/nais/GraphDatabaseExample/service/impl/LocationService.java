package rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Location;
import rs.ac.uns.acs.nais.GraphDatabaseExample.repository.LocationRepository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.ILocationService;

@Service
public class LocationService implements ILocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @Override
    @Transactional
    public Location save(Location location) {
        return locationRepository.save(location);
    }
}

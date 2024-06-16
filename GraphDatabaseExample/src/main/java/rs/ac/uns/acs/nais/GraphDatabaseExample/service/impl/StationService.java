package rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Station;
import rs.ac.uns.acs.nais.GraphDatabaseExample.repository.StationRepository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.IStationService;

@Service
public class StationService implements IStationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }

    @Override
    @Transactional
    public Station save(Station station) {
        return stationRepository.save(station);
    }
}

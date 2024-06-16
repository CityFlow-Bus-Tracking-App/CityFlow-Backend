package rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.Bus;
import rs.ac.uns.acs.nais.GraphDatabaseExample.repository.BusRepository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.IBusService;

@Service
public class BusService implements IBusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository){
        this.busRepository = busRepository;
    }
    @Override
    @Transactional
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }
}

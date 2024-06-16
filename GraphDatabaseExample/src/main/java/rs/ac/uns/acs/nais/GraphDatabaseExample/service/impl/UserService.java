package rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.User;
import rs.ac.uns.acs.nais.GraphDatabaseExample.repository.UserRepository;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.IUserService;

@Service
public class UserService implements IUserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}

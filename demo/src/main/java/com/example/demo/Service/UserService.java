package com.example.demo.Service;

import com.example.demo.DTO.RouteGraphDTO;
import com.example.demo.Model.User;
import com.example.demo.Model.UserInfoDetails;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        //return this.userRepository.save(user);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User FindByUsername(String username){
        return this.userRepository.getByUsername(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userDetail = userRepository.findByUsername(username);

        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User addUser(User userInfo) {
        User savedUser = userRepository.save(userInfo);
        return savedUser;
    }

    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public User getById(Integer userId){
        return userRepository.getById(userId);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRoles(role);
    }
}

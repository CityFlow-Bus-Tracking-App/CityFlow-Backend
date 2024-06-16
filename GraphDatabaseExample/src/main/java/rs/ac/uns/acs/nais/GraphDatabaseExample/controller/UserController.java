package rs.ac.uns.acs.nais.GraphDatabaseExample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.nais.GraphDatabaseExample.dto.SearchDTO;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.User;
import rs.ac.uns.acs.nais.GraphDatabaseExample.model.UserRouteSelection;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.IUserRouteSelectionService;
import rs.ac.uns.acs.nais.GraphDatabaseExample.service.impl.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final IUserRouteSelectionService userRouteSelectionService;

    public UserController(UserService userService, IUserRouteSelectionService userRouteSelectionService) {
        this.userService = userService;
        this.userRouteSelectionService = userRouteSelectionService;

    }

    @PostMapping("/save")
    public User createUser(@RequestBody User user){
       return userService.save(user);
    }

    @PostMapping("/searchRoute")
    public void createUserRouteSelection(@RequestBody SearchDTO dto) {
        userRouteSelectionService.createOrUpdateUserRouteSelection(dto.getUsername(), dto.getRoutename());
    }

    @GetMapping("/mostFrequented/{username}")
    public String getMostFrequentedRoute(@PathVariable String username) {
        return userRouteSelectionService.getMostFrequentedRoute(username);
    }

}

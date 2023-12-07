package com.Diplomado.MappingApi.web.rest;

import com.Diplomado.MappingApi.domain.entities.User;
import com.Diplomado.MappingApi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUsers(@PathVariable Integer id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody final User user) throws URISyntaxException {
          if (user.getUserId() != null){
              throw new IllegalArgumentException("The new user shouldn't have Id ");
          }
          user.setCreatedTs(LocalDateTime.now());
          User userdb = userService.save(user);
          return ResponseEntity.created(new URI("/v1/users/"+userdb.getUserId())).body(userdb);
    }
}

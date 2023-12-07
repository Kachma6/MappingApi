package com.Diplomado.MappingApi.services;

import com.Diplomado.MappingApi.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUserById(Integer id);
    User save(User user);
    void delete(Integer id);

}

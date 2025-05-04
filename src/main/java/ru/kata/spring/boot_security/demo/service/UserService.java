package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    void save(User user);

    void deleteById(Long id);

    User showUserById(Long id);

    void update(Long id, User user);

    User findByEmail(String email);

    UserDetails loadUserByUsername(String username);
}

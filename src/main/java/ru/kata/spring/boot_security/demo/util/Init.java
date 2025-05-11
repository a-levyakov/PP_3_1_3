package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    @Transactional
    public void initilazedDB() {

        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleService.save(adminRole);
        roleService.save(userRole);

        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        Set<Role> allRoles = new HashSet<>();

        adminRoles.add(adminRole);
        userRoles.add(userRole);
        allRoles.add(adminRole);
        allRoles.add(userRole);

        userService.save(new User("Igor", "Igorevich", "admin", "admin", adminRoles));
        userService.save(new User("Mark", "Makrkovich", "user", "user", userRoles));
        userService.save(new User("Misha", "Mihoilovich", "test", "test", allRoles));
    }
}
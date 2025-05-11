package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void save(Role role);

    void deleteById(Long id);

    Role getRoleById(Long id);
}

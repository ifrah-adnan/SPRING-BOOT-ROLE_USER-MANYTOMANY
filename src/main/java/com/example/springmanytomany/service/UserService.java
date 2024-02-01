package com.example.springmanytomany.service;

import com.example.springmanytomany.entities.Role;
import com.example.springmanytomany.entities.User;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByRoleName(String role);
    void addRoletoUser(String username , String roleName);

    User authenticate(String userName,String password);
}

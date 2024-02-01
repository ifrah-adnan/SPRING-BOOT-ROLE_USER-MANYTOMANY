package com.example.springmanytomany.service;

import com.example.springmanytomany.entities.Role;
import com.example.springmanytomany.entities.User;
import com.example.springmanytomany.repository.RoleRepository;
import com.example.springmanytomany.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

  private RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());

         return userRepository.save(user);

    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);

    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String role) {
        return roleRepository.findRoleByRoleName(role);
    }

    @Override
    public void addRoletoUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = findRoleByRoleName(roleName);
        if (user!= null) {
            user.getRoles().add(role);
            role.getUserList().add(user);
        }
    }

    @Override
    public User authenticate(String userName, String password) {
        User user =userRepository.findUserByUsername(userName);
        if (user==null)throw new RuntimeException("bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");

    }
}

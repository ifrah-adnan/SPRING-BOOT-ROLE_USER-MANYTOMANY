package com.example.springmanytomany.repository;

import com.example.springmanytomany.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
 Role findRoleByRoleName(String roleName);
}

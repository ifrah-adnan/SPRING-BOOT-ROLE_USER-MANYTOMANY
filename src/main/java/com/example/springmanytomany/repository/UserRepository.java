package com.example.springmanytomany.repository;

import com.example.springmanytomany.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Repository
public interface UserRepository extends JpaRepository<User,String> {
   User findUserByUsername(String userName);

}

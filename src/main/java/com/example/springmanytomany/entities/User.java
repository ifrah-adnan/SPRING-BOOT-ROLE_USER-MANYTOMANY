package com.example.springmanytomany.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Entity
@Table(name="USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column( name ="USER_NAME",unique = true ,length = 20)
    private String username;
    private String password;
    @ManyToMany(mappedBy = "userList",fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();
}

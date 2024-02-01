package com.example.springmanytomany;

import com.example.springmanytomany.entities.Role;
import com.example.springmanytomany.entities.User;
import com.example.springmanytomany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringManyToManyApplication.class, args);
    }
@Bean
    CommandLineRunner start (UserService userService){
        return args -> {
            User u=new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);
            User u2=new User();
            u2.setUsername("admin");
            u2.setPassword("33333");
            userService.addNewUser(u2);

            Stream.of("Student","user","admin").forEach(r->{
                Role role=new Role();
                role.setRoleName(r);
                userService.addNewRole(role);
            });
userService.addRoletoUser("user1","Student");
userService.addRoletoUser("user1","user");
userService.addRoletoUser("admin","admin");

try {
    User user= userService.authenticate("user1","123456");
    System.out.println(user.getUserId());
    System.out.println(user.getUsername());
    user.getRoles().forEach(r->{
        System.out.println("Role"+r.toString());
    });

}
catch (Exception exception){
    exception.printStackTrace();
}

        };
    }
}

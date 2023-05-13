package com.khoa.examportal;

import com.khoa.examportal.Service.UserService;
import com.khoa.examportal.model.Role;
import com.khoa.examportal.model.User;
import com.khoa.examportal.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ExamPortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("starting.");
        User user = new User();
        user.setFirstname("fisrtname");
        user.setLastname("lastname");
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email@gmail.com");
        user.setProfile("profile.png");

        Role role1 = new Role();
        role1.setRoleName("Admin");

        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(role1);
        userRole.setUser(user);

        userRoles.add(userRole);

        User user1 = this.userService.createUser(user, userRoles);
        System.out.println(user1.getUsername());
    }
}

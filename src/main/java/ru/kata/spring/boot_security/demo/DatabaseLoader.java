package ru.kata.spring.boot_security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final UserService userService;

    public DatabaseLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {

        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        userService.createRole(adminRole);
        userService.createRole(userRole);

        User admin = new User("admin", "admin", "admin");
        admin.addRole(adminRole);
        admin.addRole(userRole);

        User user = new User("user", "user", "user");
        user.addRole(userRole);


        userService.createUser(admin);
        userService.createUser(user);


    }
}
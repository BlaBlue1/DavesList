package com.example.daveslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String...args) {
        User user = new User("user", "user@domain.com", "user", "User", "User", true);
        Role userRole = new Role("user", "ROLE_USER");

        userRepository.save(user);
        roleRepository.save(userRole);

        User admin = new User("DaveWolf","dave@wolf.com", "beastmaster","Dave", "Wolf", true );
        Role adminRole1 = new Role("DaveWolf", "ROLE_ADMIN");
        Role adminRole2 = new Role("DaveWolf", "ROLE_USER");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);



    }
}

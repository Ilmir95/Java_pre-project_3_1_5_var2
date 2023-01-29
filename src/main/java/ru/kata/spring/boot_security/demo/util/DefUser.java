package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DefUser {

    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public DefUser(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @PostConstruct
    private void postConstruct() {
        Role userRole = new Role(1, "ROLE_USER");
        Role adminRole = new Role(2, "ROLE_ADMIN");
        roleRepository.saveAll(List.of(userRole, adminRole));

        User adminUser = new User();
        adminUser.setUsername("Mentor");
        adminUser.setSurname("Admin");
        adminUser.setAge(30);
        adminUser.setEmail("mentor@mail.ru");
        adminUser.setPassword("123456");
        adminUser.addRole(adminRole);

        User user = new User();
        user.setUsername("Ilmir");
        user.setSurname("Khafizov");
        user.setAge(27);
        user.setEmail("ilmir@mail.ru");
        user.setPassword("123456");
        user.addRole(userRole);

        userService.addUser(adminUser);
        userService.addUser(user);
    }
}

package de.mjis.springhibernateenvers.adapter.in.web;

import de.mjis.springhibernateenvers.adapter.out.persistence.UserJpaEntity;
import de.mjis.springhibernateenvers.adapter.out.persistence.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/greeting")
    public String greeting() {
        UserJpaEntity user = new UserJpaEntity();
        user.setId(1L);
        user.setName("John");
        userRepository.save(user);
        return "Hello World";
    }
}

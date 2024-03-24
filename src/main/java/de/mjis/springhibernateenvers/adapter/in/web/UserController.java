package de.mjis.springhibernateenvers.adapter.in.web;

import de.mjis.springhibernateenvers.adapter.out.persistence.UserJpaEntity;
import de.mjis.springhibernateenvers.adapter.out.persistence.UserRepository;
import de.mjis.springhibernateenvers.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/insert")
    public User insert() {
        UserJpaEntity inputEntity = new UserJpaEntity();
        inputEntity.setName("Mathias");
        UserJpaEntity savedEntity = userRepository.save(inputEntity);

        User returnUser = new User();
        returnUser.setId(savedEntity.getId());
        returnUser.setName(savedEntity.getName());
        return returnUser;
    }

    @GetMapping("/update")
    public User update() {
        UserJpaEntity updateEntity = userRepository.getById("1");
        updateEntity.setName("Matthias");
        UserJpaEntity savedEntity = userRepository.save(updateEntity);

        User returnUser = new User();
        returnUser.setId(savedEntity.getId());
        returnUser.setName(savedEntity.getName());
        return returnUser;
    }

    @GetMapping("/older")
    public User older() {
        UserJpaEntity olderEntity = userRepository.previousRevision(1L);

        User returnUser = new User();
        returnUser.setId(olderEntity.getId());
        returnUser.setName(olderEntity.getName());
        return returnUser;
    }
}

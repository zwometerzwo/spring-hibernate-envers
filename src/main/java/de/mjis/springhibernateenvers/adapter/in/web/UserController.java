package de.mjis.springhibernateenvers.adapter.in.web;

import de.mjis.springhibernateenvers.adapter.out.persistence.RevisionedUserJpaEntity;
import de.mjis.springhibernateenvers.adapter.out.persistence.UserJpaEntity;
import de.mjis.springhibernateenvers.adapter.out.persistence.UserRepository;
import de.mjis.springhibernateenvers.domain.RevisionedUser;
import de.mjis.springhibernateenvers.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UserController {

    private final UserRepository userRepository;

    private final AtomicInteger counter = new AtomicInteger(0);

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/insert")
    public User insert() {
        UserJpaEntity inputEntity = new UserJpaEntity();
        inputEntity.setName("Matthias");
        UserJpaEntity savedEntity = userRepository.save(inputEntity);

        User returnUser = new User();
        returnUser.setId(savedEntity.getId());
        returnUser.setName(savedEntity.getName());
        return returnUser;
    }

    @GetMapping("/get")
    public User get() {
        UserJpaEntity getEntity = userRepository.getById("1");

        User returnUser = new User();
        returnUser.setId(getEntity.getId());
        returnUser.setName(getEntity.getName());
        return returnUser;
    }

    @GetMapping("/update")
    public User update() {
        UserJpaEntity updateEntity = userRepository.getById("1");
        updateEntity.setName("Matthias" + counter.getAndIncrement());
        UserJpaEntity savedEntity = userRepository.save(updateEntity);

        User returnUser = new User();
        returnUser.setId(savedEntity.getId());
        returnUser.setName(savedEntity.getName());
        return returnUser;
    }

    @GetMapping("/revisions")
    public List<RevisionedUser> revisions() {
        List<RevisionedUser> revisionedUserList = new ArrayList<>();

        List<RevisionedUserJpaEntity> revisionedEntities = userRepository.getRevisionsById(1L);

        revisionedEntities.stream().forEach(revisionEntity -> {
            User user = new User();
            user.setId(revisionEntity.getUserJpaEntity().getId());
            user.setName(revisionEntity.getUserJpaEntity().getName());
            RevisionedUser revisionedUser = new RevisionedUser(user, revisionEntity.getRevision(), revisionEntity.getTimestamp());
            revisionedUserList.add(revisionedUser);
        });

        return revisionedUserList;
    }

    @GetMapping("/oldrevision/{revision}")
    public User oldrevision(@PathVariable Long revision) {
        UserJpaEntity oldUserJpaEntity = userRepository.getUserByIdAndRevision(1L, revision);

        UserJpaEntity updateEntity = userRepository.getById("1");
        updateEntity.setName(oldUserJpaEntity.getName());
        UserJpaEntity savedEntity = userRepository.save(updateEntity);

        User returnUser = new User();
        returnUser.setId(savedEntity.getId());
        returnUser.setName(savedEntity.getName());
        return returnUser;
    }

    @GetMapping("/oldtimestamp/{timestamp}")
    public User oldtimestamp(@PathVariable Long timestamp) {
        UserJpaEntity oldUserJpaEntity = userRepository.getUserByIdAndTimestamp(1L, timestamp);

        UserJpaEntity updateEntity = userRepository.getById("1");
        updateEntity.setName(oldUserJpaEntity.getName());
        UserJpaEntity savedEntity = userRepository.save(updateEntity);

        User returnUser = new User();
        returnUser.setId(savedEntity.getId());
        returnUser.setName(savedEntity.getName());
        return returnUser;
    }
}

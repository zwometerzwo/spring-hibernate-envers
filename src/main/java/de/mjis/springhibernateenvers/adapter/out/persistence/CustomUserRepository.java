package de.mjis.springhibernateenvers.adapter.out.persistence;

import java.util.List;

public interface CustomUserRepository {
    List<RevisionedUserJpaEntity> getRevisionsById(Long id);
    UserJpaEntity getUserByIdAndRevision(Long id, Number revision);
    UserJpaEntity getUserByIdAndTimestamp(Long id, Long timestamp);
}

package de.mjis.springhibernateenvers.adapter.out.persistence;

public interface CustomUserRepository {
    UserJpaEntity previousRevision(Long id);
}

package de.mjis.springhibernateenvers.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpaEntity, String>, CustomUserRepository {
}

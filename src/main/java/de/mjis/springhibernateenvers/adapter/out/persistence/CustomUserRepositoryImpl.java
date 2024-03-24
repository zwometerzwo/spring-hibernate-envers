package de.mjis.springhibernateenvers.adapter.out.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserJpaEntity previousRevision(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        List<Number> revisions = auditReader.getRevisions(UserJpaEntity.class, 1L);

        UserJpaEntity auditedUser = (UserJpaEntity) AuditReaderFactory
                .get(entityManager)
                .createQuery()
                .forEntitiesAtRevision(UserJpaEntity.class, revisions.size() - 1)
                .getSingleResult();

        return auditedUser;
    }
}

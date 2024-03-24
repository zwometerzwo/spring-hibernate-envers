package de.mjis.springhibernateenvers.adapter.out.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RevisionedUserJpaEntity> getRevisionsById(Long id) {
        List<RevisionedUserJpaEntity> revisionedUserJpaEntityList = new ArrayList<>();

        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        List<Number> revisions = auditReader.getRevisions(UserJpaEntity.class, id);

        revisions.stream().forEach(revision -> {
            UserJpaEntity userJpaEntity = (UserJpaEntity) AuditReaderFactory
                    .get(entityManager)
                    .createQuery()
                    .forEntitiesAtRevision(UserJpaEntity.class, revision)
                    .getSingleResult();
            RevisionedUserJpaEntity revisionedUserJpaEntity = new RevisionedUserJpaEntity(userJpaEntity, revision);
            revisionedUserJpaEntityList.add(revisionedUserJpaEntity);
        });

        return revisionedUserJpaEntityList;
    }

    @Override
    public UserJpaEntity getUserByIdAndRevision(Long id, Number revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        UserJpaEntity userJpaEntity = auditReader.find(UserJpaEntity.class, id, revision);

        return userJpaEntity;
    }

    @Override
    public UserJpaEntity getUserByIdAndTimestamp(Long id, Long timestamp) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        Instant instant = Instant.ofEpochSecond(timestamp);
        Number revision = auditReader.getRevisionNumberForDate(instant);
        UserJpaEntity userJpaEntity = auditReader.find(UserJpaEntity.class, id, revision);

        return userJpaEntity;
    }
}

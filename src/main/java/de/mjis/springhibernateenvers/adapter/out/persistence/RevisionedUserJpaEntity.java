package de.mjis.springhibernateenvers.adapter.out.persistence;

public class RevisionedUserJpaEntity {
    private UserJpaEntity userJpaEntity;

    private Number revision;

    public RevisionedUserJpaEntity(UserJpaEntity userJpaEntity, Number revision) {
        this.userJpaEntity = userJpaEntity;
        this.revision = revision;
    }

    public UserJpaEntity getUserJpaEntity() {
        return userJpaEntity;
    }

    public Number getRevision() {
        return revision;
    }
}

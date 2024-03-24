package de.mjis.springhibernateenvers.adapter.out.persistence;

public class RevisionedUserJpaEntity {
    private UserJpaEntity userJpaEntity;

    private Number revision;

    private Long timestamp;

    public RevisionedUserJpaEntity(UserJpaEntity userJpaEntity, Number revision, Long timestamp) {
        this.userJpaEntity = userJpaEntity;
        this.revision = revision;
        this.timestamp = timestamp;
    }

    public UserJpaEntity getUserJpaEntity() {
        return userJpaEntity;
    }

    public Number getRevision() {
        return revision;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}

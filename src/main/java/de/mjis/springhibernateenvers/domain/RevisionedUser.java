package de.mjis.springhibernateenvers.domain;

public class RevisionedUser {
    private User user;

    private Number revision;

    private Long timestamp;

    public RevisionedUser(User user, Number revision, Long timestamp) {
        this.user = user;
        this.revision = revision;
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public Number getRevision() {
        return revision;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}

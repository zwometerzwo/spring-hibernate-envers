package de.mjis.springhibernateenvers.domain;

public class RevisionedUser {
    private User user;

    private Number revision;

    public RevisionedUser(User user, Number revision) {
        this.user = user;
        this.revision = revision;
    }

    public User getUser() {
        return user;
    }

    public Number getRevision() {
        return revision;
    }
}

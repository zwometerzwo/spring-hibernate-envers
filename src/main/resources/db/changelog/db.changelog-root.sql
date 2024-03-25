--liquibase formatted sql

--changeset zwometerzwo:1
CREATE TABLE REVINFO (
    REV int auto_increment primary key,
    REVTSTMP bigint
);

CREATE TABLE users (
    id bigint auto_increment primary key,
    name varchar(255)
);

CREATE TABLE users_AUD (
    id bigint NOT NULL,
    REV int NOT NULL,
    REVTYPE tinyint,
    name varchar(255),
    CONSTRAINT users_aud_pkey PRIMARY KEY (id, REV),
    CONSTRAINT users_aud_revinfo FOREIGN KEY (REV)
    REFERENCES REVINFO (REV)
    ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE tags (
    id bigint auto_increment primary key,
    name varchar(255),
    tstmp bigint
);

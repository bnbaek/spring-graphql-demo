CREATE TABLE author
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE post
(
    id        BIGINT NOT NULL,
    title     VARCHAR(255),
    "TEXT"    VARCHAR(255),
    category  VARCHAR(255),
    author_id BIGINT NOT NULL,
    CONSTRAINT pk_post PRIMARY KEY (id)
);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);
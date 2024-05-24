--liquibase formatted sql


CREATE TABLE IF NOT EXISTS list
(
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    list_name VARCHAR(40) UNIQUE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS event
(
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    event_name VARCHAR(60) NOT NULL,
    list_id BIGINT REFERENCES list(id),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    PRIMARY KEY (id)
);
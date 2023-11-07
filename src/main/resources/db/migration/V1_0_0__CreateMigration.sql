CREATE SEQUENCE public.resource_sq INCREMENT 50 START WITH 1 MINVALUE 1;

CREATE TYPE number AS ENUM (
    'ONE',
    'TWO',
    'THREE'
    );

CREATE TABLE example_table
(
    id     BIGINT,
    number number NOT NULL,
    PRIMARY KEY (id)
);


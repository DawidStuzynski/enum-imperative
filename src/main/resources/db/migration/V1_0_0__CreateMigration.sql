CREATE SEQUENCE public.resource_sq INCREMENT 50 START WITH 1 MINVALUE 1;

CREATE TYPE number AS ENUM (
    'ONE',
    'TWO',
    'THREE'
    );

CREATE TABLE example_table
(
    id            BIGINT,
--     numbers       text[],
    PRIMARY KEY (id)
);

-- INSERT INTO example_table (id, numbers, single_number, greeting)
-- VALUES (1, ARRAY['ONE', 'TWO'], 'THREE', 'Greeting');

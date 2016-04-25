DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_sequence START 1000000;

CREATE TABLE users
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
  name              VARCHAR NOT NULL,
  password          VARCHAR NOT NULL,
  email             VARCHAR NOT NULL,
  max_hours_per_day INTEGER DEFAULT 8 NOT NULL,
  registered TIMESTAMP DEFAULT now()
);

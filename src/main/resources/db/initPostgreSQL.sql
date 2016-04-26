/*init global_sequence*/
DROP SEQUENCE IF EXISTS global_sequence CASCADE;
CREATE SEQUENCE global_sequence START 1000000;

/*init users table*/
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
  name              VARCHAR NOT NULL,
  password          VARCHAR NOT NULL,
  email             VARCHAR NOT NULL,
  max_hours_per_day INTEGER DEFAULT 8 NOT NULL,
  registered_date   TIMESTAMP DEFAULT now()
);

/*init notations table*/
DROP TABLE if EXISTS notations;
CREATE TABLE notations(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
  name        VARCHAR NOT NULL,
  url         VARCHAR NOT NULL,
  description TEXT,
  hours       INTEGER DEFAULT 2,
  date_time   TIMESTAMP DEFAULT now()
);
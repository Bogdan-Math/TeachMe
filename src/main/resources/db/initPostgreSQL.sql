/*init global_sequence*/
DROP SEQUENCE IF EXISTS global_sequence CASCADE;
CREATE SEQUENCE global_sequence START 1000000;

/*init users table*/
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
  id                         INTEGER DEFAULT nextval('global_sequence'),
  name                       VARCHAR NOT NULL,
  password                   VARCHAR NOT NULL,
  email                      VARCHAR NOT NULL UNIQUE,
  max_hours_per_day          INTEGER DEFAULT 8 NOT NULL,
  registered_date_and_time   TIMESTAMP DEFAULT now(),

  PRIMARY KEY (id)
);

/*init notations table*/
DROP TABLE if EXISTS notations;
CREATE TABLE notations(
  id                      INTEGER DEFAULT nextval('global_sequence'),
  name                    VARCHAR NOT NULL,
  url                     VARCHAR NOT NULL,
  description             TEXT NOT NULL,
  hours                   INTEGER DEFAULT 2,
  created_date_and_time   TIMESTAMP DEFAULT now(),
  user_id                 INTEGER /*NOT NULL*/,

  PRIMARY KEY (id),
  FOREIGN KEY (user_id)   REFERENCES users(id) ON DELETE CASCADE
);
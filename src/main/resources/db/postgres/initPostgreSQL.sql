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
  max_hours_per_day          INTEGER DEFAULT 8,
  registered_date_and_time   TIMESTAMP DEFAULT now(),

  PRIMARY KEY (id)
);

/*init main_goals table*/
DROP TABLE IF EXISTS main_goals CASCADE;
CREATE TABLE main_goals
(
  id                         INTEGER DEFAULT nextval('global_sequence'),
  user_id                    INTEGER /*NOT NULL*/,
  UNIQUE (user_id),

  name                       VARCHAR NOT NULL,
  description                VARCHAR NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (user_id)   REFERENCES users(id) ON DELETE CASCADE
);

/*init notations table*/
DROP TABLE if EXISTS notations CASCADE;
CREATE TABLE notations(
  id                      INTEGER DEFAULT nextval('global_sequence'),
  user_id                 INTEGER /*NOT NULL*/,

  name                    VARCHAR NOT NULL,
  url                     VARCHAR NOT NULL,
  description             TEXT NOT NULL,
  hours                   INTEGER DEFAULT 2,
  created_date_and_time   TIMESTAMP DEFAULT now(),

  PRIMARY KEY (id),
  FOREIGN KEY (user_id)   REFERENCES users(id) ON DELETE CASCADE
);

/*init user_roles table*/
DROP TABLE if EXISTS user_roles CASCADE;
CREATE TABLE user_roles(
  user_id                 INTEGER NOT NULL,

  role                    VARCHAR,

  FOREIGN KEY (user_id)   REFERENCES users(id) ON DELETE CASCADE
);

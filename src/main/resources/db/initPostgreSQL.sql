DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_sequence;

CREATE SEQUENCE global_sequence START 1000000;

CREATE TABLE users
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
  name              VARCHAR NOT NULL,
  password          VARCHAR NOT NULL,
  email             VARCHAR NOT NULL,
  max_hours_per_day INTEGER DEFAULT 8 NOT NULL,
  registered_date TIMESTAMP DEFAULT now()
);

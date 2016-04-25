DELETE FROM users;
ALTER SEQUENCE global_sequence RESTART WITH 1000000;

INSERT INTO users (name, password, email)
VALUES ('Anonymous', 'password', 'anonymous@gmail.com');

INSERT INTO users (name, password, email)
VALUES ('User', 'password', 'user@gmail.com');

INSERT INTO users (name, password, email)
VALUES ('Admin', 'password', 'admin@gmail.com');
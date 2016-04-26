/*restart global_sequence*/
ALTER SEQUENCE global_sequence RESTART WITH 1000000;

/*populate users table*/
DELETE FROM users;

INSERT INTO users (name, password, email)
VALUES ('Anonymous', 'password', 'anonymous@gmail.com');

INSERT INTO users (name, password, email)
VALUES ('User', 'password', 'user@gmail.com');

INSERT INTO users (name, password, email)
VALUES ('Admin', 'password', 'admin@gmail.com');

/*populate notations table*/
DELETE FROM notations;

INSERT INTO notations (name, url, description, hours)
VALUES ('notations1', 'url1', 'desc1', 1);

INSERT INTO notations (name, url, description, hours)
VALUES ('notations2', 'url2', 'desc2', 2);

INSERT INTO notations (name, url, description, hours)
VALUES ('notations3', 'url3', 'desc3', 3);
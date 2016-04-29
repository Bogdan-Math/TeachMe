/*restart global_sequence*/
ALTER SEQUENCE global_sequence RESTART WITH 1000001;

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

INSERT INTO notations (user_id, name, url, description, hours)
VALUES (1000001, 'notations1', 'url1', 'desc1', 1),
       (1000001, 'notations2', 'url2', 'desc2', 2);

INSERT INTO notations (user_id, name, url, description, hours)
VALUES (1000002, 'notations3', 'url3', 'desc3', 3),
       (1000002, 'notations4', 'url4', 'desc4', 4);

INSERT INTO notations (user_id, name, url, description, hours)
VALUES (1000003, 'notations5', 'url5', 'desc5', 5),
       (1000003, 'notations6', 'url6', 'desc6', 6);
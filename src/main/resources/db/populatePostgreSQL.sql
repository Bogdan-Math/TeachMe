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

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000001, 'notations1', 'url1', 'desc1', 1, '2016-05-01 21:26:01'),
       (1000001, 'notations2', 'url2', 'desc2', 2, '2016-05-01 21:26:01');

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000002, 'notations3', 'url3', 'desc3', 3, '2016-05-02 21:26:02'),
       (1000002, 'notations4', 'url4', 'desc4', 4, '2016-05-02 21:26:02');

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000003, 'notations5', 'url5', 'desc5', 5, '2016-05-03 21:26:03'),
       (1000003, 'notations6', 'url6', 'desc6', 6, '2016-05-03 21:26:03');
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

/*populate main_goals table*/
DELETE FROM main_goals;

INSERT INTO main_goals (user_id, description) VALUES (1000001, 'main goal 1');
INSERT INTO main_goals (user_id, description) VALUES (1000002, 'main goal 2');
INSERT INTO main_goals (user_id, description) VALUES (1000003, 'main goal 3');

/*populate notations table*/
DELETE FROM notations;

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000001, 'notations1', 'http://url1.com', 'desc1', 1, '2016-05-01 21:26:01'),
       (1000001, 'notations2', 'http://url2.com', 'desc2', 2, '2016-05-01 21:26:01');

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000002, 'notations3', 'http://url3.com', 'desc3', 3, '2016-05-02 21:26:02'),
       (1000002, 'notations4', 'http://url4.com', 'desc4', 4, '2016-05-02 21:26:02');

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000003, 'notations5', 'http://url5.com', 'desc5', 5, '2016-05-03 21:26:03'),
       (1000003, 'notations6', 'http://url6.com', 'desc6', 6, '2016-05-03 21:26:03');
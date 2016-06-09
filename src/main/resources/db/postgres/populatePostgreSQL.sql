/*restart global_sequence*/
ALTER SEQUENCE global_sequence RESTART WITH 1000001;

/*populate users table*/
DELETE FROM users;

INSERT INTO users (name, password, email)
VALUES ('Anonymous',
        '$2a$10$3jLX.UFBjDeM.EIeakGEPehCGRu4QFkEJsrQ/Q12OZanVwJoh42La',
        'anonymous@gmail.com');

INSERT INTO users (name, password, email)
VALUES ('User',
        '$2a$10$EY4z5/ic8toAeTU1QLC3BOVTji03BzOBkX1TwtrG6vyQhVXtPZJJC',
        'user@gmail.com');

INSERT INTO users (name, password, email)
VALUES ('Admin',
        '$2a$10$Aw.6sykTXJor4LrGzqL2d.uCeQSvOi7jzugCg8wU9l1VoHqWo9P6S',
        'admin@gmail.com');

/*populate main_goals table*/
DELETE FROM main_goals;

INSERT INTO main_goals (user_id, name, description) VALUES (1000001, 'm1', 'main goal 1');
INSERT INTO main_goals (user_id, name, description) VALUES (1000002, 'm2', 'main goal 2');
INSERT INTO main_goals (user_id, name, description) VALUES (1000003, 'm3', 'main goal 3');

/*populate notations table*/
DELETE FROM notations;

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000001, 'notation1', 'http://url1.com', 'desc1', 1, '2016-05-01 21:26:01'),
       (1000001, 'notation2', 'http://url2.com', 'desc2', 2, '2016-05-01 21:26:01');

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000002, 'notation3', 'http://url3.com', 'desc3', 3, '2016-05-02 21:26:02'),
       (1000002, 'notation4', 'http://url4.com', 'desc4', 4, '2016-05-02 21:26:02');

INSERT INTO notations (user_id, name, url, description, hours, created_date_and_time)
VALUES (1000003, 'notation5', 'http://url5.com', 'desc5', 5, '2016-05-03 21:26:03'),
       (1000003, 'notation6', 'http://url6.com', 'desc6', 6, '2016-05-03 21:26:03');

/*populate user_roles table*/
DELETE FROM user_roles;

INSERT INTO user_roles (user_id, role) VALUES (1000001, 'COMMON');

INSERT INTO user_roles (user_id, role) VALUES (1000002, 'COMMON');
INSERT INTO user_roles (user_id, role) VALUES (1000002, 'EXPANDED');

INSERT INTO user_roles (user_id, role) VALUES (1000003, 'COMMON');
INSERT INTO user_roles (user_id, role) VALUES (1000003, 'EXPANDED');
INSERT INTO user_roles (user_id, role) VALUES (1000003, 'ADMIN');


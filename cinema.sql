DROP DATABASE cinema;

CREATE DATABASE cinema;
USE cinema;

DROP TABLE User;
DROP TABLE Role;
DROP TABLE Movie;
DROP TABLE Session;
DROP TABLE Ticket;

CREATE TABLE User (
                      user_id BIGINT NOT NULL AUTO_INCREMENT,
                      login VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      PRIMARY KEY (user_id)
);

CREATE TABLE Role (
                      role_id BIGINT NOT NULL,
                      role_name VARCHAR (50) DEFAULT NULL,
                      PRIMARY KEY (role_id),
                      FOREIGN KEY (role_id) REFERENCES User(user_id)
);

CREATE TABLE Movie (
                       movie_id BIGINT NOT NULL AUTO_INCREMENT,
                       title VARCHAR(50) NOT NULL,
                       description VARCHAR (300) NOT NULL,
                       PRIMARY KEY (movie_id)
);

CREATE TABLE Session (
                         session_id BIGINT NOT NULL AUTO_INCREMENT,
                         movie_id BIGINT NOT NULL,
                         session_date DATETIME NOT NULL,
                         PRIMARY KEY (session_id),
                         FOREIGN KEY (movie_id) REFERENCES Movie(movie_id)
);

CREATE TABLE Ticket (
                        ticket_id BIGINT NOT NULL AUTO_INCREMENT,
                        user_id BIGINT,
                        session_id BIGINT (50),
                        price DOUBLE,
                        PRIMARY KEY (ticket_id),
                        FOREIGN KEY (user_id) REFERENCES User(user_id),
                        FOREIGN KEY (session_id) REFERENCES Session(session_id)
);

CREATE TABLE User_role (
                           user_id BIGINT,
                           role_id BIGINT,
                           FOREIGN KEY (role_id) REFERENCES Role(role_id),
                           FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE movie_session (
                               movie_id BIGINT,
                               session_id BIGINT,
                               FOREIGN KEY (movie_id) REFERENCES Movie(movie_id),
                               FOREIGN KEY (session_id) REFERENCES Session(session_id)
);

CREATE TABLE user_tickets (
                              user_id BIGINT,
                              ticket_id BIGINT,
                              FOREIGN KEY (user_id) REFERENCES User(user_id),
                              FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id)
);

INSERT INTO User
(login, password)
VALUES
    ('head', '111'),
    ('moder', '222'),
    ('user1', '444');

INSERT INTO Role
(role_id, role_name)
VALUES
    (1, 'admin'),
    (2, 'moderator'),
    (3, 'user');

SET FOREIGN_KEY_CHECKS=0;

INSERT INTO User_role
(user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO Movie
(title, description)
VALUES
    ('Duna', 'fantasy'),
    ('Matrix', 'fantasy');

INSERT INTO Session
(movie_id, session_date)
VALUES
    (2, '2021-10-26 16:00:00'),
    (1, '2021-10-27 10:00:00'),
    (1, '2021-10-27 13:00:00'),
    (2, '2021-10-27 16:00:00'),
    (1, '2021-10-28 10:00:00');

SELECT *
FROM User;

SELECT *
FROM Role;

SELECT *
FROM Movie;

SELECT *
FROM Session;

SELECT *
FROM Ticket;

SELECT *
FROM User_role;

SELECT *
FROM User
         JOIN Role
              ON Role.role_id = User.User_id;
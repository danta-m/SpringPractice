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
na VARCHAR(50) NOT NULL, 
password VARCHAR(50) NOT NULL,
role VARCHAR(50) NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE Role (
role_id BIGINT NOT NULL,
role_name ENUM('admin', 'moderator', 'user') DEFAULT NULL,
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
movie VARCHAR(50) DEFAULT NULL,
session_date DATETIME NOT NULL,
PRIMARY KEY (session_id),
FOREIGN KEY (session_id) REFERENCES Movie(movie_id)
);

CREATE TABLE Ticket (
ticket_id BIGINT NOT NULL AUTO_INCREMENT,
user_id BIGINT,
session_id BIGINT (50),
PRIMARY KEY (ticket_id),
FOREIGN KEY (user_id) REFERENCES User(user_id), 
FOREIGN KEY (session_id) REFERENCES Session(session_id)
);

INSERT INTO User
(login, password, role)
VALUES
('head', '111', 'admin'),
('moder', '222', 'moderator'),
('moder2', '333', 'moderator'),
('user1', '444', 'user'),
('user2', '555', 'user'),
('user3', '666', 'user'),
('user4', '777', 'user'),
('user5', '888', 'user');

INSERT INTO Role
(role_id, role_name)
VALUES
(1, 'admin'),
(2, 'moderator'),
(3, 'user');

INSERT INTO Movie
(title, description)
VALUES
('The fantastic pet', 'Fantasy'),
('No time to Die', 'Action'),
('Dune', 'Adventure'),
('Bhramam', 'Crime'),
('Malignant', 'Horror');

INSERT INTO Session
(movie, session_date)
VALUES
(1, '2021-12-01 11:00:00'),
(2, '2021-12-01 13:30:00'),
(3, '2021-12-01 17:00:00'),
(4, '2021-12-01 19:00:00'),
(5, '2021-12-01 21:00:00');

INSERT INTO Ticket
(user_id, session_id)
VALUES
(4, 1),
(5, 2),
(6, 1),
(7, 2),
(8, 3);

SELECT *
FROM Ticket;


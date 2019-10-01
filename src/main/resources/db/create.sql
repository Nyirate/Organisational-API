SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 employees INTEGER,
 description VARCHAR,
);

CREATE TABLE IF NOT EXISTS users (
 user_id int PRIMARY KEY auto_increment,
 department_id INTEGER,
 positions VARCHAR,
 role VARCHAR,

);

CREATE TABLE IF NOT EXISTS news (
 heading VARCHAR,
 content VARCHAR,
 author VARCHAR,
);
--CREATE TABLE IF NOT EXISTS departments_users (
-- id int PRIMARY KEY auto_increment,
-- department_id INTEGER,
-- user_id INTEGER
--);
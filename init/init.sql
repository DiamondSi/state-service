CREATE DATABASE email_notifier;
CREATE SCHEMA IF NOT EXISTS email_notifier;
CREATE TABLE IF NOT EXISTS users
(
    user_id int not null,
    email varchar (40),
    user_name varchar (256)
);
CREATE DATABASE email_notifier;
-- CREATE SCHEMA IF NOT EXISTS email_notifier;

-- GRANT USAGE ON SCHEMA email_notifier TO postgres;


-- CREATE TABLE IF NOT EXISTS email_notifier.users
CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL NOT NULL PRIMARY KEY,
    email    VARCHAR(40),
    username VARCHAR(256)
);

-- CREATE TABLE IF NOT EXISTS email_notifier.email_history
CREATE TABLE IF NOT EXISTS email_history
(
    id              SERIAL  NOT NULL PRIMARY KEY,
    recipient_email VARCHAR(40),
    subject         VARCHAR(256),
    message         VARCHAR(256),
    created_at      DATE NOT NULL DEFAULT CURRENT_DATE,
    status          VARCHAR(10),
    user_id         INT  NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
--     FOREIGN KEY (user_id) REFERENCES email_notifier.users (id)
);

-- CREATE DATABASE SpaceDev

CREATE TABLE role
(
    id_role SERIAL PRIMARY KEY,
    role_type VARCHAR(50)
);

CREATE TABLE "user"
(
    id_user SERIAL PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE category
(
    id_category SERIAL PRIMARY KEY,
    category_type VARCHAR(255)
);

CREATE TABLE journalist
(
    id_journalist SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);

CREATE TABLE article
(
    id_article SERIAL PRIMARY KEY,
    title VARCHAR(255),
    link VARCHAR(2048),
    description VARCHAR(255),
    content VARCHAR,
    date_published TIMESTAMP,
    id_journalist INT REFERENCES journalist(id_journalist)
);

CREATE TABLE article_category
(
    id_article INT REFERENCES article(id_article),
    id_category INT REFERENCES category(id_category)
);

-- ====================
-- INSERTS
-- ====================
INSERT INTO role(role_type) VALUES
('user'),
('admin');

INSERT INTO "user"(username, password) VALUES
('user', 'user'),
('admin', 'admin')

-- Journalists, articles and categories are added through admin panel in the app
CREATE TABLE IF NOT EXISTS games
(
    game_id  SERIAL NOT NULL PRIMARY KEY ,
    author_id INT,
    name  VARCHAR(256) NOT NULL ,
    creation_Date VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS authors
(
    author_id    SERIAL NOT NULL PRIMARY KEY ,
    nickname  VARCHAR(256) NOT NULL ,
    birth_Date VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS users
(
    user_id SERIAL NOT NULL PRIMARY KEY ,
    username VARCHAR(256) NOT NULL ,
    password VARCHAR(256) NOT NULL ,
    session_id VARCHAR(256) NOT NULL
);
CREATE TABLE IF NOT EXISTS roles
(
    role_id INT NOT NULL PRIMARY KEY ,
    name VARCHAR(256) NOT NULL
);
CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id),

    UNIQUE (user_id, role_id)
);
-- INSERT INTO roles VALUES (1, 'ROLE_USER');

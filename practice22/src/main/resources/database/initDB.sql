CREATE TABLE IF NOT EXISTS games
(
    game_id    SERIAL NOT NULL PRIMARY KEY ,
    author_id INTEGER,
    name  VARCHAR(256) NOT NULL ,
    creation_Date VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS authors
(
    author_id    SERIAL NOT NULL PRIMARY KEY ,
    nickname  VARCHAR(256) NOT NULL ,
    birth_Date VARCHAR(50) NOT NULL
);
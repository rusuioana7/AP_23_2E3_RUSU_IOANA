set serveroutput on;

CREATE TABLE albums (
  id INTEGER PRIMARY KEY,
  release_year INTEGER,
  title VARCHAR(200),
  artist VARCHAR(200),
  genre VARCHAR(200)
);
/
CREATE TABLE artists (
  id INTEGER PRIMARY KEY,
  name VARCHAR(200)
);
/
CREATE TABLE genres (
  id INTEGER PRIMARY KEY,
  name VARCHAR(200)
);
/
CREATE TABLE album_genres (
  album_id INTEGER,
  genre_id INTEGER,
  PRIMARY KEY (album_id, genre_id),
  FOREIGN KEY (album_id) REFERENCES albums(id),
  FOREIGN KEY (genre_id) REFERENCES genres(id)
);

DROP TABLE album_genres;
/
DROP TABLE albums;
/
DROP TABLE artists;
/
DROP TABLE genres;

CREATE TABLE episodes(
  id UUID PRIMARY KEY NOT NULL,
  happened TIMESTAMP,
  duration INT,
  severity INT
)
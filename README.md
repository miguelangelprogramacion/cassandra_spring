# cassandra_spring
Basic Spring project to manage Cassandra (http://docs.spring.io/spring-data/cassandra/docs/1.0.4.RELEASE/reference/html/cassandra.core.html)


CREATE TABLE demo.usuario (
    id uuid PRIMARY KEY,
    email text,
    nombre text
);

CREATE TABLE sample (
  userid text PRIMARY KEY,
  todo map<text, text>
);

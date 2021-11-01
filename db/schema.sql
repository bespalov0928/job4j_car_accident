create table accidentType (
  id   serial primary key,
  name varchar(200)
);

create table rule (
  id   serial primary key,
  name varchar(200)
);

create table accident (
  id      serial primary key,
  name    varchar(2000),
  text    text,
  address text,
  type    int references AccidentType (id),
  rules   integer references Rule (id)
)
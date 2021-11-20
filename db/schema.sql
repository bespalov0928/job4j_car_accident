CREATE DATABASE auto_crash;

create table accidentTypes (
  id   serial primary key,
  name varchar(200)
);

create table rules (
  id   serial primary key,
  name varchar(200)
);

create table accidents (
  id      serial primary key,
  name    varchar(2000),
  text    text,
  address text,
  type    int references AccidentType (id),
  rules   integer references Rule (id)
)

create table accident_rules (
    accident_id int references accidents,
    rule_id int references rules
)

insert into accidentTypes values (1, 'Две машины');
insert into accidentTypes values (2, 'Машина и человек');
insert into accidentTypes values (3, 'Машина и велосипед');


insert into rules values (1, 'Статья. 1');
insert into rules values (2, 'Статья. 2');
insert into rules values (3, 'Статья. 3');

insert into accidents values (1, 'Инцидент 1', 'Описание 1', 'адрес 1', 1, 1);
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

insert into accidentType values (1, 'Две машины');
insert into accidentType values (2, 'Машина и человек');
insert into accidentType values (3, 'Машина и велосипед');


insert into rule values (1, 'Статья. 1');
insert into rule values (2, 'Статья. 2');
insert into rule values (3, 'Статья. 3');
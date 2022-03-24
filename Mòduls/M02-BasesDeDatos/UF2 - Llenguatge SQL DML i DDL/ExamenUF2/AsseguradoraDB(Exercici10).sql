CREATE DATABASE asseguradora;
USE asseguradora;

CREATE TABLE vehicle (
matricula varchar(10) PRIMARY KEY,
clase VARCHAR(30),
model VARCHAR(30),
dataFabricacio date
);

create table soci (
dni varchar(9) NOT NULL PRIMARY KEY,
nom varchar(30),
cognom varchar(30),
edat smallint(2),
vehicle varchar(30),
matriculavehicle varchar(10),
foreign key (matriculavehicle) references vehicle(matricula)
);

INSERT INTO vehicle VALUES ('4635GHS', 'Mercedes', 'GLA 220', '2012/04/23');
INSERT INTO vehicle VALUES ('7365YUJ', 'Peugeot', '3008 Hybrid', '2019/07/17');

INSERT INTO soci VALUES ('47284545H', 'Albert', 'Gosa', '34', 'Mercedes GLA 220', '4635GHS');
INSERT INTO soci VALUES ('35255866Y', 'Pere', 'Miret', '43', 'Peugeot 3008 Hybrid', '7365YUJ');
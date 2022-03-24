CREATE DATABASE empresa;
USE empresa;
CREATE TABLE empleat
   (codi smallint primary key,
   nom	varchar(15),
   cognoms varchar(30),
   treball varchar(10),
   codi_carrec smallint,
   data_contracte date,
   salari int,
   comissio int,
   departament smallint
   );
  ALTER TABLE empleat MODIFY salari numeric(5,2);
INSERT INTO empleat (codi,cognoms,nom) VALUE (1, 'García', 'Ana');
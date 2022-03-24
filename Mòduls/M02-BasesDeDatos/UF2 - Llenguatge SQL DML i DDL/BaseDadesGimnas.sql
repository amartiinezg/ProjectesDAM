CREATE DATABASE gimnas;
USE gimnas;
CREATE TABLE GIMNAS
   (nom	VARCHAR(20) NOT NULL PRIMARY KEY,
   cadena VARCHAR(30),
   cpostal MEDIUMINT(5)
   );
CREATE TABLE SOCI
   (dni	VARCHAR(9) NOT NULL PRIMARY KEY,
   nom VARCHAR(25) NOT NULL,
   cognoms VARCHAR(25) NOT NULL,
   edat TINYINT(2) NOT NULL,
   datanaixement DATE,
   nom_gimnas VARCHAR(20),
   comptebancari VARCHAR(50) NOT NULL,
   FOREIGN KEY (nom_gimnas) REFERENCES gimnas(nom)
   );
CREATE TABLE TREBALLADOR
   (dni	VARCHAR(9) UNIQUE NOT NULL PRIMARY KEY,
   nom	VARCHAR(25) NOT NULL,
   cognoms VARCHAR(25) NOT NULL,
   carrec VARCHAR(20) NOT NULL,
   edat TINYINT(2) NOT NULL,
   datanaixement DATE,
   nom_gimnas VARCHAR(20),
   FOREIGN KEY (nom_gimnas) REFERENCES gimnas(nom)
   );
CREATE TABLE MATERIAL
   (idproducte MEDIUMINT(6) PRIMARY KEY,
   pes	NUMERIC(6,2),
   nom	VARCHAR(20),
   tipus VARCHAR(10),
   nom_gimnas VARCHAR(20),
   FOREIGN KEY (nom_gimnas) REFERENCES gimnas(nom)
   );
CREATE TABLE TARGETA
   (numerosoci BIGINT(15) NOT NULL PRIMARY KEY,
   dni VARCHAR(9),
   FOREIGN KEY (dni) REFERENCES soci(dni)
   );
   
ALTER TABLE TREBALLADOR MODIFY dni VARCHAR(9) UNIQUE;
INSERT INTO GIMNAS VALUES
("McFit Les Corts", "McFit", "08029"),
("McFit Lesseps", "McFit", "08024"),
("McFit Rubí", "McFit", "08191"),
("McFit Terrassa", "McFit", "08224"),
("Factory Terrassa", "Basic Factory", "08221");

INSERT INTO TREBALLADOR VALUES ("46123332M", "Alex", "Lopez Segura", "Administratiu", "32", "1989-10-04", "McFit Rubí"),
("", "Alex", "Lopez Segura", "Entrenador", "32", "1989-10-04", "McFit Rubí"),
("42125372B", "Maria", "Soler Sanz", "Entrenadora", "24", "1996-12-16", "McFit Terrassa"),
("31505972N", "Miriam", "Canigo Torregrosa", "Netejadora", "42", "1979-10-08", "McFit Lesseps"),
("61304121F", "Enric", "Aguilera Castaño", "Entrenador", "23", "1998-06-21", "McFit Les Corts"),
("21427331H", "Victor", "Herrera Mingueza", "Entrenador", "28", "1993-11-30", "Factory Terrassa")
;
INSERT INTO MATERIAL VALUES 
("836234", 632.33, "Màquina de Fons", "Màquina", "McFit Terrassa"),
("836235", 632.33, "Màquina de Fons", "Màquina", "McFit Rubí"),
("836236", 632.33, "Màquina de Fons", "Màquina", "McFit Les Corts"),
("233445", 1621.36, "Caixa", "Muntatge", "McFit Terrassa"),
("233446", 1621.36, "Caixa", "Muntatge", "McFit Lesseps"),
("233447", 1621.36, "Caixa", "Muntatge", "McFit Les Corts"),
("637236", 15.14, "Disc de 15KG", "Pes", "McFit Terrassa"),
("637237", 15.14, "Disc de 15KG", "Pes", "Factory Terrassa"),
("637238", 15.14, "Disc de 15KG", "Pes", "McFit Lesseps"),
("242336", 492.73, "Cinta de córrer", "Màquina", "Factory Terrassa"),
("126235", 132.12, "Sac de Boxa", "Muntatge", "McFit Terrassa"),
("126237", 132.12, "Sac de Boxa", "Muntatge", "Factory Terrassa")
;
INSERT INTO SOCI VALUES
("46372476H", "Albert", "Piñeira Cassalps", "45", "1976-07-10", "McFit Rubí", "ES32 5474 3445 5845 8943"),
("76484597J", "Xavier", "Abriliyo Vicents", "19", "2003-06-23", "McFit Lesseps", "ES44 9584 7362 7236 3234"),
("38326456I", "Biel", "Rusticalio Guipeado", "20", "2002-04-19", "McFit Les Corts", "ES83 8747 1239 4354 8762"),
("47323447Y", "Ana", "Rueda Gómez", 23, "1998-10-01", "McFit Terrassa", "ES34 4547 8384 7612 7234"),
("61304121F", "Enric", "Aguilera Castaño", "23", "1998-06-21", "McFit Terrassa", "ES44 4776 9324 3754 3454"),
("63523444F", "Rodri", "Galindo Ximenez", "32", "1989-02-17", "Factory Terrassa", "ES63 2344 4388 9218 3452"),
("31505972N", "Miriam", "Canigo Torregrosa", "42", "1979-10-08", "McFit Lesseps", "ES55 7432 8342 2384 7834"),
("53443324N", "Felipe", "Antonio Gonzalez", "52", "1970-01-18", "Factory Terrassa", "ES74 2639 4783 9384 6327"),
("48917263H", "Marta", "Ramiro Pujantells", "22", "2001-08-06", "McFit Terrassa", "ES32 4542 1223 4392 9283")
;
INSERT INTO TARGETA VALUES
("876457498", "46372476H"),
("845632864", "76484597J"),
("834563234", "38326456I"),
("853746235", "47323447Y"),
("856473234", "63523444F"),
("534433241", "53443324N"),
("234634238","48917263H"),
("456827853","61304121F"),
("458986956","31505972N")
;
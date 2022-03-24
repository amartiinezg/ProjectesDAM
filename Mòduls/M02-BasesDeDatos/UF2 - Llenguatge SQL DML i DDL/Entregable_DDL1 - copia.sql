CREATE DATABASE gimnas_db;
USE gimnas_db;
CREATE TABLE GIMNAS
   (nomGym	VARCHAR(20) NOT NULL PRIMARY KEY,
   cadena VARCHAR(30),
   cpostal MEDIUMINT(5)
   );
CREATE TABLE SOCI
   (dni	VARCHAR(9) NOT NULL PRIMARY KEY,
   nomSoci VARCHAR(25) NOT NULL,
   cognoms VARCHAR(25) NOT NULL,
   edat TINYINT(2) NOT NULL,
   datanaixement DATE,
   comptebancari BIGINT(50) NOT NULL
   );
CREATE TABLE ACCES
	(dni VARCHAR(9) UNIQUE NOT NULL,
	nomGym VARCHAR(20) NOT NULL,   
   nomSoci VARCHAR(20) NOT NULL,
   dataEntrada DATE,
   CONSTRAINT `acces_ibfk_2` FOREIGN KEY (dni) REFERENCES soci (dni),
   FOREIGN KEY (nomGym) REFERENCES gimnas (nomGym),
   FOREIGN KEY (nomSoci) REFERENCES soci (nomSoci),
   PRIMARY KEY (dni, nomGym)
    );
CREATE TABLE TREBALLADOR
   (dni	VARCHAR(9) UNIQUE NOT NULL PRIMARY KEY,
   nomTreballador	VARCHAR(25) NOT NULL,
   cognoms VARCHAR(25) NOT NULL,
   carrec VARCHAR(15) NOT NULL,
   edat TINYINT(2) NOT NULL,
   datanaixement DATE
   );
CREATE TABLE MATERIAL
   (idproducte INT(10) PRIMARY KEY,
   pes	NUMERIC(4,2),
   nomMaterial	VARCHAR(9),
   tipus VARCHAR(10)
   );
CREATE TABLE COMANDA
	(idproducte VARCHAR(9) UNIQUE NOT NULL,
	dni	VARCHAR(9) UNIQUE NOT NULL,
   nomTreballador	VARCHAR(25) NOT NULL,
   numeroComanda INT(10),
   dataComanda DATE,
   PRIMARY KEY (idproducte, dni),
   FOREIGN KEY (idproducte) REFERENCES material (idproducte) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (dni) REFERENCES treballador (dni) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (nomTreballador) REFERENCES treballador (nomTreballador) ON DELETE CASCADE ON UPDATE CASCADE
   );
CREATE TABLE TARGETA
   (numerosoci BIGINT(15) NOT NULL PRIMARY KEY
   );
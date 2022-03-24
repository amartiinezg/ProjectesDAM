CREATE DATABASE botiga_db;
USE botiga_db;
CREATE TABLE PRODUCTE
   (codi numeric(2,0) UNIQUE PRIMARY KEY,
   nom	SMALLINT,
   descripcio VARCHAR(20),
   categoria VARCHAR(20),
   preu numeric(2,2)
   );
CREATE TABLE FABRICANT
   (codifabricant numeric(2,0) UNIQUE PRIMARY KEY,
   nom	VARCHAR(20),
   web VARCHAR(20),
   telefon SMALLINT,
   codi numeric(2,0),
   FOREIGN KEY (codi) REFERENCES producte(codi)
   );
CREATE DATABASE IF NOT EXISTS dbuoc;
USE dbuoc;
CREATE TABLE IF NOT EXISTS dbuoc.clients 
  (codi_cli TINYINT PRIMARY KEY, 
   nom_cli VARCHAR(30) NOT NULL,
   nif CHAR(9) UNIQUE NOT NULL UNIQUE,
   adreca VARCHAR(30),
   ciutat VARCHAR(20),
   telefon CHAR(9)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS dbuoc.departaments 
  (nom_dpt VARCHAR(20),
   ciutat_dpt VARCHAR(20),
   telefon CHAR(9),
   PRIMARY KEY(nom_dpt,ciutat_dpt)
) ENGINE=InnoDB;
 
CREATE TABLE IF NOT EXISTS dbuoc.projectes 
  (codi_proj TINYINT PRIMARY KEY,
   nom_proj CHAR(20) NOT NULL UNIQUE,
   preu DECIMAL(9,2),
   data_inici DATE,
   data_prev_fi DATE,
   data_fi DATE, 
   codi_client TINYINT,
   costSous DECIMAL(9,2) DEFAULT 0.00,
   FOREIGN KEY (codi_client) REFERENCES clients(codi_cli) ON DELETE SET NULL ON UPDATE CASCADE,
   CHECK (data_inici < data_prev_fi),
   CHECK (data_inici < data_fi)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS dbuoc.empleats 
  (codi_empl TINYINT PRIMARY KEY,
   nom_empl VARCHAR(20) NOT NULL,
   cognom_empl VARCHAR(20) NOT NULL,
   sou DECIMAL(9,2) CHECK (sou>12500.00),
   nom_dpt CHAR(20),
   ciutat_dpt CHAR(20), 
   num_proj TINYINT,
   FOREIGN KEY (nom_dpt,ciutat_dpt) REFERENCES departaments(nom_dpt,ciutat_dpt) ON DELETE SET NULL ON UPDATE CASCADE,
   FOREIGN KEY (num_proj) REFERENCES projectes(codi_proj) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB;


INSERT INTO dbuoc.clients
VALUES (10, 'ECIGSA', '38567893C', 'Aragó 242 4t 1ª', 'Barcelona', '932301520');

INSERT INTO dbuoc.clients
VALUES (20, 'CME', '38123898E', 'València 22', 'Girona', '972235721');

INSERT INTO dbuoc.clients
VALUES (30, 'ACME', '36432127A', 'Mallorca 33', 'LLeida', '973234567');

INSERT INTO dbuoc.clients
VALUES (40, 'JGM', '38782345B', 'Rosselló 44', 'Tarragona', '977337143');

INSERT INTO dbuoc.departaments
VALUES ('DIR', 'Barcelona', '934226070');

INSERT INTO dbuoc.departaments
VALUES ('DIR', 'Girona', '972238970');

INSERT INTO dbuoc.departaments
VALUES ('DISS', 'Lleida', '973235040');

INSERT INTO dbuoc.departaments
VALUES ('DISS', 'Barcelona', '932248523');

INSERT INTO dbuoc.departaments
VALUES ('PROG', 'Tarragona', '977333852');

INSERT INTO dbuoc.departaments
VALUES ('PROG', 'Girona', '972235091');

INSERT INTO dbuoc.projectes
VALUES (1,'GESCOM',600000.00, '2004-1-1', '2005-1-1', NULL, 10);

INSERT INTO dbuoc.projectes
VALUES (2,'PESCI',1200000.00, '2002-1-1', '2004-5-31', '2004-5-1', 10);

INSERT INTO dbuoc.projectes
VALUES (3,'SALSA',600000.00, '2004-2-10', '2005-1-2', NULL, 20);

INSERT INTO dbuoc.projectes
VALUES (4,'TINELL',2400000.00, '2003-1-1', '2005-1-12', NULL, 20);

INSERT INTO dbuoc.empleats
VALUES (1, 'Maria', 'Puig', 60000.00, 'DIR', 'Girona', 1);

INSERT INTO dbuoc.empleats
VALUES (2, 'Pere', 'Mas', 54000.00, 'DIR', 'Barcelona', 4);

INSERT INTO dbuoc.empleats
VALUES (3, 'Anna', 'Ros', 42000.00, 'DISS', 'Lleida', 3);

INSERT INTO dbuoc.empleats
VALUES (4, 'Jordi', 'Roca', 42000.00, 'DISS', 'Barcelona', 4);

INSERT INTO dbuoc.empleats
VALUES (5, 'Clara', 'Blanc', 24000.00, 'PROG', 'Tarragona', 1);

INSERT INTO dbuoc.empleats
VALUES (6, 'Laura', 'Tort', 18000.00, 'PROG', 'Tarragona', 3);

INSERT INTO dbuoc.empleats
VALUES (7, 'Roger', 'Salt', 24000.00, NULL, NULL, 4);

INSERT INTO dbuoc.empleats
VALUES (8, 'Sergi', 'Grau', 18000.00, 'PROG', 'Tarragona', NULL);


#---------------------------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------------

/*1 A la base de dades dbuoc, crea una nova taula que emmagatzemi els noms dels projectes, i si han finalitzat o no. 
Crea un disparador per anar omplint aquesta taula.
*/
CREATE TABLE IF NOT EXISTS dbuoc.projectes_finalitzats 
  (nom_proj CHAR(20) NOT NULL UNIQUE,
   finalitzat ENUM("Sí", "No")
) ENGINE=InnoDB;

DELIMITER //
CREATE TRIGGER projectes_finalitzatsINS AFTER INSERT ON projectes FOR EACH ROW
BEGIN
	DECLARE projfin VARCHAR(15);
		SET projfin = (SELECT data_fi FROM projectes WHERE nom_proj = new.nom_proj);
    
    IF(projfin IS NULL) THEN
		INSERT projectes_finalitzats VALUES (new.nom_proj, "No");
    ELSE
		INSERT projectes_finalitzats VALUES (new.nom_proj, "Sí");
    END IF;
    
END //
CREATE TRIGGER projectes_finalitzatsUPD AFTER UPDATE ON projectes FOR EACH ROW
BEGIN
	DECLARE projfin VARCHAR(15);
		SET projfin = (SELECT data_fi FROM projectes WHERE nom_proj = new.nom_proj);
    IF(projfin IS NOT NULL) THEN
		UPDATE projectes_finalitzats SET finalitzat = "Sí" WHERE nom_proj = new.nom_proj;
	ELSE
		UPDATE projectes_finalitzats SET finalitzat = "No" WHERE nom_proj = new.nom_proj;
    END IF;
END //
DELIMITER ; 

DROP TRIGGER projectes_finalitzatsUPD;
DROP TRIGGER projectes_finalitzatsINS;
DELETE FROM projectes;
DELETE FROM projectes_finalitzats;
SELECT * FROM projectes_finalitzats;
SELECT * FROM projectes;

INSERT INTO dbuoc.projectes
VALUES (1,'GESCOM',600000.00, '2004-1-1', '2005-1-1', NULL, 10, 0);
UPDATE projectes SET data_fi = NULL WHERE codi_proj = "1";

INSERT INTO dbuoc.projectes
VALUES (2,'PESCI',1200000.00, '2002-1-1', '2004-5-31', '2004-5-1', 10, 0);

INSERT INTO dbuoc.projectes
VALUES (3,'SALSA',600000.00, '2004-2-10', '2005-1-2', NULL, 20, 0);

INSERT INTO dbuoc.projectes
VALUES (4,'TINELL',2400000.00, '2003-1-1', '2005-1-12', NULL, 20, 0);

SELECT data_fi FROM projectes WHERE nom_proj = "GESCOM";













/* 2 A la base de dades dbuoc, crea un disparador per calcular el cost (dels sous) de cada projecte. 
Crea les taules o columnes que creguis convenients.*/
ALTER TABLE projectes
ADD costSous DECIMAL(9,2) DEFAULT 0;

CREATE TABLE IF NOT EXISTS dbuoc.projectes_costSou
  (nom_proj CHAR(20) NOT NULL UNIQUE,
   cost DECIMAL(9,2) DEFAULT 0
) ENGINE=InnoDB;

DROP TRIGGER sou_projectesINS;
DROP TRIGGER sou_projectesDEL;
DROP TRIGGER sou_projectesUPD;
DELIMITER //
CREATE TRIGGER sou_projectesINS AFTER INSERT ON empleats FOR EACH ROW
BEGIN
	DECLARE sous DECIMAL (9,2);
    DECLARE mesos TINYINT;
    DECLARE projfin VARCHAR(15);
		SET sous = (SELECT SUM(sou) FROM empleats WHERE codi_empl = new.codi_empl);
        SET mesos = (TIMESTAMPDIFF(MONTH, (SELECT data_inici FROM projectes WHERE codi_proj = new.num_proj), (SELECT data_fi FROM projectes WHERE codi_proj = new.num_proj)));
        SET projfin = (SELECT data_fi FROM projectes WHERE codi_proj = new.num_proj);
	
    
	IF(projfin IS NOT NULL) THEN
    UPDATE projectes SET costSous = costSous + sous * mesos WHERE codi_proj = new.num_proj;
    END IF;
END //
CREATE TRIGGER sou_projectesDEL AFTER DELETE ON empleats FOR EACH ROW
BEGIN    
    DECLARE sous DECIMAL (9,2);
		SET sous = (SELECT SUM(sou) FROM empleats WHERE num_proj = old.num_proj);
		
    
    UPDATE projectes SET costSous = sous WHERE codi_proj = old.num_proj;
	IF ((SELECT costSous FROM projectes WHERE codi_proj = old.num_proj) IS NULL) THEN
		UPDATE projectes SET costSous = 0 WHERE codi_proj = old.num_proj;
        END IF;
END //
CREATE TRIGGER sou_projectesUPD AFTER UPDATE ON empleats FOR EACH ROW
BEGIN
    DECLARE sous DECIMAL (9,2);
		SET sous = (SELECT SUM(sou) FROM empleats WHERE num_proj = new.num_proj);
    
    UPDATE projectes SET costSous = sous WHERE codi_proj = new.num_proj;
    
IF ((SELECT costSous FROM projectes WHERE codi_proj = new.num_proj) IS NULL) THEN
		UPDATE projectes SET costSous = 0 WHERE codi_proj = new.num_proj;
        END IF;
END //
CREATE TRIGGER dbuoc4 BEFORE INSERT ON empleats FOR EACH ROW
BEGIN 
	IF ((SELECT COUNT(*) FROM empleats WHERE nom_dpt = new.nom_dpt AND ciutat_dpt = new.ciutat_dpt) = 8)
		THEN
        CALL RAISE_APPLICATION_ERROR("Departament ple");
	END IF;
    
END //
DELIMITER ;

DROP TRIGGER dbuoc4;
DELETE FROM empleats;
DELETE FROM projectes;
SELECT * FROM projectes;
SELECT * FROM empleats;



INSERT INTO dbuoc.empleats
VALUES (1, 'Maria', 'Puig', 60000.00, 'DIR', 'Girona', 1);

DELETE FROM empleats WHERE nom_empl = "Jordi";
UPDATE empleats SET sou = "54000.00" WHERE nom_empl = "Jordi";

INSERT INTO dbuoc.empleats
VALUES (2, 'Pere', 'Mas', 54000.00, 'DIR', 'Barcelona', 2);

INSERT INTO dbuoc.empleats
VALUES (3, 'Anna', 'Ros', 42000.00, 'DISS', 'Lleida', 3);

INSERT INTO dbuoc.empleats
VALUES (4, 'Jordi', 'Roca', 42000.00, 'DISS', 'Barcelona', 4);

INSERT INTO dbuoc.empleats
VALUES (5, 'Clara', 'Blanc', 24000.00, 'PROG', 'Tarragona', 2);

INSERT INTO dbuoc.empleats
VALUES (6, 'Laura', 'Tort', 18000.00, 'PROG', 'Tarragona', 2);

INSERT INTO dbuoc.empleats
VALUES (7, 'Roger', 'Salt', 24000.00, NULL, NULL, 4);

INSERT INTO dbuoc.empleats
VALUES (8, 'Sergi', 'Grau', 18000.00, 'PROG', 'Tarragona', NULL);

INSERT INTO dbuoc.empleats
VALUES (9, 'Carles', 'Anton', 20000.00, 'PROG', 'Tarragona', 3);

INSERT INTO dbuoc.empleats
VALUES (10, 'Antoni', 'Bell', 19000.00, 'PROG', 'Girona', 2);

INSERT INTO dbuoc.empleats
VALUES (11, 'Joan', 'Crispi', 25000.00, 'DISS', 'Barcelona', 4);

SELECT * FROM departaments;
SELECT COUNT(*) FROM empleats WHERE nom_dpt = "PROG";
DELETE FROM empleats;

INSERT INTO dbuoc.empleats
VALUES (12, 'Anna', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (13, 'Irina', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (14, 'Marc', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (15, 'Marcel', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (16, 'Felip', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (17, 'Kilian', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (18, 'Manel', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (19, 'Klilian', 'Bell', 19000.00, 'PROG', 'Girona', 2);
INSERT INTO dbuoc.empleats
VALUES (20, 'Cristian', 'Bell', 19000.00, 'PROG', 'Girona', 2);

DELIMITER //
CREATE TRIGGER dbuoc5 AFTER INSERT ON empleats FOR EACH ROW
BEGIN 
	IF (new.sou>=50000) THEN
    UPDATE empleats SET nom_dpt = 'DIR' WHERE codi_empl = new.codi_empl;
    ELSEIF (new.sou<50000 AND new.sou>30000) THEN
    UPDATE empleats SET nom_dpt = 'DISS' WHERE codi_empl = new.codi_empl;
    ELSEIF (new.SOU <=30000) THEN
    UPDATE empleats SET nom_dpt = 'PROG' WHERE codi_empl = new.codi_empl;
	END IF;
END //
CREATE TRIGGER dbuoc5UPD AFTER UPDATE ON empleats FOR EACH ROW
BEGIN 
IF(new.sou <> old.sou) THEN	
    IF (new.sou>=50000) THEN
    UPDATE empleats SET nom_dpt = "DIR" WHERE codi_empl = new.codi_empl;
    ELSEIF (new.sou<50000 AND new.sou>30000) THEN
    UPDATE empleats SET nom_dpt = 'DISS' WHERE codi_empl = new.codi_empl;
    ELSEIF (new.SOU <=30000) THEN
    UPDATE empleats SET nom_dpt = 'PROG' WHERE codi_empl = new.codi_empl;
	END IF;
END IF;
END //
DELIMITER ;


DROP TRIGGER dbuoc5UPD;
INSERT INTO dbuoc.empleats
VALUES (23, 'Ramon', 'Beltrán', 38000.00, 'PROG', 'Girona', 2);
SELECT * FROM empleats;
UPDATE empleats SET sou = 38000.00 WHERE codi_empl=15;
SHOW TRIGGERS;

DELIMITER //
CREATE TRIGGER dbuoc6 AFTER INSERT ON projectes FOR EACH ROW
BEGIN
    UPDATE empleats SET num_proj = new.codi_proj WHERE codi_empl = (SELECT codi_empl FROM empleats WHERE num_proj IS NULL);
END //
DELIMITER ;


SELECT * FROM clients;
SELECT * FROM empleats;
SELECT * FROM projectes;

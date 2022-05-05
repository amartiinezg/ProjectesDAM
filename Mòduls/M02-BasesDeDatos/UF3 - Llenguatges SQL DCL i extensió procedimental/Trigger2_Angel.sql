#! EXERCICI 60
CREATE DATABASE compte_bancari;
USE compte_bancari;
CREATE TABLE moviment
	(compte VARCHAR(10) NOT NULL,
	data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	descripcio VARCHAR(30) NOT NULL,
	tipus ENUM('H','D') NOT NULL,
	valor DECIMAL(7,2) NOT NULL
);
CREATE TABLE seguretat
	(compte VARCHAR(10) NOT NULL,
	data TIMESTAMP NOT NULL,
	usuari VARCHAR(20) NOT NULL,
	descripcio_valor VARCHAR(30) NOT NULL
);
CREATE TABLE saldo
	(compte VARCHAR(10) PRIMARY KEY,
	saldo DECIMAL(7,2) NOT NULL
);
CREATE TABLE saldo_diari
	(data  DATE PRIMARY KEY,
	saldo DECIMAL(7,2) NOT NULL
);

INSERT moviment VALUES ("1475","2022-03-20","Internet", "D", 29.50);
INSERT moviment VALUES ("1475","2022-03-20","Bizum", "H", 50.00);

INSERT moviment VALUES ("5342",current_timestamp(),"Ingrés", "H", 725.32);
INSERT moviment VALUES ("5342",current_timestamp(),"Devolució", "H", 15.72);
INSERT moviment VALUES ("5342",current_timestamp(),"Bar PEPITO", "D", 17.15);
INSERT moviment VALUES ("5342",current_timestamp(),"Reintegrament", "D", 225.32);
INSERT moviment VALUES ("5342",current_timestamp(),"Vehícle", "D", 1025.32);
INSERT moviment VALUES ("5342",current_timestamp(),"Pull & Bear", "D", 49.99);

INSERT moviment VALUES ("1849",current_timestamp(),"Reintegrament", "D", 101.78);
INSERT moviment VALUES ("1849",current_timestamp(),"Ingrés", "H", 725.32);
INSERT moviment VALUES ("1849",current_timestamp(),"Devolució", "H", 15.72);
INSERT moviment VALUES ("1849",current_timestamp(),"Bar PEPITO", "D", 17.15);
INSERT moviment VALUES ("1849",current_timestamp(),"Reintegrament", "D", 225.32);
INSERT moviment VALUES ("1849",current_timestamp(),"Reintegrament", "D", 101.78);
SELECT * FROM moviment;
SELECT * FROM seguretat; 
SELECT * FROM saldo;
SELECT * FROM saldo_diari;
DELETE FROM moviment;
DELETE FROM seguretat;
DELETE FROM saldo;
DELETE FROM saldo_diari;
DROP TRIGGER exer60ins;

DELIMITER //
CREATE TRIGGER exer60ins AFTER INSERT ON moviment FOR EACH ROW
	BEGIN
#!--- NO EXISTEIX EL COMPTE BANCARI ---
        IF ((SELECT COUNT(*) FROM saldo WHERE compte = new.compte)=0) THEN
			#! INGRÉS AL COMPTE
            IF (new.tipus = "H") THEN
				INSERT seguretat VALUES (new.compte,current_timestamp(),current_user(),CONCAT(new.descripcio," ",new.valor));
                INSERT saldo VALUES (new.compte,new.valor);
			#! DESPESA AL COMPTE			
            ELSE
				INSERT seguretat VALUES (new.compte,current_timestamp(),current_user(),CONCAT(new.descripcio," ",-new.valor));
                INSERT saldo VALUES (new.compte,-new.valor);
			END IF;
            
        
#!--- EXISTEIX EL COMPTE BANCARI ---    
		#! INGRÉS AL COMPTE
        ELSEIF (new.tipus = "H") THEN
			UPDATE saldo SET saldo=saldo+new.valor WHERE new.compte = compte;
            INSERT seguretat VALUES (new.compte,current_timestamp(),current_user(),CONCAT(new.descripcio," ",new.valor));
		#! DESPESA AL COMPTE
        ELSE 
			UPDATE saldo SET saldo=saldo-new.valor WHERE new.compte = compte;
            INSERT seguretat VALUES (new.compte,current_timestamp(),current_user(),CONCAT(new.descripcio," ",-new.valor));
		END IF;
		
        
	#! EL MATEIX DIA
		# INGRÉS SI NO EXISTEIX EN EL MATEIX DIA		
        IF (new.tipus = "H" AND (SELECT COUNT(*) FROM saldo_diari WHERE data=date(new.data))=0) THEN
			INSERT saldo_diari VALUES (date(new.data),new.valor); 
		# INGRÉS SI EXISTEIX EN DIA
        ELSEIF (new.tipus = "H" AND (SELECT COUNT(*) FROM saldo_diari WHERE data=date(new.data))>0) THEN
			UPDATE saldo_diari SET saldo=saldo+new.valor WHERE data = date(new.data); 
		
		# DESPESA SI NO EXISTEIX EN EL MATEIX DIA
        ELSEIF (new.tipus = "D" AND (SELECT COUNT(*) FROM saldo_diari WHERE data=date(new.data))=0)  THEN
			INSERT saldo_diari VALUES (date(new.data),-new.valor);
		# DESPESA SI EXISTEIX EN EL DIA
        ELSEIF (new.tipus = "D" AND (SELECT COUNT(*) FROM saldo_diari WHERE data=date(new.data))>0) THEN
			UPDATE saldo_diari SET saldo=saldo-new.valor WHERE data = date(new.data);

        END IF;
    END //
DELIMITER ;







#! EXERCICI 61
CREATE DATABASE lliga;
USE lliga;
CREATE TABLE partit
	(jornada INT,
	equip_local  VARCHAR(20),
	equip_visitant VARCHAR(20),
	gols_local INT,
	gols_visitant INT,
	PRIMARY KEY(jornada,equip_local)
);
CREATE TABLE classificacio
	(equip VARCHAR(20) PRIMARY KEY,
	partits_guanyats INT DEFAULT 0,
	partits_empatats INT DEFAULT 0,
	partits_perduts INT DEFAULT 0,
	gols_favor INT DEFAULT 0,
	gols_contra INT DEFAULT 0
);
CREATE TABLE podi
	(equip VARCHAR(20) PRIMARY KEY,
	punts INT DEFAULT 0
);

INSERT partit VALUES ("1","Atlètic Terrassa","Sporting Can Boada", 1, 1);
INSERT partit VALUES ("1","Ràpid Vacarisses","FC Viladecavalls", 2, 2);
INSERT partit VALUES ("2","FC Viladecavalls","Atlètic Terrassa", 0, 2);
INSERT partit VALUES ("2","Sporting Can Boada","Ràpid Vacarisses", 2, 3);
INSERT partit VALUES ("3","Atlètic Terrassa","Ràpid Vacarisses", 3, 1);
INSERT partit VALUES ("3","Sporting Can Boada","FC Viladecavalls", 1, 0);
INSERT partit VALUES ("4", "Ràpid Vacarisses", "FC Viladecavalls", 2, 2);
INSERT partit VALUES ("4","Sporting Can Boada","Atlètic Terrassa", 1, 2);

SELECT * FROM classificacio;
SELECT * FROM podi;
DELETE FROM classificacio;
DELETE FROM partit;
DELETE FROM podi;
DROP TRIGGER exer_61ins;
DROP TRIGGER exer_61podi;

DELIMITER //
CREATE TRIGGER exer_61ins AFTER INSERT ON partit FOR EACH ROW #!Trigger desprès del INSERT en partit per emplenar la taula Classificació | TAULA CLASSIFICACIÓ
BEGIN
#! ---- EQUIP LOCAL ----
	#! - Si no existeix l'equip -
	IF ((SELECT COUNT(*) FROM classificacio WHERE equip = new.equip_local) = 0) THEN
		IF (new.gols_local > new.gols_visitant) THEN
            INSERT classificacio VALUES (new.equip_local, 1, 0, 0, new.gols_local, new.gols_visitant);
		ELSEIF (new.gols_local = new.gols_visitant) THEN
            INSERT classificacio VALUES (new.equip_local, 0, 1, 0, new.gols_local, new.gols_visitant);
		ELSE
			INSERT classificacio VALUES (new.equip_local, 0, 0, 1, new.gols_local, new.gols_visitant);
		END IF;
	#! - Si existeix l'equip -
	ELSE
		#! - Partits guanyats - LOCAL
		IF (new.gols_local > new.gols_visitant) THEN
            UPDATE classificacio SET partits_guanyats=partits_guanyats+1, 
            gols_favor=(SELECT SUM(gols_local) FROM partit WHERE equip_local = new.equip_local) + (SELECT SUM(gols_visitant) FROM partit WHERE equip_visitant = new.equip_local), 
            gols_contra=gols_contra + new.gols_visitant
            WHERE equip = new.equip_local;	

		#! - Partits empatats - LOCAL
		ELSEIF (new.gols_local = new.gols_visitant) THEN
            UPDATE classificacio SET partits_guanyats=partits_empatats+1,              
            gols_favor=(SELECT SUM(gols_local) FROM partit WHERE equip_local = new.equip_local) + (SELECT SUM(gols_visitant) FROM partit WHERE equip_visitant = new.equip_local), 
            gols_contra=gols_contra + new.gols_visitant
            WHERE equip = new.equip_local;
         
		#! - Partits perduts - LOCAL         
		ELSE
            UPDATE classificacio SET partits_perduts=partits_perduts+1,              
            gols_favor=(SELECT SUM(gols_local) FROM partit WHERE equip_local = new.equip_local) + (SELECT SUM(gols_visitant) FROM partit WHERE equip_visitant = new.equip_local), 
            gols_contra=(SELECT SUM(gols_visitant) FROM partit WHERE equip_local = new.equip_local)
            WHERE equip = new.equip_local;		
		END IF;
	END IF;

#! ---- EQUIP VISITANT ----
	#! - Si no existeix l'equip -
	IF ((SELECT COUNT(*) FROM classificacio WHERE equip = new.equip_visitant) = 0) THEN
		IF (new.gols_visitant > new.gols_local) THEN
            INSERT classificacio VALUES (new.equip_visitant, 1, 0, 0, new.gols_visitant, new.gols_local);
            
		ELSEIF (new.gols_visitant = new.gols_local) THEN
            INSERT classificacio VALUES (new.equip_visitant, 0, 1, 0, new.gols_visitant, new.gols_local);
            
		ELSE
			INSERT classificacio VALUES (new.equip_visitant, 0, 0, 1, new.gols_visitant, new.gols_local);
		END IF;
	#! - Si existeix l'equip - VISITANT
	ELSE
		#! - Partits guanyats - VISITANT
        IF (new.gols_visitant > new.gols_local) THEN
            UPDATE classificacio SET partits_guanyats=partits_guanyats+1,  
            gols_favor=(SELECT SUM(gols_visitant) FROM partit WHERE equip_visitant = new.equip_visitant) + (SELECT SUM(gols_local) FROM partit WHERE equip_local = new.equip_visitant), 
            gols_contra=gols_contra + new.gols_local
            WHERE equip = new.equip_visitant;		
            
		#! - Partits empatats - VISITANT
		ELSEIF (new.gols_visitant = new.gols_local) THEN
            UPDATE classificacio SET partits_empatats=partits_empatats+1,
			gols_favor=(SELECT SUM(gols_visitant) FROM partit WHERE equip_visitant = new.equip_visitant) + (SELECT SUM(gols_local) FROM partit WHERE equip_local = new.equip_visitant), 
            gols_contra=gols_contra + new.gols_local
            WHERE equip = new.equip_visitant;		
            
		#! - Partits perduts - VISITANT
        ELSE
            UPDATE classificacio SET partits_perduts=partits_perduts+1,
            gols_favor=(SELECT SUM(gols_visitant) FROM partit WHERE equip_visitant = new.equip_visitant) + (SELECT SUM(gols_local) FROM partit WHERE equip_local = new.equip_visitant), 
            gols_contra=gols_contra + new.gols_local
            WHERE equip = new.equip_visitant;	
            
		END IF;
	END IF;
	
END //

CREATE TRIGGER exer_61podi AFTER INSERT ON partit FOR EACH ROW #!Trigger desprès d'insertar i actualitzar la taula Classificació | TAULA PODI
BEGIN
#! ---- EQUIP LOCAL ----
	#! - Si no existeix l'equip -
	IF ((SELECT COUNT(*) FROM podi WHERE equip = new.equip_local) = 0) THEN
		IF (new.gols_local > new.gols_visitant) THEN
            INSERT podi VALUES (new.equip_local, 3);
		ELSEIF (new.gols_local = new.gols_visitant) THEN
            INSERT podi VALUES (new.equip_local, 1);
		ELSE
			INSERT podi VALUES (new.equip_local, 0);
		END IF;
	#! - Si existeix l'equip -
	ELSE
		#! - Partits guanyats - LOCAL
		IF (new.gols_local > new.gols_visitant) THEN
            UPDATE podi SET punts=punts+3
            WHERE equip = new.equip_local;

		#! - Partits empatats - LOCAL
		ELSEIF (new.gols_local = new.gols_visitant) THEN
            UPDATE podi SET punts=punts+1
            WHERE equip = new.equip_local;
         
		#! - Partits perduts - LOCAL -NO SUMA-    
		END IF;
	END IF;
#! ---- EQUIP VISITANT ----
	#! - Si no existeix l'equip -
	IF ((SELECT COUNT(*) FROM podi WHERE equip = new.equip_visitant) = 0) THEN
		IF (new.gols_visitant > new.gols_local) THEN
            INSERT podi VALUES (new.equip_visitant, 3);
            
		ELSEIF (new.gols_visitant = new.gols_local) THEN
            INSERT podi VALUES (new.equip_visitant, 1);
            
		ELSE
            INSERT podi VALUES (new.equip_visitant, 0);
		END IF;
	#! - Si existeix l'equip - VISITANT
	ELSE
		#! - Partits guanyats - VISITANT
        IF (new.gols_visitant > new.gols_local) THEN
            UPDATE podi SET punts=punts+3
            WHERE equip = new.equip_visitant;
            
		#! - Partits empatats - VISITANT
		ELSEIF (new.gols_visitant = new.gols_local) THEN
            UPDATE podi SET punts=punts+1
            WHERE equip = new.equip_visitant;	
            
		#! - Partits perduts - VISITANT -NO SUMA-    
		END IF;
	END IF;
END //

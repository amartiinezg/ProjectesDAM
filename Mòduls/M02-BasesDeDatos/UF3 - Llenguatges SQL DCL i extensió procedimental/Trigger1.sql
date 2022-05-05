CREATE DATABASE exemple_disparadors;
USE exemple_disparadors;
CREATE TABLE prova (codi INT);
CREATE TABLE suma (suma INT);
CREATE TABLE suma_text (suma VARCHAR(200));
INSERT INTO suma VALUES (0);

DELIMITER //
CREATE TRIGGER actual AFTER INSERT ON prova FOR EACH ROW
BEGIN
    UPDATE suma SET suma=suma+1;
END //

# Eliminar después del INSERT.
CREATE TRIGGER eliminar AFTER DELETE ON prova FOR EACH ROW
BEGIN
	UPDATE suma SET suma=(SELECT COUNT(codi) FROM prova);
END //

# 52 Registro del último código de prova en suma
CREATE TRIGGER exer_52 AFTER INSERT ON prova FOR EACH ROW
BEGIN
	UPDATE suma SET suma=new.codi;
END //
# 54 Valor de suma_text 1+2+3 per exemple en els codis que tenim
CREATE TRIGGER exer_54 AFTER INSERT ON prova FOR EACH ROW
BEGIN
	IF((SELECT COUNT(*) FROM suma_text)=0) THEN
		INSERT INTO suma_text VALUES (new.codi);
	ELSE
		UPDATE suma_text SET suma=CONCAT(new.codi," + ", suma);
        END IF;
END //
DELIMITER ;

#55 Creem una taula anomenada prova_log que té tres camps (hora i data, usuari, acció).
#! Crea un disparador que faci un registre de tots els canvis que fem a la taula prova, tant sigui inserir,
#! esborrar o modificar.
CREATE TABLE prova_log (
fecha TIMESTAMP,
usuari VARCHAR(30),
accio VARCHAR(30)
);

DELIMITER //
CREATE TRIGGER exer_55insert AFTER INSERT ON prova FOR EACH ROW
BEGIN
	INSERT prova_log VALUES (now(),current_user(),concat("Insert -> ",new.codi));
END //
CREATE TRIGGER exer_55delete AFTER DELETE ON prova FOR EACH ROW
BEGIN
	INSERT prova_log VALUES (now(),current_user(),"Delete -> ",old.codi);
END //
CREATE TRIGGER exer_55update AFTER UPDATE ON prova FOR EACH ROW
BEGIN
	INSERT prova_log VALUES (now(),current_user(),"Update: ",old.codi," -> ",new.codi);
END //
DELIMITER ;

#!56 Suposem que els valors introduïts a la taula prova només poden ser valors de 1 a 10. Crea una taula
#! anomenada suma_valors amb dos camps (codi i vegades) que comptarà les vegades que surt el codi
#! a la taula prova. Crea el disparador que faci el recompte per valors del 1 al 10.
CREATE TABLE suma_valors (
codi INT,
vegades INT
);

DELIMITER //
CREATE TRIGGER exer_56ins AFTER INSERT ON prova FOR EACH ROW
BEGIN
	 IF ((SELECT COUNT(*) FROM suma_valors WHERE codi=new.codi)=0) THEN
		INSERT suma_valors VALUES (new.codi,1);
    ELSE
        UPDATE suma_valors SET vegades=(SELECT COUNT(codi) FROM prova WHERE codi=new.codi) WHERE codi=new.codi;
    END IF;
END //
CREATE TRIGGER exer_56del AFTER DELETE ON prova FOR EACH ROW
BEGIN
	IF ((SELECT COUNT(*) FROM prova WHERE codi=old.codi)=0) THEN
		DELETE FROM suma_valors WHERE codi=old.codi;
    ELSE
		UPDATE suma_valors SET vegades=(SELECT COUNT(codi) FROM prova WHERE codi=old.codi) WHERE codi=old.codi;
    END IF;
    
END //
CREATE TRIGGER exer_56upd AFTER UPDATE ON prova FOR EACH ROW
BEGIN

	IF ((SELECT COUNT(*) FROM prova WHERE codi=old.codi)=0) THEN
		DELETE FROM suma_valors WHERE codi=old.codi;
	ELSEIF ((SELECT COUNT(*) FROM suma_valors WHERE codi=new.codi)=0) THEN
		INSERT suma_valors VALUES (new.codi,1);
    ELSE
	UPDATE suma_valors SET vegades=(SELECT COUNT(codi) FROM prova WHERE codi=new.codi) WHERE codi=new.codi;
    UPDATE suma_valors SET vegades=(SELECT COUNT(codi) FROM prova WHERE codi=old.codi) WHERE codi=old.codi;
    END IF;
END //
DELIMITER ;

INSERT suma_valors VALUES (1,0),(2,0),(3,0),(4,0),(5,0),
(6,0),(7,0),(8,0),(9,0),(10,0);
#! 57 Crea un disparador que només mantingui a la taula suma els 10 últims registres de la taula prova.
DELIMITER //
CREATE TRIGGER exer_57ins AFTER INSERT ON prova FOR EACH ROW
BEGIN
		INSERT suma VALUES (new.codi);
	IF((SELECT COUNT(*) FROM suma)>10) THEN
		DELETE FROM suma LIMIT 1;
	END IF;
END //
DELIMITER ;

#! 58 Crea una taula prova_puntuacio amb dos camps (un camp lletra que serà A, B, C, D o E, un valor
#! numèric anomenat puntuacio que serà un enter de 1 a 10).
#! Crea un disparador posi en una taula anomenada prova_puntuacio_seg l'últim valor de cada lletra
#! introduït i la seva puntuació (pensa que a la taula prova_puntuació_seg sempre hi haurà 5 registres
#! que seran l'últim registre de cada lletra introduït).
CREATE TABLE prova_puntuacio (lletra ENUM('A','B','C','D','E'), puntuacio SMALLINT CHECK(puntuacio>=1 AND puntuacio<=10));
CREATE TABLE prova_puntuacio_seg (lletra ENUM('A','B','C','D','E'), puntuacio SMALLINT);
DELIMITER //
CREATE TRIGGER exer58ins AFTER INSERT ON prova_puntuacio FOR EACH ROW
BEGIN
	UPDATE prova_puntuacio_seg SET puntuacio=new.puntuacio WHERE lletra=new.lletra;
END //
DELIMITER ;
#! 59 Crea un disparador de manera que a prova_puntuacio_seg compti les puntuacions total per cada
#! lletra (hi haurà 5 registres amb la puntuació total de cadascuna).
DELIMITER //
CREATE TRIGGER exer59ins AFTER INSERT ON prova_puntuacio FOR EACH ROW
BEGIN
	UPDATE prova_puntuacio_seg SET puntuacio=(SELECT COUNT(*) FROM prova_puntuacio WHERE lletra=new.lletra) WHERE lletra=new.lletra;
END //
CREATE TRIGGER exer59del AFTER DELETE ON prova_puntuacio FOR EACH ROW
BEGIN
	UPDATE prova_puntuacio_seg SET puntuacio=(SELECT COUNT(*) FROM prova_puntuacio WHERE lletra=old.lletra) WHERE lletra=old.lletra;
END //
CREATE TRIGGER exer59upd AFTER UPDATE ON prova_puntuacio FOR EACH ROW
BEGIN
	IF (new.lletra <> old.lletra)THEN
    UPDATE prova_puntuacio_seg SET puntuacio=(SELECT COUNT(*) FROM prova_puntuacio WHERE lletra=old.lletra) WHERE lletra=old.lletra;
	UPDATE prova_puntuacio_seg SET puntuacio=(SELECT COUNT(*) FROM prova_puntuacio WHERE lletra=new.lletra) WHERE lletra=new.lletra;
    END IF;
END //
DELIMITER ;



INSERT prova_puntuacio_seg VALUES ('A',0),('B',0),('C',0),('D',0),('E',0);
SELECT * FROM prova_puntuacio_seg;
INSERT prova_puntuacio VALUES ('C',3);
DROP TRIGGER exer59ins;
SHOW TRIGGERS;

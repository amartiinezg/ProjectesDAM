CREATE DATABASE IF NOT EXISTS centreAssistencia;
USE centreAssistencia;

CREATE TABLE IF NOT EXISTS assistencia_diaria
(id_targeta VARCHAR(8),
data TIMESTAMP,
ent_sort ENUM('E','S')
);

CREATE TABLE IF NOT EXISTS hores_dia
(id_targeta VARCHAR(8) ,
dia DATE,
temps INT,
PRIMARY KEY(id_targeta,dia)
);

CREATE TABLE IF NOT EXISTS mensual
(id_targeta VARCHAR(8),
mes SMALLINT,
num_dies SMALLINT,
PRIMARY KEY(id_targeta,mes)
);

CREATE TABLE IF NOT EXISTS registre
(id_targeta VARCHAR(8),
comentari VARCHAR(80)
);

/*Taula hores_dia: Enregistrar el temps diari que l’alumnat pasa al centre. Heu de tenir en que
es pot entrar i sortir diverses vegades un mateix dia (3’5 punts)*/
DELIMITER //
CREATE TRIGGER hores_diaINS AFTER INSERT ON assistencia_diaria FOR EACH ROW
BEGIN
	DECLARE existeixDia SMALLINT(2);
	DECLARE tempsDia INT;
		SET existeixDia = (SELECT COUNT((DATE(new.data))) FROM assistencia_diaria WHERE id_targeta = new.id_targeta);
		SET tempsDia = (SELECT ABS((time(data)-(SELECT time(data) FROM assistencia_diaria WHERE id_targeta = new.id_targeta AND ent_sort = 'S'))) FROM assistencia_diaria WHERE id_targeta = new.id_targeta AND ent_sort = 'E');
    
	IF(existeixDia = 1) THEN
		INSERT INTO hores_dia(id_targeta, dia) VALUES (new.id_targeta, new.data);
	
    ELSEIF (new.ent_sort = 'S') THEN
		UPDATE hores_dia SET temps = temps+tempsDia WHERE id_targeta = new.id_targeta;
    END IF;
END //
DELIMITER ;

DROP TRIGGER hores_diaINS;
INSERT INTO assistencia_diaria VALUES (1, "2022-05-01 08:58:34", 'E');
INSERT INTO assistencia_diaria VALUES (1, "2022-05-01 14:31:14", 'S');

INSERT INTO assistencia_diaria VALUES (2, "2022-05-02 07:54:43", 'E');
INSERT INTO assistencia_diaria VALUES (3, "2022-04-03 08:02:12", 'E');

DELETE FROM hores_dia;
DELETE FROM assistencia_diaria;
SELECT * FROM hores_dia;
SELECT * FROM assistencia_diaria;

#SELECT count(month(data)) FROM assistencia_diaria WHERE id_targeta = 1;
/*Taula mensual: Comptar els dies del mes que l’alumnat va al centre. Per fer-ho utilitzeu la
taula mensual on registrarà el mes i el número dies que ha assistit (3 punts).*/
DELIMITER //
CREATE TRIGGER mensualINS AFTER INSERT ON assistencia_diaria FOR EACH ROW
BEGIN
	DECLARE diesAssistits SMALLINT(2);
    DECLARE existeixMes SMALLINT(2);
		SET diesAssistits = (SELECT COUNT(data) FROM assistencia_diaria WHERE id_targeta = new.id_targeta);
		SET existeixMes = (SELECT count(month(data)) FROM assistencia_diaria WHERE id_targeta = new.id_targeta);
	
    IF(existeixMes = 1) THEN
		INSERT INTO mensual VALUES (new.id_targeta, month(new.data), diesAssistits);
    ELSE
		UPDATE mensual SET num_dies = diesAssistits + num_dies WHERE id_targeta = new.id_targeta;
	END IF;
END //
DELIMITER ;

DELETE FROM mensual;
SELECT * FROM mensual;

/* Taula registre: Crear un registre de manera que quedin registrats certs esdeveniments (3’5
punts):
o Quan s’arriba més tard de les 9 del matí, el missatge que emmagatzemarà serà
 'Entrada el dia 03/05/2022 a les 9:18'.
o Quan el mateix dia, número de sortides sigui major al número d’entrades:
 ‘Dia 03/05/2022 número d’entrades incorrecte’
o Quan, el mateix dia, l’alumne/a entri més de 4 vegades al centre, el missatge que
emmagatzemarà:
 'Entrades del dia 03/05/2022: 4'.*/

DELIMITER //
CREATE TRIGGER registreINS AFTER INSERT ON assistencia_diaria FOR EACH ROW
BEGIN
        INSERT INTO registre VALUES (new.id_targeta, CONCAT("Entrada el dia ", date(new.data), " a les ", time(new.data)));
END //
DELIMITER ;

DROP TRIGGER registreINS;
INSERT INTO assistencia_diaria VALUES (5, "2022-04-07 09:12:12", 'E');
SELECT * FROM registre;
CREATE DATABASE IF NOT EXISTS producte;
USE producte;

CREATE TABLE IF NOT EXISTS producte.producto
  (codigo INT(3) PRIMARY KEY, 
   descripcion VARCHAR(30),
   stock INT(3),
   umbral_pedido INT(4)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS producte.venta
  (NumVenta INT(2) PRIMARY KEY, 
   CodProducto INT(3),
   Cantidad INT(3),
   Fecha DATE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS producte.ordenespedido
  (NumPedido INT(4) PRIMARY KEY, 
   CodProducto INT(3),
   Cantidad INT(3)
) ENGINE=InnoDB;

INSERT INTO producto VALUES (1,"Camiseta Trasher", 50, 20);
INSERT INTO producto VALUES (2,"Sudadera Nike", 10, 5);
INSERT INTO producto VALUES (3,"Pantalons Adidas", 25, 10);

INSERT INTO venta VALUES (10, 2, 8, '2022-04-20');
INSERT INTO venta VALUES (11, 1, 18, '2022-04-17');
INSERT INTO venta VALUES (13, 3, 17, '2022-04-19');

SELECT * FROM producto;
SELECT * FROM venta;
DELIMITER //
CREATE TRIGGER ventas AFTER INSERT ON venta FOR EACH ROW
BEGIN
	DECLARE umbral_v int(4);
    DECLARE stock_v int(3);
		SET umbral_v = (SELECT umbral_pedido FROM producto WHERE codigo = new.codproducto);
        
	UPDATE producto SET stock = stock-new.cantidad WHERE codigo = new.codproducto;
    SET stock_v = (SELECT stock FROM producto WHERE codigo = new.codproducto);
    IF((SELECT stock FROM producto WHERE codigo = new.codproducto) < (SELECT umbral_pedido FROM producto WHERE codigo = new.codproducto)) THEN
		INSERT INTO ordenespedido(CodProducto, Cantidad) VALUES (new.codproducto,umbral_v*3-stock_v);
	END IF;
END //
DELIMITER ;

SHOW TRIGGERS;

#-----------------------------------------------------------------------------------------------------------------------

CREATE DATABASE alumnes;
USE alumnes;
CREATE TABLE IF NOT EXISTS alumnes
  (codi TINYINT(2) PRIMARY KEY AUTO_INCREMENT, 
   nom VARCHAR(30),
   cognoms VARCHAR(30)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS login_alumnes
  (codi TINYINT(2) PRIMARY KEY, 
   login VARCHAR(15),
   FOREIGN KEY (codi) REFERENCES alumnes(codi)
) ENGINE=InnoDB;

DELIMITER //
CREATE TRIGGER creacioLogin AFTER INSERT ON alumnes FOR EACH ROW
BEGIN
	INSERT login_alumnes VALUES (new.codi,(SELECT LOWER(CONCAT(SUBSTRING(nom,1,2),SUBSTRING(cognoms,1,2),codi)) FROM alumnes WHERE codi = new.codi));
END // 
DELIMITER ;
DROP TRIGGER creacioLogin;

INSERT alumnes(nom,cognoms) VALUES ("Ferran", "Torres");
INSERT alumnes(nom,cognoms) VALUES ("Marc", "Martínez");
SELECT LOWER(CONCAT(SUBSTRING(nom,1,2),SUBSTRING(cognoms,1,2),codi)) FROM alumnes;
SELECT * FROM login_alumnes;

#-----------------------------------------------------------------------------------------------------------------------

CREATE DATABASE caballos;
USE caballos;
CREATE TABLE IF NOT EXISTS carreras
  (codcarrera VARCHAR(4) PRIMARY KEY, 
   fecha DATE,
   nombre VARCHAR(20),
   importe_premio INT(6),
   apuesta_limite DECIMAL(5,2)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS participaciones
  (codcaballo VARCHAR(4), 
   codcarrera VARCHAR(4),
   dorsal TINYINT(2),
   jockey VARCHAR(10),
   posicion_final TINYINT(2),
   PRIMARY KEY (codcaballo, codcarrera)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS apuestas
  (dni VARCHAR(10), 
   codcaballo VARCHAR(4), 
   codcarrera VARCHAR(4),
   importe INT(6),
   tantoporuno DECIMAL(4,2),
   PRIMARY KEY (dni, codcaballo, codcarrera)
) ENGINE=InnoDB;

INSERT INTO carreras VALUES("1", "2021-05-22", "Carrera Pirineos", 5000, 500.00);	
INSERT INTO participaciones VALUES(45, 1, 10, "Alfredo", 2);
INSERT INTO participaciones VALUES(15, 1, 21, "Berto", 1);
INSERT INTO participaciones VALUES(8, 1, 33, "Isac", 3);
INSERT INTO participaciones VALUES(13, 2, 1, "Felipe", 1);

INSERT INTO apuestas VALUES ("453355754F", 45, 3, 300, 10);

DELIMITER //
CREATE TRIGGER apuestasINS BEFORE INSERT ON apuestas FOR EACH ROW
BEGIN
	IF((SELECT COUNT(*) FROM participaciones WHERE codcaballo=new.codcaballo AND codcarrera=new.codcarrera)=0 OR 
    (new.importe > (SELECT apuesta_limite FROM carreras WHERE codcarrera = new.codcarrera))) THEN
		CALL RAISE_APPLICATION_ERROR("ERROR");
    END IF;
END //
DELIMITER ;
DROP TRIGGER apuestasINS;
DELETE FROM participaciones;
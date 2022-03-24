DROP DATABASE IF EXISTS plantes;
CREATE DATABASE plantesDB;
USE plantesDB;

CREATE TABLE estacio
      	(nom_estacio     	CHAR(9) 	PRIMARY KEY       
      	)ENGINE = InnoDB
	;

CREATE TABLE metode_reproduccio
	(nom_metode		CHAR(20)	PRIMARY KEY
	)ENGINE = InnoDB
	;	

CREATE TABLE firma_comercial
	(nom_firma		CHAR(20)	PRIMARY KEY
	)ENGINE = InnoDB
	;

CREATE TABLE adob
	(nom_adob		CHAR(20)		PRIMARY KEY,
	nom_firma		CHAR(20)		NOT NULL,
	tipus_adob		ENUM('LLD','AI')        NOT NULL,
	FOREIGN KEY (nom_firma) REFERENCES firma_comercial(nom_firma)
	)ENGINE = InnoDB
	;

CREATE TABLE planta
	(nom_cientific		CHAR(20)	PRIMARY KEY,
	nom_popular		CHAR(20),
	floracio		CHAR(9),
	FOREIGN KEY (floracio) REFERENCES estacio(nom_estacio)
      	)ENGINE = InnoDB
	;

CREATE TABLE planta_interior
	(nom_planta		CHAR(20)	PRIMARY KEY,
	ubicacio		CHAR(20),
	temperatura		INTEGER,
	FOREIGN KEY (nom_planta) REFERENCES planta(nom_cientific)
	)ENGINE = InnoDB
	;

CREATE TABLE planta_exterior
	(nom_planta		CHAR(20)	PRIMARY KEY,
	tipus_planta		ENUM('T','P'),
	FOREIGN KEY (nom_planta) REFERENCES planta(nom_cientific)
	)ENGINE = InnoDB
	;

CREATE TABLE exemplar_planta 
	(nom_planta		CHAR(20)	NOT NULL,
	num_exemplar		INTEGER		NOT NULL,
	PRIMARY KEY(nom_planta,num_exemplar),
	FOREIGN KEY (nom_planta) REFERENCES planta(nom_cientific)
	)ENGINE = InnoDB
	;

CREATE TABLE dosi_adob
	(nom_planta		CHAR(20)	NOT NULL,
	nom_estacio		CHAR(9)		NOT NULL,
	nom_adob		CHAR(20)	NOT NULL,
	quantitat_adob		INTEGER		CHECK ((quantitat_adob>20) AND (quantitat_adob<100)),
	PRIMARY KEY(nom_planta,nom_estacio,nom_adob),
	FOREIGN KEY (nom_planta) REFERENCES planta(nom_cientific),
	FOREIGN KEY (nom_estacio) REFERENCES estacio(nom_estacio),
	FOREIGN KEY (nom_adob) REFERENCES adob(nom_adob)
	)ENGINE = InnoDB
	;	

CREATE TABLE reproduccio
	(nom_planta		CHAR(20)	NOT NULL REFERENCES planta,
	metode_reproduccio	CHAR(20)	NOT NULL REFERENCES metode_reproduccio,
	grau_exit		ENUM('Mitj�','Alt','Baix'),
	FOREIGN KEY (nom_planta) REFERENCES planta(nom_cientific),
	FOREIGN KEY (metode_reproduccio) REFERENCES metode_reproduccio(nom_metode)
	)ENGINE = InnoDB
	;

INSERT INTO estacio VALUES ('Estiu');
INSERT INTO estacio VALUES ('Hivern');
INSERT INTO estacio VALUES ('Primavera');
INSERT INTO estacio VALUES ('Tardor');

INSERT INTO metode_reproduccio VALUES ('Bulbs');
INSERT INTO metode_reproduccio VALUES ('Capficats');
INSERT INTO metode_reproduccio VALUES ('Esqueix');
INSERT INTO metode_reproduccio VALUES ('Estaques');
INSERT INTO metode_reproduccio VALUES ('Estolons');
INSERT INTO metode_reproduccio VALUES ('Llavors');
	
INSERT INTO firma_comercial VALUES ('CIRSADOB');
INSERT INTO firma_comercial VALUES ('PRISADOB');
INSERT INTO firma_comercial VALUES ('TIRSADOB');
INSERT INTO firma_comercial VALUES ('UOCADOB');
	
INSERT INTO adob VALUES ('Plantavit','UOCADOB','LLD');
INSERT INTO adob VALUES ('Vitaplant','TIRSADOB','AI');
INSERT INTO adob VALUES ('Nutreplant','CIRSADOB','LLD');
INSERT INTO adob VALUES ('Creixplant','PRISADOB','AI');
INSERT INTO adob VALUES ('Casadob','TIRSADOB','AI');
INSERT INTO adob VALUES ('Plantadob','PRISADOB','LLD');
INSERT INTO adob VALUES ('Superplant','CIRSADOB','AI');
INSERT INTO adob VALUES ('Sanexplant','UOCADOB','LLD');

INSERT INTO planta VALUES ('Geranium','Gerani','Primavera');
INSERT INTO planta VALUES ('Begonia rex','Beg�nia','Estiu');
INSERT INTO planta VALUES ('Camellia','Cam�lia','Primavera');
INSERT INTO planta VALUES ('Cyclamen','Ciclamen','Hivern');
INSERT INTO planta VALUES ('Rosa','Roser','Primavera');
INSERT INTO planta VALUES ('Polystichum','Falguera',null);
INSERT INTO planta VALUES ('Tulipa','Tulipa','Primavera');
INSERT INTO planta VALUES ('Chrysanthemum','Crisantem','Estiu');
INSERT INTO planta VALUES ('Philodendron','Potus',null);
INSERT INTO planta VALUES ('Chlorophytum','Cintes',null);
INSERT INTO planta VALUES ('Euphorbia','Poinsetia','Hivern');
INSERT INTO planta VALUES ('Hedera','Heura',null);
INSERT INTO planta VALUES ('Ficus','Ficus Benjamina',null);
INSERT INTO planta VALUES ('Codiaeum','Croton',null);

INSERT INTO planta_interior VALUES ('Philodendron','Llum directa',15);
INSERT INTO planta_interior VALUES ('Euphorbia','Llum indirecta',18);
INSERT INTO planta_interior VALUES ('Ficus','Llum indirecta',19);
INSERT INTO planta_interior VALUES ('Codiaeum','No corrents',17);

INSERT INTO planta_exterior VALUES ('Geranium','P');
INSERT INTO planta_exterior VALUES ('Begonia rex','P');
INSERT INTO planta_exterior VALUES ('Camellia','P');
INSERT INTO planta_exterior VALUES ('Cyclamen','P');
INSERT INTO planta_exterior VALUES ('Rosa','P');
INSERT INTO planta_exterior VALUES ('Polystichum','P');
INSERT INTO planta_exterior VALUES ('Tulipa','T');
INSERT INTO planta_exterior VALUES ('Chrysanthemum','T');
INSERT INTO planta_exterior VALUES ('Chlorophytum','P');
INSERT INTO planta_exterior VALUES ('Hedera','P');

INSERT INTO exemplar_planta VALUES ('Geranium',1);
INSERT INTO exemplar_planta VALUES ('Geranium',2);
INSERT INTO exemplar_planta VALUES ('Geranium',3);
INSERT INTO exemplar_planta VALUES ('Geranium',4);
INSERT INTO exemplar_planta VALUES ('Geranium',5);
INSERT INTO exemplar_planta VALUES ('Geranium',6);
INSERT INTO exemplar_planta VALUES ('Begonia rex',1);
INSERT INTO exemplar_planta VALUES ('Begonia rex',2);
INSERT INTO exemplar_planta VALUES ('Begonia rex',3);
INSERT INTO exemplar_planta VALUES ('Begonia rex',4);
INSERT INTO exemplar_planta VALUES ('Rosa',1);
INSERT INTO exemplar_planta VALUES ('Rosa',2);
INSERT INTO exemplar_planta VALUES ('Rosa',3);
INSERT INTO exemplar_planta VALUES ('Hedera',1);
INSERT INTO exemplar_planta VALUES ('Hedera',2);
INSERT INTO exemplar_planta VALUES ('Hedera',3);
INSERT INTO exemplar_planta VALUES ('Hedera',4);
INSERT INTO exemplar_planta VALUES ('Ficus',1);
INSERT INTO exemplar_planta VALUES ('Ficus',2);
INSERT INTO exemplar_planta VALUES ('Codiaeum',1);
INSERT INTO exemplar_planta VALUES ('Codiaeum',2);
INSERT INTO exemplar_planta VALUES ('Codiaeum',3);
INSERT INTO exemplar_planta VALUES ('Euphorbia',1);
INSERT INTO exemplar_planta VALUES ('Euphorbia',2);
INSERT INTO exemplar_planta VALUES ('Cyclamen',1);
INSERT INTO exemplar_planta VALUES ('Cyclamen',2);

INSERT INTO dosi_adob VALUES ('Geranium','Primavera','Casadob',30);
INSERT INTO dosi_adob VALUES ('Geranium','Hivern','Vitaplant',20);
INSERT INTO dosi_adob VALUES ('Begonia rex','Estiu','Casadob',25);
INSERT INTO dosi_adob VALUES ('Camellia','Hivern','Plantavit',50);
INSERT INTO dosi_adob VALUES ('Camellia','Primavera','Casadob',75);
INSERT INTO dosi_adob VALUES ('Cyclamen','Tardor','Casadob',30);
INSERT INTO dosi_adob VALUES ('Chrysanthemum','Primavera','Casadob',45);
INSERT INTO dosi_adob VALUES ('Begonia rex','Primavera','Nutreplant',50);
INSERT INTO dosi_adob VALUES ('Rosa','Primavera','Casadob',30);
INSERT INTO dosi_adob VALUES ('Rosa','Primavera','Creixplant',50);
INSERT INTO dosi_adob VALUES ('Polystichum','Primavera','Casadob',40);
INSERT INTO dosi_adob VALUES ('Polystichum','Tardor','Plantadob',20);
INSERT INTO dosi_adob VALUES ('Tulipa','Hivern','Casadob',40);
INSERT INTO dosi_adob VALUES ('Philodendron','Primavera','Casadob',40);
INSERT INTO dosi_adob VALUES ('Chlorophytum','Tardor','Casadob',30);
INSERT INTO dosi_adob VALUES ('Chlorophytum','Hivern','Superplant',40);
INSERT INTO dosi_adob VALUES ('Euphorbia','Hivern','Casadob',50);
INSERT INTO dosi_adob VALUES ('Euphorbia','Hivern','Sanexplant',40);
INSERT INTO dosi_adob VALUES ('Hedera','Primavera','Casadob',45);
INSERT INTO dosi_adob VALUES ('Codiaeum','Primavera','Casadob',50);
INSERT INTO dosi_adob VALUES ('Codiaeum','Estiu','Casadob',60);
INSERT INTO dosi_adob VALUES ('Geranium','Estiu','Sanexplant',40);
INSERT INTO dosi_adob VALUES ('Ficus','Primavera','Casadob',50);

INSERT INTO reproduccio VALUES ('Geranium','Esqueix','Alt');
INSERT INTO reproduccio VALUES ('Begonia rex','Esqueix','Alt');
INSERT INTO reproduccio VALUES ('Begonia rex','Capficats','Alt');
INSERT INTO reproduccio VALUES ('Begonia rex','Llavors','Baix');
INSERT INTO reproduccio VALUES ('Rosa','Estaques','Mitj�');
INSERT INTO reproduccio VALUES ('Rosa','Bulbs','Alt');
INSERT INTO reproduccio VALUES ('Chlorophytum','Estolons','Alt');
INSERT INTO reproduccio VALUES ('Cyclamen','Esqueix','Alt');
INSERT INTO reproduccio VALUES ('Cyclamen','Capficats','Mitj�');
INSERT INTO reproduccio VALUES ('Philodendron','Capficats','Alt');
INSERT INTO reproduccio VALUES ('Philodendron','Esqueix','Alt');
INSERT INTO reproduccio VALUES ('Tulipa','Bulbs','Alt');
INSERT INTO reproduccio VALUES ('Ficus','Estaques','Baix');
INSERT INTO reproduccio VALUES ('Ficus','Capficats','Baix');
INSERT INTO reproduccio VALUES ('Ficus','Esqueix','Alt');
INSERT INTO reproduccio VALUES ('Codiaeum','Esqueix','Baix');
INSERT INTO reproduccio VALUES ('Codiaeum','Capficats','Mitj�');
INSERT INTO reproduccio VALUES ('Codiaeum','Bulbs','Alt');
INSERT INTO reproduccio VALUES ('Polystichum','Esqueix','Alt');
INSERT INTO reproduccio VALUES ('Hedera','Esqueix','Mitj�');
INSERT INTO reproduccio VALUES ('Chrysanthemum','Bulbs','Alt');
INSERT INTO reproduccio VALUES ('Camellia','Estaques','Alt');
INSERT INTO reproduccio VALUES ('Hedera','Capficats','Alt');
INSERT INTO reproduccio VALUES ('Euphorbia','Llavors','Baix');
INSERT INTO reproduccio VALUES ('Euphorbia','Esqueix','Baix');
INSERT INTO reproduccio VALUES ('Euphorbia','Estaques','Alt');
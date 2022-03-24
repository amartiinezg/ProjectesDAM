CREATE DATABASE IF NOT EXISTS hospital;

CREATE TABLE IF NOT EXISTS hospital.area 
(
    numArea TINYINT PRIMARY KEY,
    nomArea VARCHAR(45) UNIQUE NOT NULL
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS hospital.prova
(
    codProv TINYINT PRIMARY KEY, 
    descr VARCHAR(45)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS hospital.planta 
(
    numPl TINYINT PRIMARY KEY,
    numHab TINYINT
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS hospital.llit
(
    numPl TINYINT,
    numLlit TINYINT,
    PRIMARY KEY (numPl, numLlit),
    FOREIGN KEY (numPL) REFERENCES hospital.planta (numPl) ON DELETE NO ACTION ON UPDATE CASCADE
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS hospital.pacient
(
    dni CHAR(9) PRIMARY KEY,
    nom VARCHAR(45) NOT NULL,
    cognoms VARCHAR(45) NOT NULL,
    dataAlta DATE, 
    numP TINYINT, 
    numL TINYINT,
    FOREIGN KEY (numP,numL) REFERENCES hospital.llit (numPl,numLlit) ON DELETE SET NULL ON UPDATE CASCADE
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS hospital.metge
(
    codMetge TINYINT PRIMARY KEY, 
    nom VARCHAR(45) NOT NULL, 
    cognoms VARCHAR(45) NOT NULL,
    sou DECIMAL,
    numArea TINYINT,
    FOREIGN KEY (numArea) REFERENCES hospital.area (numArea) ON DELETE SET NULL ON UPDATE CASCADE
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS hospital.infermer
(
    codInf TINYINT PRIMARY KEY, 
    nom VARCHAR(45) NOT NULL, 
    cognoms VARCHAR(45) NOT NULL,
    numArea TINYINT,
    FOREIGN KEY (numArea) REFERENCES hospital.area (numArea) ON DELETE SET NULL ON UPDATE CASCADE
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS hospital.visita 
(
    dniPac CHAR(9),
    codMetge TINYINT,
    data DATE,
    diagnostic VARCHAR(100),
    PRIMARY KEY (dniPac, codMetge, data),
    FOREIGN KEY (dniPac) REFERENCES hospital.pacient (dni) ON DELETE NO ACTION ON UPDATE CASCADE,
    FOREIGN KEY (codMetge) REFERENCES hospital.metge (codMetge) ON DELETE NO ACTION ON UPDATE CASCADE
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS hospital.realitzacio 
(
    codProv TINYINT, 
    dniPac CHAR(9),
    data DATE,
    resultat VARCHAR(100),
    PRIMARY KEY (codProv,dniPac, data),
    FOREIGN KEY (codProv) REFERENCES hospital.prova (codProv) ON DELETE NO ACTION ON UPDATE CASCADE,
    FOREIGN KEY (dniPac) REFERENCES hospital.pacient (dni) ON DELETE NO ACTION ON UPDATE CASCADE
) engine=InnoDB;

INSERT INTO hospital.area VALUES (1, 'Traumatologia'), 
                                 (2, 'Neurologia'),
                                 (3, 'Cardiologia'),
                                 (4, 'Oncologia');
 
INSERT INTO hospital.prova VALUES (1, 'Radiografia'), 
                                  (2, 'Ecografia'), 
                                  (3, 'Anàlisi sang'), 
                                  (4, 'Resonancia'), 
                                  (5, 'Tomografia');

INSERT INTO hospital.planta VALUES (1,10),
                                   (2,12); 

INSERT INTO hospital.llit VALUES (1,1), 
                                 (1,2), 
                                 (1,3), 
                                 (1,4), 
                                 (1,5), 
                                 (1,6), 
                                 (1,7), 
                                 (1,8), 
                                 (1,9), 
                                 (1,10),
                                 (2,1), 
                                 (2,2), 
                                 (2,3), 
                                 (2,4), 
                                 (2,5),                                  
                                 (2,6),                                  
                                 (2,7),                                  
                                 (2,8),                                  
                                 (2,9),                                  
                                 (2,10),                                  
                                 (2,11),                                  
                                 (2,12);                                  

INSERT INTO hospital.pacient VALUES ('11111111A', 'Marta', 'Garcia', '2014-03-01', 1, 1),
                                    ('22222222B', 'Antonio', 'Sanchez', '2014-03-01', 1, 2), 
                                    ('33333333C', 'Angel', 'Mari', '2014-03-05', 1, 3), 
                                    ('44444444D', 'Nuria', 'Mir', '2014-03-05', 1, 4), 
                                    ('55555555E', 'Berta', 'Garcia', '2014-03-10', 1, 5), 
                                    ('66666666F', 'Carme', 'Catalan', '2014-03-10', 1, 6), 
                                    ('77777777G', 'Laura', 'Maroto', '2014-03-12', 1, 7), 
                                    ('88888888H', 'Irene', 'Beltran', '2014-03-12', 1, 8), 
                                    ('99999999I', 'Joan', 'Catalan', '2014-03-15', 1, 9), 
                                    ('11111112A', 'Alexandra', 'Aran', '2014-03-15', 1, 10), 
                                    ('11111113B', 'Ferran', 'Beltran', '2014-03-20', 2, 1), 
                                    ('11111114C', 'Joan Carles', 'Montoro', '2014-03-20', 2, 2), 
                                    ('11111115D', 'Mar', 'Gimeno', '2014-04-01', 2, 3), 
                                    ('11111116E', 'Nuria', 'Gracia', '2014-04-05', 2, 4), 
                                    ('11111117F', 'Maria', 'Sanchez', '2014-04-10', 2, 5), 
                                    ('11111118G', 'Maria', 'Gimeno', '2014-04-12', 2, 6), 
                                    ('11111119H', 'Josep', 'Orteu', '2014-04-15', 2, 7), 
                                    ('22222223A', 'Josep', 'Gimeno', '2014-04-16', 2, 8), 
                                    ('22222224B', 'Carles', 'Sanchez', '2014-04-16', 2, 9), 
                                    ('22222225C', 'Carles', 'Mari', '2014-04-16', 2, 10); 

INSERT INTO hospital.metge VALUES (1,'Albert','Montagut', 50000.0, 1), 
                                  (2,'Laura','Sanchez', 55000.0, 1), 
                                  (3,'Nuria','Garcia', 55000.0, 2),
                                  (4,'Carles','Vila', 60000.0, 3),
                                  (5,'Andreu','Cases', 70000.0, 3),
                                  (6,'Albert','Comas', 70000.0, NULL);

INSERT INTO hospital.infermer VALUES (1,'Joan','Capdevila', 1), 
                                     (2,'Josep','Sanchez', 2), 
                                     (3,'Dolors','Perez', 3);


INSERT INTO hospital.visita VALUES ('11111111A',1,'2014-03-02','os trencat'), 
                                   ('11111111A',2,'2014-03-05','os trencat'), 
                                   ('22222222B',1,'2014-03-02','os trencat'), 
                                   ('22222222B',2,'2014-03-05','os trencat'), 
                                   ('33333333C',1,'2014-03-07','os trencat'), 
                                   ('33333333C',3,'2014-03-09','traumatisme craneal'), 
                                   ('44444444D',1,'2014-03-07','os trencat'), 
                                   ('44444444D',3,'2014-03-09','traumatisme craneal'), 
                                   ('55555555E',1,'2014-03-11','tendo trencat'), 
                                   ('66666666F',1,'2014-03-11','tendo trencat'),
                                   ('77777777G',2,'2014-03-13','os trencat'), 
                                   ('88888888H',2,'2014-03-13','tendo trencat'), 
                                   ('99999999I',2,'2014-03-18','os trencat'), 
                                   ('11111112A',2,'2014-03-18','tendo trencat'), 
                                   ('11111113B',3,'2014-03-22','traumatisme craneal'), 
                                   ('11111114C',3,'2014-03-22','traumatisme craneal'), 
                                   ('11111115D',3,'2014-04-02','traumatisme craneal'), 
                                   ('11111116E',3,'2014-04-07','traumatisme craneal'), 
                                   ('11111117F',4,'2014-04-13','aturada cardiaca'), 
                                   ('11111118G',4,'2014-04-13','baixada ritme cardiac'), 
                                   ('11111119H',4,'2014-04-17','aturada cardiaca'), 
                                   ('22222223A',4,'2014-04-19','baixada ritme cardiac'), 
                                   ('22222224B',4,'2014-04-19','baixada ritme cardiac'), 
                                   ('22222225C',4,'2014-04-19','aturada cardiaca');


INSERT INTO hospital.realitzacio VALUES (1,'11111111A','2014-03-05','Fractura radio'),
                                        (1,'22222222B','2014-03-06','Fractura cubito'),
                                        (1,'33333333C','2014-03-08','Fractura radio'),
                                        (1,'44444444D','2014-03-10','Fractura cubito'),
                                        (1,'55555555E','2014-03-13','Fractura radio'),
                                        (3,'11111111A','2014-03-05','Parametres en els marges correctes'),
                                        (3,'22222222B','2014-03-06','Parametres en els marges correctes'),
                                        (3,'33333333C','2014-03-09','Hematies baixos'),
                                        (3,'44444444D','2014-03-10','Parametres en els marges correctes'),
                                        (3,'55555555E','2014-03-14','Hematies baixos');
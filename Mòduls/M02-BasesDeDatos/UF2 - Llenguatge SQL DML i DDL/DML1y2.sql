USE plantes;
#!Exercici 23
SELECT nom_popular nom_popular ,nom_cientific nom, floracio estacio_de_floracio FROM planta WHERE floracio='Estiu';
#!Exercici 24
SELECT nom_cientific, nom_adob FROM planta, adob WHERE nom_adob='Casadob';
#Exercici 25
SELECT nom_adob, nom_firma,tipus_adob FROM adob WHERE nom_firma='PRISADOB';
#!Exercici 26
SELECT nom_planta, temperatura FROM planta_interior WHERE temperatura>16;
#!Exercici 27
SELECT SUM(quantitat_adob) FROM dosi_adob;
#!Exercici 28
SELECT DISTINCT nom_planta, quantitat_adob FROM dosi_adob
WHERE quantitat_adob BETWEEN 40 AND 50;
#!Exercici 47
SELECT CONCAT(nom_popular, '(',quantitat_adob,')') nom_popular, quantitat_adob FROM planta, dosi_adob, adob WHERE (nom_firma='UOCADOB')AND(nom_cientific=nom_planta) 
AND(nom_adob);
#!Exercici 48
#!Exercici 49
SELECT nom_cientific, LEFT(nom_popular,5), metode_reproduccio, grau_exit FROM planta, reproduccio, planta_interior, planta_exterior
WHERE (metode_reproduccio='Esqueix' AND nom_planta=nom_cientific AND nom_cientific=nom_planta) 
OR (grau_exit='Baix' AND nom_planta=nom_cientific AND nom_cientific=nom_planta);
#!Exercici 64
SELECT nom_cientific, temperatura FROM planta, planta_interior
WHERE temperatura= (SELECT MAX(temperatura) FROM planta_interior) - 1
ORDER BY temperatura DESC;
#!Exercici 68 Mostra el nom popular i la quantitat d’adob, ordenat per aquesta quantitat, de les plantes que no reben el màxim
#!ni el mínim d’adob.
SELECT nom_popular, quantitat_adob FROM planta, dosi_adob
WHERE quantitat_adob != (SELECT MIN(quantitat_adob) FROM dosi_adob)
AND quantitat_adob != (SELECT MAX(quantitat_adob) FROM dosi_adob);
#!Exercici 69
SELECT nom_cientific FROM planta
WHERE nom_popular LIKE 'C%' AND floracio= 'Primavera';
#!Exercici 70
SELECT nom_cientific, nom_adob FROM planta, dosi_adob
WHERE nom_adob != 'Casadob';
#!Execució
SELECT nom_cientific FROM planta WHERE nom_cientific NOT IN (SELECT nom_planta FROM dosi_adob WHERE nom_adob="Casadob");
#!Muestra que plantas tenemos ejemplar y han añadido la menor cantidad de abono.
SELECT DISTINCT ep.nom_planta FROM exemplar_planta ep,dosi_adob da,planta 
WHERE ep.nom_planta=nom_cientific AND nom_cientific=ep.nom_planta AND quantitat_adob= (SELECT MIN(quantitat_adob) FROM dosi_adob);
#!Mostreu el nom científic de les plantes que no reben adob a la primavera.
SELECT DISTINCT p.nom_cientific, nom_estacio FROM dosi_adob, planta p 
WHERE nom_estacio NOT IN (SELECT nom_estacio FROM dosi_adob WHERE nom_estacio = "Primavera");
#!La mateixa consulta anterior, però mostreu el nom popular.
SELECT DISTINCT p.nom_popular, nom_estacio FROM dosi_adob, planta p 
WHERE nom_estacio NOT IN (SELECT nom_estacio FROM dosi_adob WHERE nom_estacio = "Primavera");
#!Mostreu quines plantes (nom científic) reben una dosi d'adob per sobre de la mitjana de totes les dosis administrades.
SELECT DISTINCT nom_planta, quantitat_adob 
FROM dosi_adob WHERE quantitat_adob > (SELECT AVG(quantitat_adob) FROM dosi_adob);
#!Mostreu el nom popular de les plantes que reben la mateixa quantitat d'adob que la mitjana de totes les dosis administrades.
SELECT DISTINCT nom_popular 
FROM planta, dosi_adob WHERE quantitat_adob = (SELECT AVG(quantitat_adob) FROM dosi_adob) AND nom_planta=nom_cientific;	
#!Mostreu el nom popular de la planta que tenim més exemplars.
SELECT DISTINCT p.nom_popular
FROM planta p, exemplar_planta ep 
WHERE p.nom_cientific = ep.nom_planta AND ep.num_exemplar = (SELECT MAX(num_exemplar) FROM exemplar_planta);
#!GROUP BY Función.
SELECT nom_planta, SUM(quantitat_adob) FROM dosi_adob
GROUP BY nom_planta;
#!GROUP BY Función patrón empieza el nombre por C.
SELECT nom_planta, SUM(quantitat_adob) FROM dosi_adob
WHERE nom_planta LIKE ('C%')
GROUP BY nom_planta;
#!72 Mostra la quantitat de plantes que utilitzen cada firma comercial d’adob.
SELECT nom_adob, COUNT(nom_planta) FROM dosi_adob
GROUP BY nom_adob;
#!73 Mostra el nom popular de les plantes que se les abona tres o més vegades a l’any. Mostra també el nombre de
#!vegades que se les abona, ordenats primer per aquest nombre i després pel nom.
SELECT nom_popular, COUNT(*) FROM dosi_adob, planta
WHERE nom_cientific=nom_planta
GROUP BY nom_popular
 HAVING COUNT(*) >= 3
 ORDER BY COUNT(*), nom_popular;
#!74 Mostra el nom de les plantes i la quantitat total d’adob, ordenat en ordre invers, de les plantes que utilitzen una
#!quantitat d’adob entre 60 i 90 (inclosos).
SELECT nom_planta, SUM(quantitat_adob) FROM dosi_adob
WHERE quantitat_adob >= 60 AND quantitat_adob <= 90
GROUP BY nom_planta
ORDER BY quantitat_adob DESC;
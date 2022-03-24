USE hospital;
#! 1 Mostra per a cada àrea el número total d'infermes i el total de metges que té.
SELECT a.nomArea, COUNT(m.numArea) as Metges, COUNT(i.numArea) as Infermer FROM area a, metge m, infermer i
WHERE a.numArea = m.numArea AND a.numArea = i.numArea
GROUP BY a.nomArea;

SELECT a.nomArea, COUNT(m.numArea) as Metge, "Metges" as Carrec FROM area a, metge m
WHERE a.numArea = m.numArea 
GROUP BY a.nomArea
UNION SELECT a.nomArea, COUNT(i.numArea) as Infermer, "Infermers" FROM area a, infermer i 
WHERE a.numArea = i.numArea
GROUP BY a.nomArea;

#! 2 Mostra quin ha sigut el diagnòstic més freqüent durant el mes de març.
SELECT v.diagnostic, COUNT(v.diagnostic) FROM visita v WHERE month(v.data) = "03"
GROUP BY v.diagnostic
ORDER BY COUNT(*) DESC LIMIT 1;

#! 3 Mostra el pacient i el número de proves que s'ha fet, el pacient que més visities ha tingut.
SELECT p.nom, p.cognoms, COUNT(r.dniPac) as proves, r.dniPac FROM pacient p, realitzacio r 
WHERE p.dni = r.dniPac 
	AND p.nom = (SELECT p.nom, p.cognoms, COUNT(v.dniPac) as visites, v.dniPac FROM pacient p, visita v
	WHERE v.dniPac = p.dni
	GROUP BY v.dniPac
	ORDER BY COUNT(*) DESC LIMIT 1)
GROUP BY r.dniPac;

SELECT p.nom, p.cognoms, COUNT(v.dniPac) as visites, v.dniPac FROM pacient p, visita v
WHERE v.dniPac = p.dni
GROUP BY v.dniPac
ORDER BY COUNT(*) DESC LIMIT 1;


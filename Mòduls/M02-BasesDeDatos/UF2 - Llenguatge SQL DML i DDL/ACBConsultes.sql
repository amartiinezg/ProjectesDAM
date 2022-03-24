USE acb;
#!90 Mostra el nom de l’equip, el pavelló i el seu president dels equips que tenen un aforament per sota la mitjana;
SELECT e.nom, es.nom, d.nom, carrec FROM equip e, directiu d, estadi es, membre_equip me
WHERE es.nom = e.estadi AND e.nom = me.equip AND me.nom = d.nom
AND carrec = "President" AND es.aforament < (SELECT AVG(aforament) FROM estadi);
#!91 Mostra el nom dels àrbitres que han arbitrat més d’un partit que ha guanyat l’equip de casa.
SELECT ar.arbitre, p.punts_local FROM arbitra ar, partit p
WHERE ar.jornada = p.jornada AND p.equip_local = ar.equip_local
AND p.punts_local > p.punts_visitant
GROUP BY ar.arbitre
	HAVING COUNT(ar.arbitre) > 1;
#! 92 Trobar el nom de l’equip, el nom dels jugadors i el nom de l’entrenador dels equips que han guanyat com a
#!mínim dos partits fora de casa. (NO ACABAT!)
SELECT j.nom, me.equip, e.nom as entrenador FROM membre_equip me,jugador j, entrenador e, equip eq, partit p
WHERE me.nom = j.nom AND me.equip = eq.nom AND p.punts_visitant > p.punts_local
GROUP BY j.nom, eq.nom
ORDER BY eq.nom;
#!
SELECT p.equip_visitant, en.nom, "entrenador" FROM partit p, equip e, membre_equip me, entrenador en
WHERE p.punts_visitant > p.punts_local AND p.equip_visitant = e.nom AND e.nom = me.equip AND me.nom = en.nom
GROUP BY p.equip_visitant
	HAVING COUNT(*)>=2
UNION SELECT p.equip_visitant, j.nom, "jugador" FROM partit p, equip e, membre_equip me, jugador j
WHERE p.punts_visitant > p.punts_local AND p.equip_visitant = e.nom AND e.nom = me.equip AND me.nom = j.nom
GROUP BY p.equip_visitant, j.nom
	HAVING COUNT(*)>=2;
#! 93 Mostra el nom i el president dels equips que han aconseguit una puntuació com a visitants superior a la mitjana
#! dels equips que han jugat fora.
SELECT e.nom as Equip, d.nom as President FROM equip e, membre_equip me, directiu d, partit p
WHERE e.nom = me.equip AND me.nom = d.nom AND e.nom = equip_visitant 
AND carrec = "President" AND p.punts_visitant > (SELECT AVG(punts_visitant) FROM partit);
#! 94 Mostra el nom i la posició on juga dels jugadors que són entrenadors a la vegada. Mostra també l’equip on juga i
#! ordena-ho tot per l’equip i pel nom del jugador.
SELECT j.nom, j.posicio, e.nom as Equip FROM jugador j, equip e, entrenador en, membre_equip me WHERE j.nom = me.nom AND me.nom = en.nom
AND me.equip = e.nom ORDER BY e.nom, j.nom;
#! 95 Mostra el nom i l’equip de tots els membres d’algun equip que el seu cognom és Brunet.
SELECT me.nom, me.equip FROM membre_equip me WHERE me.nom LIKE '%Brunet%';
#! 96 Mostra el nom i l’equip al que pertanyen de les persones que són directius però no són presidents.
SELECT me.nom, me.equip FROM membre_equip me, directiu d WHERE me.nom = d.nom AND d.carrec <> "President";
#! 97 Mostra la quantitat de fitxes que tenim de cada equip.
SELECT COUNT(j.fitxa) as numero_fitxes, me.equip FROM jugador j, membre_equip me WHERE j.nom = me.nom
GROUP BY me.equip;
#! 98 Mostrar dels equips que han guanyat alguna vegada fora de casa el total de punts que tenen com a visitants.
SELECT equip_visitant as equip, SUM(punts_visitant) as suma_punts_visitant FROM partit WHERE punts_visitant > punts_local
GROUP BY equip_visitant;
#! 99 Mostra la quantitat de punts obtinguts per cada equip jugant com a local.
SELECT equip_local as equip, SUM(punts_local) as suma_punts_local FROM partit GROUP BY equip_local;
#! 100 Digues el nom i l’equip on juguen dels jugadors que tenen una fitxa superior al número 400.
SELECT j.nom, me.equip FROM jugador j, membre_equip me WHERE fitxa > '400' AND me.nom = j.nom;
#! 101 De l’exercici anterior ordena els equips en ordre ascendent i digues quantes fitxes té cada equip.
SELECT me.equip, COUNT(j.fitxa) as numero_fitxes FROM jugador j, membre_equip me WHERE fitxa > '400' AND me.nom = j.nom
GROUP BY me.equip
ORDER BY me.equip ASC;
#! 102 Mostra el nom dels equips que tenen el pressupost més alt.
SELECT e.nom, MAX(e.pressupost) FROM equip e;
#! 103 Digues el nom dels àrbitres que han nascut a Olot i també els que porten més de 5 anys arbitrant.
SELECT a.nom, a.antiguitat FROM arbitre a WHERE ciutat_naixement = 'Olot' AND year(now()) - a.antiguitat > 5;
#! 104 Mostra la màxima diferència que s’ha produït en un partit.
SELECT p.equip_local, p.punts_local, p.equip_visitant, p.punts_visitant, MAX(ABS(p.punts_local - p.punts_visitant)) as diferencia
FROM partit p;
#! 105 Mostra el nom i el pressupost dels equips que són filials d’un altre. Mostra també a la mateixa línia el nom i el
#! pressupost del seu equip “pare”.
SELECT e.nom, e.pressupost, e.filial_de FROM equip e WHERE e.filial_de <> 'Null' AND equip_pare = e.filial_de
UNION SELECT e.filial_de as equip_pare, e.pressupost FROM equip e WHERE e.filial_de <> 'Null';
SELECT e.filial_de as equip_pare, pressupost FROM equip e WHERE e.filial_de <> 'Null';
#! 106 Mostra la mitjana d’anys que porten els àrbitres arbitrant.
SELECT a.nom, year(now())-a.antiguitat as anys FROM arbitre a;


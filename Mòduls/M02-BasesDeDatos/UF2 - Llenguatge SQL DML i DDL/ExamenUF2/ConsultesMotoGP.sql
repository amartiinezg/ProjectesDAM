USE motogp;
#! 1 Mostra quins pilots no han pujat mai al podium (1a, 2a i 3a posició).
SELECT p.nombre FROM pilotos p, resultados r WHERE p.codigo = r.codpiloto AND r.puesto > 3
group by p.nombre;
#! 2 Mostra quins pilots, i en quina cursa, han quedat en última posició (sense tenir en compte els abandonaments).
SELECT p.nombre, c.nombrecircuito, c.año, r.puesto FROM pilotos p, resultados r, carreras c WHERE p.codigo = r.codpiloto AND r.nombregp = c.nombregp AND r.anyo = c.año
AND r.puesto = 5
ORDER BY r.puesto DESC;
#! 3 Mostra el dissenyador, en el cas de què es sàpiga, del circuit amb major longitud.
SELECT c.nombre, c.disenyador, MAX(c.longitud) FROM circuitos c;
#! 4 Mostra el nom dels pilots i la seva escuderia d'aquells que han quedat primers més d'un cop.
SELECT p.nombre, e.nombre as Escuderia FROM pilotos p, escuderias e, resultados r 
WHERE e.nombre = p.nombreescuderia AND p.codigo = r.codpiloto AND r.puesto = 1
GROUP BY p.nombre
 HAVING COUNT(r.puesto) > 1;
 #! 5 Mostra el nom dels pilots, majors de 30 anys, que no han guanyat cap cursa (posició 1a) en el 2011.
 SELECT DISTINCT p.nombre FROM pilotos p, resultados r
 WHERE year(now()) - year(p.fechanacimiento) > 30 
 AND r.codpiloto = p.codigo AND r.anyo = 2011 AND 
 p.nombre NOT IN (SELECT p.nombre FROM pilotos p, resultados r WHERE r.puesto = 1 AND r.codpiloto = p.codigo AND r.anyo = 2011)
 ORDER BY r.puesto ASC;
 #! 6 Mostra els circuits en els quals no ha guanyat cap pilot espanyol.
 SELECT DISTINCT nombrecircuito FROM carreras
 where nombrecircuito NOT IN (SELECT c.nombrecircuito FROM pilotos p, resultados r, carreras c
 WHERE r.nombregp = c.nombregp AND r.anyo = c.año AND p.codigo = r.codpiloto AND p.nacionalidad = 'Española' AND r.puesto = 1);
 
 SELECT r.nombregp, p.codigo, c.nombrecircuito, p.nacionalidad FROM pilotos p, resultados r, carreras c
 WHERE p.codigo = r.codpiloto AND r.nombregp = c.nombregp AND r.anyo = c.año AND
 p.nacionalidad = 'Española' AND r.puesto = 1;
 
 #---------------------------------------------------------------
 #       EXAMEN
 
# 1 Mostra el nom dels pilots, de les escuderies amb seu a Itàlia, i que hagin guanyat més d'una carrera.
SELECT DISTINCT p.nombre, e.nombre as Escuderia, e.sede FROM pilotos p, escuderias e, resultados r 
WHERE e.nombre = p.nombreescuderia AND p.codigo = r.codpiloto AND e.sede LIKE '%Italia%';
# 2 Mostra els pilots, i les seves corresponents escuderies, i el nombre de carreres guanyades, d'aquells pilots que han guanyat més d'una carrera celebrada a partir de les 15:00h
SELECT p.nombre, e.nombre as Escuderia FROM pilotos p, escuderias e, resultados r, carreras c
WHERE e.nombre = p.nombreescuderia AND p.codigo = r.codpiloto AND r.nombregp = c.nombregp AND r.anyo = c.año
AND hour(c.fechahorarioinicio) >= 15 AND r.puesto = 1
GROUP BY p.nombre
	HAVING COUNT(*) > 1;
# 3 Mostra el número de pilots de cada escuderia, incloent les que no tnguin cap ---- FALTA LES QUE NO TINGUIN CAP
SELECT e.nombre as Escuderia, COUNT(p.codigo) as Pilotos FROM pilotos p, escuderias e 
WHERE e.nombre = p.nombreescuderia GROUP BY e.nombre;

# 4 Mostra el nombre de carreres guanyades en 2010 per cada pilot, ordenades de major a menor, incloent els pilots que no han guanyat cap. -------- FALTA ELS QUE NO HAN GUANYAT CAP
SELECT p.nombre, COUNT(r.puesto) as Guanyades FROM pilotos p, resultados r, carreras c 
WHERE p.codigo = r.codpiloto AND r.nombregp = c.nombregp AND r.anyo = c.año AND r.puesto = 1
AND r.anyo = 2010
GROUP BY p.nombre;

# 5 Mostra el nom i l'any de debut (solament l'any) del pilot que ha guanyat més grans premis.
SELECT p.nombre, RIGHT(p.carreradebut, 5) as Debut, COUNT(r.puesto) as Premis FROM pilotos p, resultados r WHERE p.codigo = r.codpiloto
AND r.puesto = 1
GROUP BY p.nombre
ORDER BY COUNT(*) DESC LIMIT 1;

# 6 Mostra el nom dels pilots que han arribat en més de 10 segons de diferència del guanyador en la cursa del 2010 que s'han recorregut menys voltes. # FALTA CONDICIÓ DEL NOM DELS PILOTS QUE HAN ARRIBR EN MÉS DE 10 SEGONS
SELECT p.nombre, c.nombrecircuito, r.distanciaganador FROM pilotos p, resultados r, carreras c WHERE p.codigo = r.codpiloto AND r.nombregp = c.nombregp AND r.anyo = c.año
AND c.año = 2010 AND c.numvueltas = (SELECT MIN(c.numvueltas) FROM carreras c);

# 7 Mostra amb quina/es quines escuderia/es s’han guanyat més curses
SELECT e.nombre, COUNT(r.puesto) as Guanyades FROM escuderias e, pilotos p, resultados r WHERE e.nombre = p.nombreescuderia AND p.codigo = r.codpiloto
AND r.puesto = 1
GROUP BY e.nombre;
 
 # 8 Mostra quina nacionalitat/s hi ha més pilots.
 SELECT p.nacionalidad, COUNT(p.nacionalidad) as Pilotos FROM pilotos p
 GROUP BY p.nacionalidad
 ORDER BY COUNT(*) DESC LIMIT 2;
 
 # 9 Explica quines dades mostra la següent consulta:
select distinct c.nombrecircuito from resultados r, carreras c
where (r.nombregp=c.nombregp) and (c.año=r.anyo) and (r.puesto=1) and r.codpiloto NOT IN (select codigo from pilotos
where nacionalidad='Española');
 
-- Ejercicio 1 
SELECT (apellidos || ', ' || nombre) AS nombre_alumno, max_nota 
FROM (
    SELECT a.apellidos, a.nombre, MAX(aa.nota) AS max_nota
    FROM alumnos a
    JOIN alumnos_asignaturas aa ON (a.id = aa.id_alumno)
    GROUP BY a.apellidos, a.nombre
    ORDER BY MAX(aa.nota) DESC
)
WHERE ROWNUM <= 5;
--2 formas
WITH notamax as (SELECT a.apellidos, a.nombre, MAX(aa.nota) AS max_nota
    FROM alumnos a
    JOIN alumnos_asignaturas aa ON (a.id = aa.id_alumno)
    GROUP BY a.apellidos, a.nombre
    ORDER BY MAX(aa.nota) DESC)
select * from notamax 
where rownum <=5;




--Ejercicio 2
WITH Edad as (select 
    a2.id as id_alumno,
    TRUNC(MONTHS_BETWEEN(SYSDATE,a2.fecha_nacimiento)/12)as edad
    from alumnos a2)
select a.nombre NOMBRE, a.apellidos APELLIDOS, (e.edad ||' AÑOS') EDAD
from alumnos a
join Edad e on (a.id=e.id_alumno)
order by e.edad asc;


--Ejercicio 3 
SELECT 
  c.titulo,REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(c.artista, 'a', 'A'),'e', 'E'),'i', 'I'),'o', 'O'),'u', 'U') AS Artista
FROM canciones c
LEFT JOIN alumnos_canciones ac ON c.id = ac.id_cancion
WHERE ac.id_cancion IS NULL
ORDER BY titulo DESC;




--Ejercicio 4 

SELECT p.nombre AS profesor,p.titulacion,asig.nombre AS asignatura,
COUNT(CASE WHEN aa.nota >= 5 THEN 1 ELSE NULL END) AS aprobados
FROM profesores p
JOIN profesores_centros_asignaturas pca ON (p.id = pca.id_profesor)
JOIN asignaturas asig ON (pca.id_asignatura = asig.id)
JOIN alumnos a ON (a.id_centro = pca.id_centro)
JOIN alumnos_asignaturas aa ON (aa.id_alumno = a.id) AND (aa.id_asignatura = asig.id)
GROUP BY p.nombre, p.titulacion, asig.nombre
ORDER BY p.nombre;




-- EJERCICIO 5: Vista profesores con doctorado fuera de Madrid

CREATE OR REPLACE VIEW vista_profesores_doctorado_fuera_madrid AS
SELECT nombre, titulacion
FROM profesores
WHERE LOWER(titulacion) LIKE 'doctor%' OR LOWER(titulacion) LIKE 'doctora%'

EXCEPT

SELECT DISTINCT p.nombre, p.titulacion
FROM profesores p
JOIN profesores_centros_asignaturas pca ON p.id = pca.id_profesor
JOIN centros c ON c.id = pca.id_centro
WHERE LOWER(c.localidad) = 'madrid';
    
-- Consultar la vista con ordenación por longitud del nombre
SELECT *
FROM vista_profesores_doctorado_fuera_madrid
ORDER BY LENGTH(nombre);






--Ejercicio 6
WITH top_canciones AS (
  SELECT 
    a.id AS id_alumno,
    a.nombre || ' ' || a.apellidos AS alumno,
    c.titulo,
    c.artista,
    RANK() OVER (PARTITION BY a.id ORDER BY ac.reproducciones DESC) AS ranking
  FROM alumnos a
  JOIN alumnos_canciones ac ON ac.id_alumno = a.id
  JOIN canciones c ON c.id = ac.id_cancion
),
suspensos AS (
  SELECT 
    a.id AS id_alumno,
    NVL(
      LISTAGG(asig.nombre, ', ') 
        WITHIN GROUP (ORDER BY asig.nombre),
      '<NINGUNA>'
    ) AS suspendidas
  FROM alumnos a
  LEFT JOIN alumnos_asignaturas aa 
    ON aa.id_alumno = a.id AND (aa.nota < 5 OR aa.nota IS NULL)
  LEFT JOIN asignaturas asig ON asig.id = aa.id_asignatura
  GROUP BY a.id
),
top_canciones_pivot AS (
  SELECT 
    id_alumno,
    alumno,
    MAX(CASE WHEN ranking = 1 THEN titulo || ' , ' || artista END) AS top_1,
    MAX(CASE WHEN ranking = 2 THEN titulo || ' , ' || artista END) AS top_2,
    MAX(CASE WHEN ranking = 3 THEN titulo || ' , ' || artista END) AS top_3
  FROM top_canciones
  WHERE ranking <= 3
  GROUP BY id_alumno, alumno
)
SELECT 
  t.alumno,
  s.suspendidas,
  t.top_1,
  t.top_2,
  t.top_3
FROM top_canciones_pivot t
LEFT JOIN suspensos s ON s.id_alumno = t.id_alumno
ORDER BY t.alumno;
































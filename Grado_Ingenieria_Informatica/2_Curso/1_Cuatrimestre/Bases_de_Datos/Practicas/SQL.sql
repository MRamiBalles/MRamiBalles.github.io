--Ej. 1)

CREATE TABLE COMPAÑÍA (
  cif char (9) NOT NULL,
  nombre varchar (20),
  web varchar (30),
  CONSTRAINT ClaveComp PRIMARY KEY (cif)
);

-------------------------------------------------------------
--Ej. 2)

CREATE TABLE TARIFA (
  tarifa char (10) NOT NULL,
  compañia char (9) NOT NULL,
  descripcion varchar (50),
  coste number (3,2),
  CONSTRAINT ClaveTarifa PRIMARY KEY (tarifa, compañia),
  CONSTRAINT ClaveAjenaTarifa FOREIGN KEY (compañia)
    REFERENCES COMPAÑÍA (cif) ON DELETE CASCADE
);

--------------------------------------------------------------
--Ej. 3)

CREATE TABLE CLIENTE (
  dni char (9) NOT NULL,
  nombre varchar(50),
  f_nac date,
  direccion varchar(100),
  cp char(6),
  ciudad varchar(50),
  provincia varchar(50),
  CONSTRAINT ClaveCliente PRIMARY KEY (dni)
);

--------------------------------------------------------------
--Ej. 4)

CREATE TABLE TELEFONO (
  numero char (9),
  f_contrato date,
  tipo char (1),
  puntos number (6, 0),
  compañia char (9),
  tarifa char (10),
  cliente char (9),
  CONSTRAINT ClaveTelef PRIMARY KEY (numero),
  CONSTRAINT TfTarifaAjena FOREIGN KEY (tarifa, compañia)
    REFERENCES TARIFA,
  CONSTRAINT TfCompañiaAjena FOREIGN KEY (compañia)
    REFERENCES COMPAÑÍA (cif),
  CONSTRAINT TfClienteAjena FOREIGN KEY (cliente)
    REFERENCES CLIENTE (dni),
    CONSTRAINT TfTipo CHECK (tipo IN ('T', 'C'))
);


-------------------------------------------------------------
--Ej. 5)

CREATE TABLE LLAMADA (
  tf_origen char (9),
  tf_destino char (9),
  fecha_hora TIMESTAMP,
  duracion number(5,0),
  CONSTRAINT ClaveLlamada PRIMARY KEY (tf_origen, fecha_hora),
  CONSTRAINT LlamadaTfAjena FOREIGN KEY (tf_origen)
    REFERENCES TELEFONO (numero),
  CONSTRAINT LlamadaTfDestAjena FOREIGN KEY (tf_destino)
    REFERENCES TELEFONO (numero),
  CONSTRAINT LlamadaDestUnica UNIQUE (tf_destino, fecha_hora)  
  );
  
  
----------------------------------------------------------------
--Ej. 6) Modificación de tablas

ALTER TABLE COMPAÑÍA
  add CONSTRAINT nombre_unico UNIQUE (nombre);
  
 -- desc COMPAÑÍA;
  
  --select (?)
  
---------------------------------------------------------------------

ALTER TABLE LLAMADA
  add CONSTRAINT TfDistintos CHECK (tf_origen <> tf_destino);

----------------------------------------------------------------------

ALTER TABLE TARIFA 
  add CONSTRAINT LimiteCoste CHECK (coste <= 1.50 and coste >= 0-05);
  
----------------------------------------------------------------------

ALTER TABLE COMPAÑÍA
  modify nombre NOT NULL;
  
ALTER TABLE CLIENTE
  modify nombre NOT NULL;
  
ALTER TABLE TARIFA
  modify coste NOT NULL;
  
ALTER TABLE COMPAÑÍA
  modify nombre NOT NULL;
  
ALTER TABLE TELEFONO
  modify compañia NOT NULL;
  
ALTER TABLE TELEFONO
  modify tarifa NOT NULL;

desc TELEFONO;

ALTER TABLE LLAMADA
  modify duracion NOT NULL;

desc LLAMADA;


------------------------------------------------------------------------------

--Ej. 8) Inserción de valores

insert into COMPAÑÍA values ('A00000001', 'Reiser Company', 'http:://www.reiser.com');
insert into COMPAÑÍA values ('B00000002', 'Jonas Company', 'http:://www.jonas.com');
select * from COMPAÑÍA;

-------------------------------------------

insert into TARIFA values ('joven', 'A00000001', 'Menores de 25 años', 0.25);
insert into TARIFA values ('dúo', 'A00000001', 'La pareja también está en la compañía', 0.20);
insert into TARIFA values ('familiar', 'A00000001', '4 miembros de la familia en la compñía', 0.1);
insert into TARIFA values ('autónomo', 'B00000002', 'Trabajador autónomo', 0.12);
insert into TARIFA values ('dúo', 'B00000002', 'La pareja también está en la compañía', 0.15);
select * from TARIFA;











--Práctica 3:

--Ej.1.a) 
desc ei.asignatura
select idasif, nombre, esp
from ei.asignatura
where curso=3 and créditos>4.5

--1.b)

select A.idasig as Código, nombre, esp as Especialidad
from ei.asignatura A
where A.curso=3 and A.créditos>4.5

--Ej. 2)

desc ei.ordenador
select distinct tipo from ei.ordenador

--Ej. 3)

desc ei.alumno
select nombre, nh, nh*300 as Descuento
from ei.alumno
order by Descuento DESC, nombre ASC;

--Ej. 4)

select A.dni, A.nombre, A.fechanac, a.lugar
from ei.alumno A
where a.fechanac between '01/01/1970' and '31/12/1974'
--where EXTRACT(year FROM A.fechanac) between 1970 and 1974
and A.lugar in ('Huelva', 'Cádiz')

--Ej. 5)

select A.nombre, A.dni, A.lugar
from ei.alumno A
where A.nombre like 'M%'
and A.lugar not like 'P%' and A.lugar like '_____%'


--Ej. 6)

select to_char(fecha_hora, 'dd/mm/yyyy') Fecha, to_char(fecha_hora, 'hh:mi,ss') Hora
from mf.llamada
where to_char(fecha_hora, 'hh:mi') between '01:00' and '02:00'
order by Fecha, Hora;


--Ej. 7)

select to_char(fecha_hora, 'hh24:mi') Horas, EXTRACT(hour FROM fecha_hora) Hora, EXTRACT(minute FROM fecha_hora) Minutos
from mf.llamada
where to_char(fecha_hora, 'dd/mm/yyyy') = '01/10/2006'
order by Hora;

--Ej. 8)

select disctinct extract(year from a.fechnac) as AñoNac
from ei.alumno A
order by AñoNac

--Ej.9)

select * from MF."COMPAÑIA" C
where C.nombre like '%et%'
and C.web like '%com'


--Ej 10) Creo que mal!

select c.nombre, c.direccion, extract(year from (c.f_nac)) as FechaNac, c.cp
from MF.cliente c
where extract(year from (c.f_nac)) in (1973, 1985)
and c.cp like '15%'
order by c.nombre ASC, c.direccion DESC;

--Ej. 11)

select l.tf_origen, l.tf_destino, l.fecha_hora, extract(year from fecha_hora) as AñoLLamada
from MF.llamada l
where l.tf_origen = '666010101';

--Ej. 12)



--Práctica 4:
--Interseccion-> Inner join (filas de A que se combinan con B):
select * from empleados;
select * from departamentos;

select * from empleados A 
  inner join departamentos B
    on A.dpto_id = B.dpto_id;

--Left join: Todo A, incluso la intersección con B (También Right Join para todas las filas de B que no se combinan con A):

select * from empleados;
select * from departamentos;

select * from empleados A 
  left join departamentos B
  on A.dpto_id = B.dpto_id;

--Full outer join (A U B):

select * from empleados A 
  full outer join departamentos B
  on A.dpto_id = B.dpto_id;

--Condicion con null para obtener A - A inter B (o left si B - B inter A):
select * from empleados A 
  left join departamentos B
  on A.dpto_id = B.dpto_id;
  where B.dpto_id IS NULL

--Full outer join con condiciones para obtener AUB - A inter B
select * from empleados A 
  full outer join departamentos B
  on A.dpto_id = B.dpto_id;
  where A.dpto_id IS NULL or
  where B.dpto_id IS NULL

--Ej: Obtener nombres de asignaturas y profesores responsables:

desc EI.ASIGNATURA;
desc ei.profesor;

select A.NOMBRE as Asignatura, B.NOMBRE as Profesor from EI.ASIGNATURA A 
  inner join EI.PROFESOR B
    on A.PROF = B.NPR;

--Numeros de alumnos que se han matriculado en BDI en 2002-2003:

desc EI.MATRICULA;
desc EI.ASIGNATURA;

select alum from EI.MATRICULA M 
  inner join EI.ASIGNATURA A
   USING (idAsig)
   where A.nombre = 'Bases de Datos I' and año=2002; 


--Incompleto:
desc EI.MATRICULA;
desc EI.ASIGNATURA;
desc EI.ALUMNO;

select A.nombre from (EI.MATRICULA M
  inner join EI.ASIGNATURA ASIG
  USING (idasig))
  inner join  EI.ALUMNO A
  on M.alum=A.nAl
  where A.nombre='Algoritmos y Estructuras de Datos I'
  and M.año=2001
  and M.feb_jun =5;

--Consulta:
select * from ei.profesor P1
  inner join EI.PROFESOR P2
  using (despacho)
  where p1.nombre <> p2.nombre
  order by despacho;
--Resultado:
select distinct despacho from ei.profesor P1
  inner join EI.PROFESOR P2
  using (despacho)
  where p1.nombre <> p2.nombre
  order by despacho;

OJO (repite las soulciones!!!!):
select P1.DESPACHO from ei.profesor P1
  inner join EI.PROFESOR P2
  on p1.despacho = p2.despacho
  and p1.npr <> p2.npr;


--Responsable o docente Dolores Toscano:

desc ei.asignatura;
desc ei.profesor;

select a.nombre from ei.asignatura a
  inner join ei.profesor p
  on a.prof=p.npr
  where p.nombre='Dolores Toscano Barriga'
union
select a.nombre from (ei.asignatura a
  inner join ei.matricula m
  using (idasig))
  inner join ei.profesor p
  on m.prof=p.npr
  where p.nombre='Dolores Toscano Barriga';



--Incompleto:
select a.NOMBRE, m.año, m.dic, m.FEB_JUN, m.SEP from (ei.asignatura a
  inner join ei.matricula m
  using (idasig))
  inner join ei.alumno al
  on m.alum=al.nal
  where a.nombre='Bases de datos I'

--mf:
select * from mf.tarifa;
--Observamos que las tarifas con la palabra compañía en su descripción son las que nos interesa filtrar:
select tar.tarifa, tar.coste, cia.nombre
from mf.compañia cia inner join mf.tarifa tar....



select tel.numero, cli.nombre, tel.tipo, tar.coste
from (mf.cliente cli inner join mf.telefono tel on cli.dni=tel.cliente)
--...


--Práctica 5 (Consultas anidadas):

Select * from emple
where cargo in (select cargo from emple
where dept_no=20);
--In es equivalente a =Any (sinónimo de =some)
--=All -> El valor comparado es igual a todos los valores devueltos por la subconsulta.


--Ej 1:
select nombre from ei.alumno
  where lugar = (select lugar from ei.alumno
  where nombre='Samuel Toscano Villegas')
  and nh=(select nh from ei.alumno
  where nombre='Beatriz Rico Vázquez');


--Ej 2:
--Primera consulta.
select nombre from (ei.alumno al inner join EI.MATRICULA mat 
  on mat.al=al.NAL)
  inner join ei.asignatura a using (a.IDASIG)
  
select idasig, asig.nombre, mat.alumno 
from (ei.asignatura asig inner join EI.MATRICULA mat using (asig.IDASIG))
where asig.nombre='Bases de Datos II');

--Solución:
select alum.nombre 
from ei.alumno alum
where alum.nal in......

Ej 3:

select despacho, nombre from ei.profesor
where despacho<>'FC-7366' and
ant <some (select ant from ei.profesor where despacho='FC-7366');

--Ej 4:

select alum.nombre from (ei.alumno alum
inner join ei.matricula mat on alum.nal=mat.alum)
inner join ei.asignatura asig on using (idasig)
where asig.nombre='Bases de Datos I'
and mat.año=2002
and mat.sep >all (select mat.feb_jun
                  from ei.matricula mat inner join ei.asignatura asig on using (idasig)
                  where asig.nombre='Bases de Datos I'
                        and mat.año=2002
                        and mat.feb_jun is not null);



--Ej 5:

select to_char (fecha_hora, 'dd/mm/yyyy') fecha from MF.LLAMADA
where duracion >= All (select distinct duracion from mf.llamada);

--Ej 6:

select c.nombre from mf.cliente c
inner join mf.telefono tel on c.dni=tel.cliente
inner join mf.compañia com on com.cif=tel.compañia
where com.nombre='Aotra'
and tel.tarifa = (select tarifa from mf.telefono tel 
                inner join mf.tarifa t using (tarifa, compañia)
                where tel.numero='654123321');

--Ej. 7 (MAL!!):
select tel.numero, tel.f_contrato, tel.tipo from mf.telefono tel
inner join mf.llamada ll on tel.numero=ll.TF_ORIGEN
where to_char(ll.fecha_hora, 'mm/yy'='10/06')

and inner join mf.cliente cli on cli.dni=tel.cliente
where cli.provincia='La Coruña'


select t.tarifa as Codigo, t.coste, c.nombre
from mf.tarifa t 
inner join mf."COMPAÑIA" c on c.cif = t."COMPAÑIA"
where t.descripcion like '%en la compañía%';

select c.nombre, t.numero
from MF.telefono t inner join mf.cliente c on t.cliente = c.dni
inner join mf.tarifa ta using (tarifa,compañia)
where ta.coste < 0.20 and t.tipo = 'C';

desc mf.telefono;
select tarifa, c.nombre, t.numero, t.puntos
from mf.tarifa inner join mf.compañia c on compañia = c.cif
inner join mf.telefono t using (tarifa, compañia)
where extract (year from t.f_contrato) = 2006
and t.puntos > 200;

select t.numero as origen, t.tipo, td.numero as destino, td.tipo
from mf.telefono t inner join mf.llamada ll on t.numero = ll.tf_origen
inner join mf.telefono td on td.numero = ll.tf_destino
where extract (hour from ll.fecha_hora) >= 8
and extract (hour from ll.fecha_hora) < 10;

select distinct c.nombre as cliente_origen, tf_origen, cd.nombre as cliente_destino, tf_destino, fecha_hora, duracion
from mf.llamada ll inner join mf.telefono t on ll.tf_origen = t.numero
inner join mf.telefono td on ll.tf_destino = td.numero
inner join mf.cliente c on c.dni = t.cliente
inner join mf.cliente cd on cd.dni = td.cliente
where ll.duracion > 900 and t."COMPAÑIA" <> td."COMPAÑIA"
order by ll.duracion desc;


--Páctica 6: Falté!

--Páctica 7:

--Obtener los nombres de TODOS los profesores junto a las asignaturas que son responsables:

select p.nombre, a.nombre
from ei.profesor p
left  join ei.asignatura a --outer??
on p.nPr = a.prof;

--Funciones aritméticas de valores simples: abs(n), ceil(n), floor(n), mod(m,n), nvl(valor, expresión)-> Si valor=Null, cambiamos valor por expresión
--F. Arit. Val. Simpl.: power(m, exponente), round (numero, [m]), sign(valor)-> signo, trunc(numero, [m]), sqrt(n)....
--Ejemplo: Select salario, comision, salario + nvl(comision, 0) from emple
--Para grupos de valores-> funciones estadísticas como sum(expresión), variance(expresión), avg(n), count(* | [Distinct | all] | expresión), max(expresión), min (sobre grupos de filas).. Los valores nulos son ignorados por estas funciones (no afectan a los cálculos)
--Con distinct podemos eliminar los duplicados y con all (se emplea por defecto) recogemos todas las filas aun estando duplicadas, pero no las nulas.

--Funcoines de cadenas: chr(n)-> valor binario de n, concat(cad1, cad2), lower(cad), upper(cad) (mayus), initcap(cad), lpad(cad1, n, [cad2]) -> añadir caracteres hasta n
--: ltrim(cad, [set]) suprime set caracteres a la izquierda de cad
--Ejercicio: Cuantos despachos ocupan los profesores de la escuela:

Select count  (distinct despacho) as numero_despachos from ei.profesor;

--Obtener el numero de matriculados, la nota maxima, la minima y la media de la asig BDI en la convocatoria de sept de 2002_
select count (alum), max(sep), min(sep), avg(sep)
from EI.MATRICULA inner join EI.ASIGNATURA using (idAsig)
where año='2002' and nombre= 'Bases de Datos I';

--Obtener mediante una consulta correlacionada los nombres de las asignaturas que tienen recomndadas 2 ó más asignaturas:

select asig.nombre from ei.asignatura asig where ( select count(idasig1) from ei.recomendaciones rec
where asig.idAsig = rec.idasig1) >= 2;

--Obtener (cons. corr.) los nombres de los profesores que tienen mas antigüedad que, al menos, otros 5 profesores:

select p1.nombre from ei.profesor p1
where (select count(p2.ant) from EI.PROFESOR p2 where p1.ant < p2.ant) >=5;

--Group by: Agrupamiento de elementos de las columnas ordenadas especificadas. Las consultas con Select deben llevar una constante, una función de grupo o una columna expresada en el group by.
--select dept_no, avg(salario) from emple group by dept_no;

--Ordenar la salida descendentemente por numero de empleados:
select dept_no, count(*) from emple
group by dept_no
having count(*) > 4
order by count(*) desc;

--Para cada asignatura y año academico, mostrar nombre de la asignatura, año, numero de alumnos presentados y la nota media obtenida en feb_jun:

select a.nombre, m.año, count(m.feb_jun) as presentados, avg(m.feb_jun) as media from ei.asignatura a
inner join ei.matricula m using (idAsig)
group by a.nombre, m.año
order by m.año;

--Listado de nombres de alumnos, nombres de asig y numero de veces que se han matriculado en esa asignatura pero solo cuando se hayan matriculado 3 ó más veces:

select al.nombre, asig.nombre, count(*) from (ei.asignatura asig
inner join ei.matricula m using (idAsig))
inner join ei.alumno al on (m.alum = al.nal)
group by al.nombre, asig.nombre
having count (*) >=3;

--Nombre de los alumnos que hayan sacado mas de un 5 de media en junio de 2002:

select al.nombre, avg(m.feb_jun) as media from ei.alumno al inner join ei.matricula m on (m.alum=al.nal)
where m.año = 2002
group by al.nombre
having avg(m.feb_jun) > 5;

--Nombre de las asignaturas y numero de alumnos matriculados de las asignaturas donde se hayan matriculado mas alumnos en el año 2002:

select asig.nombre, count(m.alum) as matriculados from ei.asignatura asig inner join ei.matricula m using (idasig)
where m.año = 2002
group by asig.nombre
having count(*) = (select max(count(*))
                  from ei.asignatura asig inner join ei.matricula m
		-- ......

--Obtener el numero total de alumnos que suspendiesen en cada asig en junio de 2002 pero sólo de las asignaturas que se hayan matriculado más de 50 alumnos: Operador in ya que puede haber un conjunto de valores




select nombre from ei.alumno
where exists (select * from ei.matricula
                  where nal=alum and año in (2000,2002))
      and not exists(select * from ei.matricula
                  where nal=alum and año =2001);
                  
select p1.nombre, p1.despacho from ei.profesor p1
where not exists (select * from ei.profesor p2
                where p1.despacho = p2.despacho
                and p1.npr<>p2.npr
                );
                
select distinct nombre from mf.cliente inner join mf.telefono on dni=cliente;

select nombre from mf.cliente inner join mf.telefono on dni=cliente
where exists (select * from mf.llamada
             where to_char(fecha_hora, 'dd/mm/yy')='16/10/06'
             and numero=tf_origen);
             
select c.nombre from mf.cliente c
inner join mf.telefono t on c.dni=t.cliente
where exists (select ll.duracion from mf.llamada ll
              where t.numero=ll.tf_origen and ll.duracion<90);
              

select distinct c.nombre from (mf.cliente c inner join mf.telefono tf on c.dni=tf.cliente)
inner join MF."COMPAÑIA" comp on comp.cif=tf."COMPAÑIA"
where comp.nombre = 'Kietostar'
and not exists (select * from mf.llamada
                where extract (month from fecha_hora)=9
                and tf.numero=tf_origen);
                
select * from MF.telefono tf
where exists (select * from mf.llamada llama 
        where llama.tf_destino='654234234'
        and tf.numero=llama.tf_origen)
and not exists (select * from mf.llamada ll2 
        where ll2.tf_origen=tf.numero
        and ll2.tf_destino='666789789');
        
select distinct tf.numero, c.nombre from mf.telefono tf inner join mf.cliente c on c.dni=tf.cliente
where not exists (select * from (mf.llamada ll inner join mf.telefono dest on ll.tf_destino=dest.numero)
                           inner join mf.compañia cia on cia.cif=dest.compañia 
                            where cia.nombre='Kietostar' and ll.tf_origen=tf.numero);
                            
                            
select cli.nombre Cliente, sum(ll.duracion) Total from (mf.cliente cli inner join mf.telefono t on t.cliente=cli.dni)
                inner join mf.llamada ll on ll.tf_origen=t.numero
where ll.tf_origen in (select t.numero from (mf.cliente cli inner join mf.telefono t on t.cliente=cli.dni)
                    where cli.provincia='La Coruña')
and ll.tf_destino in (select t.numero from (mf.cliente cli inner join mf.telefono t on t.cliente=cli.dni)
                    where cli.provincia='Jaén')
group by cli.nombre;


select cli.nombre, count(*) from (mf.cliente cli inner join mf.telefono t on t.cliente=cli.dni)
                        inner join mf.llamada ll on ll.tf_origen=t.numero
group by cli.nombre
having count (ll.tf_origen)>5;


select cli.nombre, avg(tar.coste) Media from (mf.cliente cli inner join mf.telefono t on t.cliente=cli.dni)
                                            inner join mf.tarifa tar using(tarifa, compañia)
group by cli.nombre
having avg(tar.coste) >= (select avg(tar.coste) from mf.tarifa tar)



PL/SQL:

1) Con procedimiento almacenado se requiere mostrat una estística de cada asignatura del porcentaje de alumnos aprobados respecto a los presentados
en feb_jun para un curso y año dado por parámetros (porcentaje_aprobador(2,2002)), controlando con excepciones que no existan alumnos matriculados en 
el año que se especificque en la llamada al procedimiento:

set serveroutput on;
declare
	curso number:= 2;
	año number := 2002;
begin 
	porcentaje_aprobados(curso, año);
end;

select idAsig, nombre
from ei.asignatura
where curso = 2;


CREATE OR REPLACE 
PROCEDURE porcentaje_aprobados(p_curso ei.asignatura.curso%type,
				p_año ei.matricula.año%type) is
cursor c_asignaturas is 
	select idAsig, nombre
	from ei.asignatura
	where curso = p_curso;
cursor c_matriculas(p_idAsig ei.matricula.idAsig%type) is        --p_idAsig correlación!!! Referencia al primer cursor!
	select idAsig, feb_jun
	from ei.matricula
	where año = p_año and idAsig = p_idAsig;

--Procedimiento:
num_alumnos_presentados integer;
num_alumnos_aprobados integer;
porcentaje number(5,2);
existe_año integer;

begin
	for v_asignaturas in c_asignaturas loop
		num_alumnos_presentados :=0;
		num_alumnos_aprobados := 0;
		for v_matriculas in c_matriculas(v_asignaturas.idAsig) loop
			if (v_matriculas.feb_jun is not null) then
				num_alumnos_presentados := num_alumnos_presentados+1;
				if (v_matriculas.feb_jun >= 5) then
					num_alumnos_aprobados := num_alumnos_aprobados+1;
				end if;
			end if;
		end loop;
		if (num_alumnos_presentados <> 0) then 
			porcentaje := (num_alumnos_aprobados/num_alumnos_presentados)*100;
		else 
			porcentaje :=0;
		end if;
		dbms_output.put_line(rpad(v_asignaturas.nombre, 40) || '' || rpad(num_alumnos_presentados, 6) || '' || rpad(num_alumnos_aprobados, 6));
	
--Excepciones:

filas:año integer;
no_existe_año exception;

begin
	select count(*) into filas_año from ei.matricula
	where año = p_año and curso = p_curso;
	if filas_año = 0  then raise no_existe_año;
	end if;

exception
	when no_existe_año then
	dbms_output.put_line('No hay información del curso' || p_año || 'en la BD!');
	when others


2)
Consulta primer cursor c_telefonos_cia:

select tel.numero
from compañia c inner join telefono tel
on c.cif = tel.compañia
where c.nombre = 'Aotra'; --p_cia  en el procedimiento



CREATE OR REPLACE 
PROCEDURE llamadas_cia(cia compañia.nombre%type,
			fecha date) is

--Variables y cursores:

filas_llamadas_fecha integer;
no_existe_llamadas_fecha exception;
num_ll_total integer;
num_ll_100 integer;
num_total_cia integer;
porcentaje number(5,2);

cursor c_telefonos_cia is 
 select numero
 from compañia c inner join telefono tel
	on c.cif = tel.compañia
 where c.nombre = cia;

cursor c_llamadas_tf (tlf llamada.tf_origen%type) is  --NO tel? Probar en casa!!!! 
 select tf_origen, tf_destino, duracion
 from llamada llam
 where to_char(llam.fecha_hora, 'dd/mm/yy') = fecha and tf_origen = tlf;

begin
 	select count(*) into filas_llamadas_fecha
	from (llamada llam inner join telefono tel
		on llam.tf_origen = tel.numero)
		inner join compañia cia on cia.cif = tel.compañia
	where  to_char(llam.fecha_hora, 'dd/mm/yy') = fecha
	and cia.nombre = cia;

	if filas_llamada_fecha = 0 then
		raise no_existe_llamadas_fecha;
	end if;

dbms_output.put_line('tlf.origen num_ll num_ll_100 porcentaje%');
dbms_output.put_line('----------------------------------------');

	num_total_cia := 0;
	for v_telefono in c_telefonos_cia loop
		num_ll_total :=0;
		num_ll_100 := 0;
		for v_llamada in c_llamadas_tf (v_telefono.numero) loop
			if( v_llamada.duracion > 100) then
				num_ll_100 := num_ll_100 + 1;
			end if;
			num_ll_total := num_ll_total +1;
			num_total_cia := num_total_cia +1;
		end loop;
		
		if (num_ll_100 <> 0) then 
			porcentaje := (num_ll_100/num_ll_total)*100;
		else porcentaje :=0;
		end if;
		dbms_output.put_line(rpad(v_telefono.numero, 13) || rpad(num_ll_total, 8) || rpad(num_lla_100, ) || rpad(porcentaje%)...);

exception

end




















Servicios de interrupcion:




El DOS y el BIOS del PC proveen de algunas rutinas de servicio que se pueden utilizar para incrementar la versatilidad de los programas del usuario. A estas rutinas se las llama utilizando las características de la interrupción por software del microprocesador 8086.
Fin de programa
    INT 21H AX = 4C00H
Descripción: Esta rutina finalizará el programa y devolverá el control al DOS. Debe llamar a esta rutina para finalizar los programas.
Uso:    Entrada:   AX = 4C00H
            Salida:     Ninguna
           Registros afectados:   Ninguno 
Status del teclado
    INT 21H AH = 0BH
Descripción: La función de esta rutina es detectar si se ha pulsado una tecla.

Uso:    Entrada:  AH = 0BH
           Salida:    AL = FF si caracter disponible
                           AL = 0 si caracter no disponible
           Registros afectados:    AL
Entrada de un carácter desde teclado
    INT 21H AH = 8H

Descripción: La función de esta rutina es esperar un carácter del teclado sin escribirlo por pantalla y almacenarlo en el
registro AL en forma de código ASCII.

Uso:    Entrada:   AH = 8H
            Salida:    AL = car cter ASCII de la tecla pulsada
            Registros afectados:   AL
Leer una línea de programa
    INT 21H AH = 0AH

Descripción: La función de esta rutina es la de obtener una línea de datos del teclado (que finaliza al pulsar el retorno de
carro) y almacenarlos en un  rea de memoria. Los caracteres son mostrados en la pantalla al ser tecleados.

Uso:    Entrada:   AH = 0AH
                            DS contiene la dirección del segmento de memoria en el cual se almacenan los datos introducidos.
                            DX contiene la dirección del offset de la zona de memoria del segmento anterior en la que se almacenan
                            los datos.
                            En el primer byte del área debe indicarse el máximo número de caracteres a introducir sin superar 255.
            Salida:     Ninguna en registro
                            En el segundo byte del área se almacena el número de caracteres tecleados sin contar el retorno de carro.
            Registros afectados:  Ninguno
Salida de un carácter por pantalla
    INT 21H AH = 2H

Descripción: La función de esta rutina es visualizar un carácter.

Uso:    Entrada:  AH = 2H
                            DL contiene el código ASCII del carácter a visualizar.
            Salida:    Ninguna
            Registros afectados:  Ninguno
Sacar un string a la pantalla
    INT 21H AH = 9H

Descripción: Su función es la de sacar una cadena de caracteres ASCII por pantalla.

Uso:    Entrada:   AH = 9H
                            DS contiene el valor de la dirección del segmento del comienzo de la cadena de caracteres a sacar.
                            DX contiene el offset de dicha cadena en el segmento anterior.
                            El último byte de la cadena de caracteres debe ser el caracter $, que no se muestra en pantalla.
            Salida:      Ninguna
            Registros afectados:   AX
Establecer nuevo vector de interrupción
    INT 21H AX = 25H

Descripción: Esta rutina establece un nuevo vector de interrupción.

Uso:    Entrada:  DS:DX  Dirección de la rutina de servicio
                           AL:    Número de la interrupción
            Salida:   Actualización de la tabla de vectores
            Registros afectados:  Ninguno
Obtiene número de interupción
    INT 21H AX = 35H

Descripción:   Esta rutina devuelve el vector de interrupción del número de interrupción que se especifique en AL.

Uso:    Entrada:  AL  Número de la interrupción
            Salida:   ES:BX  Vector de la interrupción
            Registros afectados:  Ninguno
Posicionar el cursor
     INT 10H AH = 02H

Entrada:  DH = fila (0-24)
                 DL = columna (0-79)
                 BH = número de página
Escribir un caracter en pantalla, donde está el cursor
    INT 10H AH = 0AH

Entradas:  BH = número de página
                   AL = caracter a escribir
Leer caracter y atributo de la posición actual del cursor
    INT 10H AH = 08H

Entradas:  BH = número de página
Salidas:    AL = caracter leído
                AH = atributo del caracter leído
Escribir caracter y atributo en la posición actual del cursor
    INT 10H AH = 09H

Entradas:  BH = número de página
                  BL = atributo del caracter
                  CX = número de caracteres a escribir
                 AL = caracter a escribir
Códigos ANSI
Esc[2J
     Borra la pantalla
Esc[x;yf
     Posiciona el cursor en las coordenadas x, y.

El caracter Esc es el código escape cuyo valor ASCII es el 27 (1BH).




.mode small ;1seg para datos y otro para codigo

.data 

    cadena db 5,0,0,0,0,0
    pesonb db 8,4,2,1
    pesoc1 db 7,4,2,1
    
.code   
    
    mov ax, seg cadena     ;inicialización
    mov ds, ax
    
    mov dx, offset cadena  ;desplazamiento en el seg datos para almacenar caracteres
    mov ah, 0ah            ;obtener una línea de datos del teclado 
    int 21h                ;interrupción 0x21
    
    sub cadena[2], 48      ;Conversión de ASCII a binario
    sub cadena[3], 48
    sub cadena[4], 48
    sub cadena[5], 48
    
    ;cmp cont, 0
    ;je fin
    
    mov al, cadena[2]
    mul peso[0]
    mov bl, al 
    
    mov al, cadena[3]
    mul peso[1]
    mov bl, al
    
    mov al, cadena[4]
    mul peso[2]
    mov bl, al
    
    mov al, cadena[5]
    mul peso[3]
    mov bl, al
    
    mov ax, bx
    mov bl, 10
                ;en ah se almacena el resto (unidad) y en al el cociente
    div bl
    mov cl, al
    add cl, 48  
    mov ch, ah
    add ch, 48
    
    ;establece modo texto de pantalla para imprimir los digitos en decimal
    
    mov al, 03h
    mov ah, 00h
    int 10h
    
    mov ax, 0b800h
    mov es, ax
    mov di, 0
    
    mov ah, 00001111b     ;fondo negro y texto blanco
    mov al, cl
    mov es:[di], ax
    mov al, ch
    mov es:[di+2], ax
    
    mov ah, 00h
    int 16h
    
;fin

    ;mov ah, 4ch  ; Esta rutina finalizará el programa y devolverá el control al DOS.
    ;int 21h
    
end


;;


.model small

.data

    cadena db 5,0,0,0,0,0,0
    pesobn db 8,4,2,1   
    pesoc1 db 7,4,2,1
    suma db 0
    
.code 

    mov ax, seg cadena   
    mov ds, ax
    
    mov dx, offset cadena  
    mov ah, 0ah
    int 21h
    
    sub cadena [2], 48  
    sub cadena [3], 48
    sub cadena [4], 48
    sub cadena [5], 48
    
    ;cmp cont, 0
    ;je fin
                 
    mov al, cadena[3]
    mul pesobn[1]
    mov bl, al 
    
    mov al, cadena[4]
    mul pesobn[2]
    add bl, al
    
    mov al, cadena[5]
    mul pesobn[3]
    add bl, al 
    
    mov suma, bl    ;guardamos el resultado porque nos sirve para el Complemento a 1.
    
    mov al, cadena[2]
    
    mul pesobn[0]  
    add bl, al    ;guardamos el valor en binario natural sin signo
    
    mov ax, bx
    mov bl, 10
             
             ;en ah se almacena el resto (unidad) y en al el cociente
    div bl
    mov cl, al
    add cl, 48
    mov ch, ah
    add ch, 48
                  
                  ;establece modo texto de pantalla para imprimir los digitos en decimal
    mov al, 03h
    mov ah, 00h
    int 10h
    
    mov ax,0b800h
    mov es, ax
    mov di,0
    
    mov ah, 00001111b   ;fondo negro y texto blanco     
    mov al, cl
    mov es:[di], ax
    mov al, ch
    mov es:[di+2], ax
    
    mov ah, 00h
    int 16h
    
    ;Calculamos ahora el Complemento a 1:
    mov bl, suma
     
    mov al, cadena[2]
    mul pesoc1[0]
    sub bl, al      
     
    ;fin:
    mov ah, 4ch      ; Esta rutina finalizara el programa y devolvera el control al DOS.
    int 21h
end
    









.model small

.data

    cadena db 5,0,0,0,0,0,0
    pesos db 8,4,2,1   
    pesoc1 db 7
    suma db 0  
    valorbn db 0
    valorc1 db 0  
    signoc1 db '+'
    
.code 
    
    ;inicializacion del segmento de datos:
    mov ax, seg cadena   
    mov ds, ax
    
    ;leer por teclado:
    mov dx, offset cadena  
    mov ah, 0ah
    int 21h
    
    ;conversion ascii a binario:
    sub cadena [2], 48  
    sub cadena [3], 48
    sub cadena [4], 48
    sub cadena [5], 48
    
    ;cmp cont, 0
    ;je fin
                 
    mov al, cadena[3]
    mul pesos[1]
    mov bl, al 
    
    mov al, cadena[4]
    mul pesos[2]
    add bl, al
    
    mov al, cadena[5]
    mul pesos[3]
    add bl, al 
    
    mov suma, bl    ;guardamos el resultado porque nos sirve para el Complemento a 1.
    
    mov al, cadena[2]
    
    mul pesos[0]  
    add bl, al    
    mov valorbn, bl  ;guardamos el valor en binario natural sin signo
    
    ;mov ax, bx
    ;mov bl, 10   ;????
             
    ;Calculamos el Complemento a 1:
    
          
    cmp cadena[2], 1  ;vemos si es negativo para imprimir el signo
    je negativo
    
    ;si no lo es:
    jmp fin       
    
    negativo:
    mov signoc1, '-'

    ;Obtenemos y guardamos su valor en c1:
    mov al, cadena[2]
    mul pesoc1     ;Si es positivo = 0
    mov bl, al 
    sub bl, suma ;Si es negativo, restamos el valor guardado en suma
    mov valorc1, bl      
           
    fin:       
    ;en ah se almacena el resto (unidad) y en al el cociente
    div bl
    mov cl, al
    add cl, 48
    mov ch, ah
    add ch, 48
                  
    ;establece modo texto de pantalla para imprimir los digitos en decimal
    mov al, 03h
    mov ah, 00h
    int 10h
    
    ;mover segmento a memoria de ´video
    mov ax,0b800h
    mov es, ax
    mov di,0
    
    ;Mostrar binario natural
    mov ah, 00001111b   ;fondo negro y texto blanco
    mov al, 'B'
    mov es:[di], ax
    mov al, 'N'
    mov es:[di+2], ax
    mov al, ':'
    mov es:[di+4], ax
    
    mov ah, 0
    mov al, valorbn
    mov bl, 10d
    div bl
    add al, 30h
    mov es:[di+6], al
    add ah, 30h
    mov es:[di+8], ah
    
    ;Mostramos el Complemento a 1:     
    mov al, 'C'
    mov es:[di+12], ax
    mov al, '1'
    mov es:[di+14], ax
    mov al, ':'
    mov es:[di+16], ax
    mov al, signoc1
    mov es:[di+18], ax
    mov al, valorc1
    add al, 30h
    mov es:[di+20], ax
    
    ;mov ah, 00h
    ;int 16h
    
    ;fin:
    mov ah, 4ch      ; Esta rutina finalizara el programa y devolvera el control al OS.
    int 21h
end
   











Sol:


.model small

.data

    cadena db 5,0,0,0,0,0,0
    peso db 8,4,2,1
    bin db 0 
    comp1 db 0
    signoc1 db '+'
    
.code 
                     
    
    mov ax, seg cadena   
    mov ds, ax
    
    
    mov dx, offset cadena  
    mov ah, 0ah
    int 21h
    
    
    
    sub cadena [2], 48  
    sub cadena [3], 48
    sub cadena [4], 48
    sub cadena [5], 48
    
                 
    mov al, cadena[3]
    mul peso[1]
    add bl, al 
    
    mov al, cadena[4]
    mul peso[2]
    add bl, al
    
    mov al, cadena[5]
    mul peso[3]
    add bl, al
    
    mov comp1, bl  
    
    mov al, cadena[2]
    mul peso[0]
    
    add bl, al  
    mov bin, bl
    
    
    cmp cadena[2], 1
    je negativo 
    
    jmp fin 
    
    
    negativo: 
    
    mov signoc1, '-'
    mov peso[0], 00000111b 
    
    mov al, cadena[2]
    mul peso[0]
    MOV bl, al  
    
    sub bl, comp1
    mov comp1,bl
    
    
    fin: 
    
    mov ax,0b800h
    mov es, ax
    
    
    mov ah, 00001111b
    
    mov al, 'B'
    mov es:[160], ax
    mov al, 'N'
    mov es:[162], ax
    mov al, ':'
    mov es:[164], ax
    mov ah, 0
    mov al, bin
    mov bl, 10d
    div bl
    add al, 48
    mov es:[166], al
    add ah, 48
    mov es:[168], ah
    
    
    mov ah, 00001111b
    mov al, 'C'
    mov es:[320], ax
    mov al, '1'
    mov es:[322], ax
    mov al, ':'
    mov es:[324], ax
    mov al, signoc1
    mov es:[326], ax
    mov al, comp1
    add al, 48
    mov es:[328], ax
    
    
                           
       
    mov ah, 4Ch
    int 21h  
end
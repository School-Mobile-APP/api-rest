insert into grado(nivel) values ('Noveno A');
insert into alumno(apellido,contrasenia,correo_institucional,fecha_nacimiento,nombre,id_grado) values ('Guevara','12345','00055419@uca.edu.sv','1998-10-10','Felix',1)
																									   'felix@gmail.com','1998-10-10','Felix',1);
update alumno set correo_institucional='felix22@gmail.comm' where id_alumno=1;
select * from alumno;


insert into maestro(apellido,contrasenia,correo_institucional,dui,fecha_nacimiento,nombre) values ('Guevara','12345','felix@gmail.com','12345678-9','1998-10-10','Felix');
insert into administrador(apellido,contrasenia,correo_institucional,nombre) values('guevara','12345','00555419@uca.edu.sv','felixx');
insert into materia(nombre) values ('matematica');
insert into curso(id_grado,id_maestro,id_materia) values(1,1,1);
select  c.id_curso,m.nombre,c.id_grado,g.nivel,c.id_materia,c.id_maestro,t.nombre from curso c,materia m,maestro t, grado g where 
c.id_maestro=t.id_maestro and c.id_grado=g.id_grado and c.id_materia=m.id_materia and c.id_curso=c.id_curso order by c.id_curso;
select * from curso;
select * from administrador;

select * from grado;
select * from materia
select  count(1) from curso c,materia m,maestro t, grado g where c.id_maestro=t.id_maestro 
and c.id_grado=g.id_grado and c.id_materia=m.id_materia and c.id_curso=c.id_curso group by c.id_curso

insert into maestro(apellido,contrasenia,correo_institucional,dui,fecha_nacimiento,nombre) values ('Guevara','12345','felix@gmail.com','12345678-9','1998-10-10','Felix');
insert into grado(nivel) values ('Noveno A');
insert into alumno(apellido,contrasenia,correo_institucional,fecha_nacimiento,nombre,id_grado) values ('Guevara','12345','00055419@uca.edu.sv','1998-10-10','Felix',1);
insert into alumno(apellido,contrasenia,correo_institucional,fecha_nacimiento,nombre,id_grado) values ('Pineda','12345','gabriela@uca.edu.sv','1999-10-12','Gabriela',1);

insert into materia(nombre) values ('matematica');
insert into curso(id_grado,id_maestro,id_materia) values(1,1,1);
insert into nota(nota,id_alumno,id_evaluacion) values(10,1,1);
select * from nota
delete from nota 
select n.id_nota,n.nota,n.id_alumno,n.id_evaluacion,e.nombre as evaluacion,a.nombre,a.apellido from nota n,evaluacion e,alumno a 
where e.id_evaluacion=n.id_evaluacion and n.id_evaluacion=1 and a.id_alumno=n.id_alumno and EXISTS (select n.id_alumno from nota n where n.id_alumno=a.id_alumno and 
																									e.id_evaluacion=1) order by n.id_alumno
																									
select a.nombre,a.apellido,a.id_alumno from alumno a,evaluacion e,curso c,grado g where NOT EXISTS(select * from nota n where e.id_evaluacion=1
AND a.id_alumno=n.id_alumno and n.id_evaluacion=e.id_evaluacion) and c.id_curso=e.id_curso and c.id_curso=1 and g.id_grado=a.id_grado and c.id_grado=g.id_grado	
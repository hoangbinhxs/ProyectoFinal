drop database CinesaEEP;
create database cinesaEEp;
use cinesaeep;
create table salas(
    id int(5) primary key auto_increment,
    filas int(2),
    asientos int(3)
);
create table peliculas(
    titulo varchar(80),
    FechaEstreno date ,
    sinopsis text,
    fechaFE date,
    duracion int(3),
    constraint pk_peliculas primary key (titulo)
);
create table sesiones(
    id int(5) primary key auto_increment,
    fechaHora datetime,
    titulo varchar(80),
   
    idSala int(5),
    constraint fk_sesiones_sala foreign key (idSala) references Salas(id),
    constraint fk_sesiones_peliculas_titulo foreign key (titulo) references peliculas(titulo)
    );
create table entradas(
    numeroFila int(2),
    numeroAsiento int(3),
    idSesion int(5),
    constraint pk_entradas primary key(numeroFila,numeroAsiento,idSesion),
    constraint fk_entradas_sesiones foreign key (idSesion) references sesiones (id)
);
insert into salas values (null,10, 14);
insert into salas values (null,12, 16);
insert into salas values (null,15, 18); 
insert into salas values (null,15, 20);

insert into peliculas values("Interestelar",'2014-11-07', 'Un grupo de exploradores hacen uso de un orificio recién descubierto para superar las limitaciones de los viajes espaciales humanos y conquistar las vastas distancias relacionadas con los viajes interestelares.', '2018-02-23', 169);
insert into peliculas values("Pulp Fiction",'1995-01-13', 'Una peli del Tarantino con S.L. Jackson y Bruce Willis','2018-04-23', 178);
insert into peliculas values("La vida de Bryan",'1980-11-10', 'Durante la época bíblica, un hombre parece ser el mesías y se ve puesto como líder de un movimiento religioso.', '2018-04-23', 94);
insert into peliculas values("Spiderman 1",'2002-10-29', 'Peter Parker un chico que se quedó huérfano a una edad muy temprana, es un estudiante que trabaja como fotógrafo del Daily Bugle. Durante una visita del instituto al museo, una araña modificada genéticamente, escaba del laboratorio y le muerde en la mano, mientras está realizando unas fotografías.  Poco después, descubre que la mordedura de esa araña, le han otorgado unos súper poderes.', '2018-01-03', 121);
insert into peliculas values("Terminator 2 El juicio final",'1991-12-05', 'Pues un robot del futuro va al pasado para matar a un niño creando una paradoja to chunga', '2018-01-03', 156);
insert into peliculas values("Origen",'2010-06-6', 'Dom Cobb (Leonardo DiCaprio) es un ladrón con una extraña habilidad para entrar a los sueños de la gente y robarle los secretos de sus subconscientes. Su habilidad lo ha convertido en un atractivo en el mundo del espionaje corporativo, pero ha tenido un gran costo en la gente que ama. Cobb tiene la …', '2018-12-03', 148);
insert into peliculas values("El caballero Oscuro",'2008-07-13', 'Batman tiene que mantener el equilibrio entre el heroísmo y el vigilantismo para pelear contra un vil criminal conocido como el Guasón, que sumiría a Ciudad Gótica en la anarquía.', '2018-10-03', 152);
insert into peliculas values("Víctor el poder de la Fe",'1990-01-01', 'El gran Víctor tiene que mantener el equilibrio entre base de datos y programacion para pelear contra un vil criminal conocido como Dr. Sedeño, que sumiría a DAM en la anarquía.(Basado en hechos reales', '2019-10-03', 999);
insert into peliculas values("Moulin Rouge",'2001-10-11', 'Pues un sito con mujerzuelas un tio bohemio va y se enamora de una y pasan cosas que te sorprenderan(100% no fake|feat. cuchillo a mil grados)', '2018-01-10', 130);
insert into peliculas values("Forrest Gump",'1994-09-23', 'Pues esto es un tipo que nos cuenta su puta vida que es más larga que un día sin pan y eso, que va y tiene un vastago y lo cuida y corre y hace cosas', '2019-01-01', 142);

insert into sesiones values(null,'2018-06-24 16:00:00', "Interestelar",1);
insert into sesiones values(null,'2018-06-25 16:30:00', "Interestelar",2);
insert into sesiones values(null,'2018-06-26 17:00:00', "Interestelar",4);
insert into sesiones values(null,'2018-06-27 17:30:00', "Interestelar",1);
insert into sesiones values(null,'2018-06-28 19:00:00', "Interestelar",1);
insert into sesiones values(null,'2018-06-29 19:30:00', "Interestelar",3);
insert into sesiones values(null,'2018-06-23 20:00:00', "Interestelar",);
insert into sesiones values(null,'2018-06-22 20:30:00', "Interestelar",1);
insert into sesiones values(null,'2018-06-21 21:30:00', "Interestelar",4);
insert into sesiones values(null,'2018-06-20 18:00:00', "Interestelar",1);


insert into sesiones values(null,'2018-05-20 15:00:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-24 16:00:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-25 16:30:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-26 17:00:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-27 17:30:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-28 19:00:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-29 19:30:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-23 20:00:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-22 20:30:00', "Moulin Rouge",2);
insert into sesiones values(null,'2018-06-21 21:30:00', "Moulin Rouge",2);

insert into sesiones values(null,'2018-06-20 18:00:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-05-20 21:30:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-05-20 15:00:00', "Forrest Gump",3);                           
insert into sesiones values(null,'2018-06-24 16:00:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-06-25 16:30:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-06-26 17:00:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-06-27 17:30:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-06-28 19:00:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-06-29 19:30:00', "Forrest Gump",3);
insert into sesiones values(null,'2018-06-23 20:00:00', "Forrest Gump",3);
                            
insert into sesiones values(null,'2018-06-20 18:00:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-05-20 21:30:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-05-20 15:00:00', "El caballero Oscuro",4);                           
insert into sesiones values(null,'2018-06-24 16:00:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-06-25 16:30:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-06-26 17:00:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-06-27 17:30:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-06-28 19:00:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-06-29 19:30:00', "El caballero Oscuro",4);
insert into sesiones values(null,'2018-06-23 20:00:00', "El caballero Oscuro",4);

insert into sesiones values(null,'2018-06-20 18:00:00', "Víctor el poder de la Fe",1);
insert into sesiones values(null,'2018-05-20 21:30:00', "Víctor el poder de la Fe",2);
insert into sesiones values(null,'2018-05-20 15:00:00', "Víctor el poder de la Fe",3);                           
insert into sesiones values(null,'2018-06-24 16:00:00', "Víctor el poder de la Fe",4);
insert into sesiones values(null,'2018-06-25 16:30:00', "Víctor el poder de la Fe",1);
insert into sesiones values(null,'2018-06-26 17:00:00', "Víctor el poder de la Fe",2);
insert into sesiones values(null,'2018-06-27 17:30:00', "Víctor el poder de la Fe",3);
insert into sesiones values(null,'2018-06-28 19:00:00', "Víctor el poder de la Fe",4);
insert into sesiones values(null,'2018-06-29 19:30:00', "Víctor el poder de la Fe",1);
insert into sesiones values(null,'2018-06-23 20:00:00', "Víctor el poder de la Fe",2);
                            
insert into sesiones values(null,'2018-06-20 02:00:00',"Origen",1);
insert into sesiones values(null,'2018-05-20 04:00:00',"Origen",1);
insert into sesiones values(null,'2018-05-20 06:00:00',"Origen",1);                           
insert into sesiones values(null,'2018-06-24 08:00:00',"Origen",1);
insert into sesiones values(null,'2018-06-25 10:30:00',"Origen",1);
insert into sesiones values(null,'2018-06-26 12:30:00',"Origen",1);
insert into sesiones values(null,'2018-06-27 14:30:00',"Origen",1);
insert into sesiones values(null,'2018-06-28 18:00:00',"Origen",1);
insert into sesiones values(null,'2018-06-29 20:30:00',"Origen",1);
insert into sesiones values(null,'2018-06-23 22:00:00',"Origen",1);
                            
insert into sesiones values(null,'2018-06-20 02:00:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-05-20 04:30:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-05-20 06:00:00', "Terminator 2 El juicio final",2);                           
insert into sesiones values(null,'2018-06-24 08:00:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-06-25 10:30:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-06-26 12:30:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-06-27 14:30:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-06-28 16:00:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-06-29 18:30:00', "Terminator 2 El juicio final",2);
insert into sesiones values(null,'2018-06-23 20:00:00', "Terminator 2 El juicio final",2);

insert into sesiones values(null,'2018-06-20 02:00:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-05-20 04:30:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-05-20 06:00:00', "Spiderman 1",3);                           
insert into sesiones values(null,'2018-06-24 08:00:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-06-25 10:30:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-06-26 12:00:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-06-27 14:30:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-06-28 16:00:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-06-29 18:30:00', "Spiderman 1",3);
insert into sesiones values(null,'2018-06-23 20:00:00', "Spiderman 1",3);                                

insert into sesiones values(null,'2018-06-20 02:00:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-05-20 04:30:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-05-20 06:00:00', "Pulp Fiction",4);                      
insert into sesiones values(null,'2018-06-24 08:00:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-06-25 10:30:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-06-26 12:00:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-06-27 14:30:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-06-28 16:00:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-06-29 18:30:00', "Pulp Fiction",4);
insert into sesiones values(null,'2018-06-23 20:00:00', "Pulp Fiction",4);
                            
insert into sesiones values(null,'2018-06-20 02:00:00', "La vida de Bryan",1);
insert into sesiones values(null,'2018-05-20 04:30:00', "La vida de Bryan",2);
insert into sesiones values(null,'2018-05-20 06:00:00', "La vida de Bryan",3);                           
insert into sesiones values(null,'2018-06-24 08:00:00', "La vida de Bryan",4);
insert into sesiones values(null,'2018-06-25 10:30:00', "La vida de Bryan",1);
insert into sesiones values(null,'2018-06-26 12:00:00', "La vida de Bryan",2);
insert into sesiones values(null,'2018-06-27 14:30:00', "La vida de Bryan",3);
insert into sesiones values(null,'2018-06-28 16:00:00', "La vida de Bryan",4);
insert into sesiones values(null,'2018-06-29 18:30:00', "La vida de Bryan",1);
insert into sesiones values(null,'2018-06-23 20:00:00', "La vida de Bryan",1);
                          
insert into entradas values(3,3,1);
insert into entradas values(4,4,1);
insert into entradas values(1,5,1);
insert into entradas values(2,6,1);
insert into entradas values(3,2,1);

insert into entradas values(3,3,2);
insert into entradas values(1,4,2);
insert into entradas values(3,5,2);
insert into entradas values(2,6,2);
insert into entradas values(1,2,2);

insert into entradas values(3,3,2);
insert into entradas values(1,4,2);
insert into entradas values(3,5,2);
insert into entradas values(2,6,2);
insert into entradas values(1,2,2);

insert into entradas values(3,3,3);
insert into entradas values(1,4,3);
insert into entradas values(3,5,3);
insert into entradas values(2,6,3);
insert into entradas values(1,2,3);

insert into entradas values(3,3,4);
insert into entradas values(1,4,4);
insert into entradas values(3,5,4);
insert into entradas values(2,6,4);
insert into entradas values(1,2,4);


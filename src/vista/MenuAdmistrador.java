package vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import dto.Pelicula;
import dto.Sala;
import dto.Sesion;
import negocio.GestionPeliculas;
import negocio.GestionSesiones;
import vista.utilidades.Escaner;

public class MenuAdmistrador {
	GestionPeliculas gestionPelicula;
	GestionSesiones gestionSesion;
	Escaner escaner;
	
	public MenuAdmistrador() {
		gestionPelicula=new GestionPeliculas();
		gestionSesion=new GestionSesiones();
		escaner=new Escaner();
	}
	public static void  main(String args[]) {
	MenuAdmistrador menuAdministrador=new MenuAdmistrador();
	menuAdministrador.mostraMenuPricinpal();
	}
	public void mostraMenuPricinpal() {
		System.out.println("******************************************");
		System.out.println("*     Bienvenido a Cinesa EEP            *");
		System.out.println("******************************************");
		System.out.println("*  1. Añadir pelicula                    *");
		System.out.println("*  2. Eliminar pelicula                  *");
		System.out.println("*  3. Visualizar todas peliculas         *");
		System.out.println("*  4. Añadir sesion                      *");
		System.out.println("*  5. Eliminar sesion                    *");
		System.out.println("*  6. Visualizar todas sesiones          *");
		System.out.println("*  7. Exit                               *");
		System.out.println("******************************************");
		int opcionElegida=escaner.leerOpcion("Introduzca una opcion entre el 1 y el 7", 1, 7);
			switch (opcionElegida) {
			case 1:
				añadirPelicula();
				break;
			case 2:
				eliminarPelicula();
				break;
			case 3:
				visualizarPelicula();
				break;
			case 4:
				añadirSesion();
				break;
			case 5:
				eliminarSesion();
				break;
			case 6:
				visualizarSesiones();
				break;
			case 7:
				exit();
				break;
				
			}
		}
	public void añadirPelicula() {
		
		System.out.println("Introduzca el titulo de la pelicula");
		String titulo=escaner.leerLinea();
		if(!gestionPelicula.comprobarPelicula(titulo)) {
			System.out.println("Introduzca la fecha de estreno de la pelicula");
			LocalDate fechaEstreno= LocalDate.parse(escaner.leerLinea());
			System.out.println("Introduzca la fecha en que se dejará de emitir la pelicula");
			LocalDate fechaFE= LocalDate.parse(escaner.leerLinea());
			System.out.println("Introduzca una sinopsis de la película");
			String sinopsis= escaner.leerLinea();
			System.out.println("Introduzca la duracion de la pelicula");
			int duracion=escaner.leerEntero();
			Pelicula pelicula= new Pelicula(titulo, fechaEstreno, fechaFE, sinopsis, duracion);
			if(gestionPelicula.anadirPelicula(pelicula)) {
				System.out.println("**************************************************");
				System.out.println("*   Se ha insertado correctamente la pelicula    *");
				System.out.println("**************************************************");
			}else {
				System.out.println("**************************************************");
				System.out.println("*  No se ha insertado correctamente la pelicula  *");
				System.out.println("**************************************************");
			}			
		}else {
			System.out.println("**************************************************");
			System.out.println("*       La peliucla ya esta en el cartelero      *");
			System.out.println("**************************************************");
		}
		System.out.println("**************************************************");
		System.out.println("* 1. Añadir Pelicula                             *");
		System.out.println("* 2. Volver a Menu Pricinpal                     *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Selecciona una opcion ",1, 2);
		switch (opcion) {
		case 1:
			añadirPelicula();
			break;
		case 2:
			mostraMenuPricinpal();
			break;
		}
	}
	public void eliminarPelicula() {
		System.out.println("Introduzca el titulo de la película que desea eliminar");
		String tituloPeliAEliminar= escaner.leerLinea();
		if(gestionPelicula.eliminarPelicula(tituloPeliAEliminar)) {
			System.out.println("***************************************************");
			System.out.println("*  Se ha eliminado la pelicula correctamente      *");
			System.out.println("***************************************************");
		}
		else {
			System.out.println("**************************************************************");
			System.out.println("*  No se ha eliminado la pelicula,No esta en el Cartelero    *");
			System.out.println("**************************************************************");
		}
		System.out.println("**************************************************");
		System.out.println("* 1. Eliminar Pelicula                           *");
		System.out.println("* 2. Volver a Menu Pricinpal                     *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Selecciona una opcion ",1, 2);
		switch (opcion) {
		case 1:
			eliminarPelicula();
			break;
		case 2:
			mostraMenuPricinpal();
			break;
		}
		}
	
	public void visualizarPelicula() {
		List<Pelicula> peliculas = gestionPelicula.recuperarTodasPeliculas();
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}
		System.out.println("**************************************************");
		System.out.println("*          Selecciona una opcion                 *");
		System.out.println("**************************************************");
		System.out.println("* 1. Eliminar Pelicula                           *");
		System.out.println("* 2. Añadir Pelicula                             *");
		System.out.println("* 3. Volver a Menu Pricinpal                     *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Seleciona una opcion", 1,3);
		switch (opcion) {
		case 1:
			eliminarPelicula();
			break;
		case 2:
			añadirPelicula();
			break;
		case 3:
			mostraMenuPricinpal();
			break;
		}
	}
	public void añadirSesion() {
		System.out.println("Seleciona una sala entre 1 y 4");
		int opcionSala=escaner.leerOpcion("Selecciona una sala entre 1 y 4", 1, 4);
		Sala sala=new Sala(opcionSala);
		System.out.println("Introduce la fecha");
		LocalDate fecha=escaner.leerFecha();
		System.out.println("Introduce la hora");
		LocalTime hora=escaner.leerHora();
		LocalDateTime fechaHora=LocalDateTime.of(fecha, hora);
		if(gestionSesion.comprobarSalaFechaHora(sala, fechaHora)) {
			System.out.println("Introduce el titulo de la pelicula");
			String titulo=escaner.leerLinea();
			if(gestionPelicula.comprobarPelicula(titulo)) {
				Pelicula pelicula=new Pelicula(titulo);
				System.out.println("Introduzca la duracion de la pelicula");
				int duracion=escaner.leerEntero();
				Sesion sesion= new Sesion(sala, pelicula, fechaHora, duracion);
				if(gestionSesion.anadirSesion(sesion)) {
					System.out.println("**************************************************");
					System.out.println("*  Se ha añadido correctamente la sesion         *");
					System.out.println("**************************************************");

				}else {
					System.out.println("**************************************************");
					System.out.println("* No Se ha añadido correctamente la sesion       *");
					System.out.println("**************************************************");
				}
				
			}else {
				System.out.println("La Pelicula no esta");
			}
				
		}
		System.out.println("**************************************************");
		System.out.println("*          Selecciona una opcion                 *");
		System.out.println("**************************************************");
		System.out.println("* 1. Añadir Sesion                               *");
		System.out.println("* 2. Volver a Menu Pricinpal                     *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Selecciona una opcion ",1, 2);
		switch (opcion) {
		case 1:
			añadirSesion();
			break;
		case 2:
			mostraMenuPricinpal();
			break;
		}
		
	}
	
	public void eliminarSesion() {
		System.out.println("Introduzca el id de la sesion que desea eliminar");
		int idSesionEliminar= escaner.leerEntero();
		if(gestionSesion.eliminarSesion(idSesionEliminar)) {
			System.out.println("**************************************************");
			System.out.println("*  Se ha eliminado correctamente la sesion       *");
			System.out.println("**************************************************");
		}else {
			System.out.println("**************************************************");
			System.out.println("*  No se ha eliminado correctamente la sesion     *");
			System.out.println("**************************************************");
		}
		System.out.println("**************************************************");
		System.out.println("*          Selecciona una opcion                 *");
		System.out.println("**************************************************");
		System.out.println("* 1. Eliminar Sesion                             *");
		System.out.println("* 2. Volver a Menu Pricinpal                     *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Selecciona una opcion ",1, 2);
		switch (opcion) {
		case 1:
			eliminarSesion();
			break;
		case 2:
			mostraMenuPricinpal();
			break;
		}
		
	}
	public void visualizarSesiones() {
		List<Sesion> listaSesiones = gestionSesion.recuperarTodasSesiones();
		for (Sesion s : listaSesiones) {
			System.out.println(s);
		}
		System.out.println("**************************************************");
		System.out.println("*          Selecciona una opcion                 *");
		System.out.println("**************************************************");
		System.out.println("* 1. Eliminar Sesion                             *");
		System.out.println("* 2. Añadir Sesion                               *");
		System.out.println("* 3. Volver a Menu Pricinpal                     *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Seleciona una opcion", 1,3);
		switch (opcion) {
		case 1:
			eliminarSesion();
			break;
		case 2:
			añadirSesion();
			break;
		case 3:
			mostraMenuPricinpal();
			break;
		}

	}

		public void exit() {
			System.out.println("**************************************************");
			System.out.println("*                   CINESA EEP                   *");
			System.out.println("**************************************************");
			gestionPelicula.cerrar();
			gestionSesion.cerrar();
		
	}
}


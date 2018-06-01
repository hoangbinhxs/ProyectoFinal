package Vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import Vista.utilidades.Escaner;
import dto.Pelicula;
import dto.Sala;
import dto.Sesion;
import negocio.GestionPeliculas;
import negocio.GestionSesiones;

public class MenuAdmistrador {
	GestionPeliculas gestionPeli;
	GestionSesiones gestionSesiones;
	Escaner escaner;
	
	public void a�adirPelicula() {
		
		System.out.println("***************************************************");
		System.out.println("Introduzca el titulo de la pelicula");
		String titulo=escaner.leerLinea();
		System.out.println("Introduzca la fecha de estreno de la pelicula");
		LocalDate fechaEstreno= LocalDate.parse(escaner.leerLinea());
		System.out.println("Introduzca la fecha en que se dejar� de emitir la pelicula");
		LocalDate fechaFE= LocalDate.parse(escaner.leerLinea());
		System.out.println("Introduzca una sinopsis de la pel�cula");
		String sinopsis= escaner.leerLinea();
		System.out.println("Introduzca la duracion de la pelicula");
		int duracion=escaner.LeerEntero();
		Pelicula p= new Pelicula(titulo, fechaEstreno, fechaFE, sinopsis, duracion);
		gestionPeli.anadirPelicula(p);
		System.out.println("\n Se ha insertado correctamente la pelicula \n");
		System.out.println("**************************************************");
	}
	public void eliminarPelicula() {
		System.out.println("***************************************************");
		System.out.println("Introduzca el titulo de la pel�cula que desea eliminar");
		String tituloPeliAEliminar= escaner.leerLinea();
		boolean eliminado=gestionPeli.eliminarPelicula(tituloPeliAEliminar);
		if(eliminado)
			System.out.println("\nEliminado Correctamente\n");
		else
			System.out.println("\n No existe esa Pel�cula\n");
		System.out.println("**************************************************");
		}
	
	public void visualizarPelicula() {
		List<Pelicula> listaPelis = gestionPeli.recuperarTodasPeliculas();
		for (Pelicula p : listaPelis) {
			System.out.println(p);
		}
	}
	public void a�adirSesion() {
		System.out.println("***************************************************");
		System.out.println("Introduzca el titulo de la pelicula");
		String titulo=escaner.leerLinea();
		Pelicula p=new Pelicula(titulo);
		
		System.out.println("Introduzca la sala");
		int sala=escaner.LeerEntero();
		Sala s=new Sala(sala);
		
		System.out.println("Introduce una hora");
		LocalDateTime hora=LocalDateTime.parse(escaner.leerLinea());
		
		System.out.println("Introduzca la duracion de la pelicula");
		int duracion=escaner.LeerEntero();

		Sesion se = new Sesion(s, p, hora, duracion);
		gestionSesiones.anadirSesion(se);
		System.out.println("\n Se ha insertado correctamente la pelicula \n");
		System.out.println("**************************************************");
	
	}
	public void eliminarSesion() {
		System.out.println("***************************************************");
		System.out.println("Introduzca la sesion que desea eliminar");
		int idSesionEliminar= escaner.LeerEntero();
		boolean eliminado=gestionSesiones.eliminarSesion(idSesionEliminar);
		if(eliminado)
			System.out.println("\nEliminado Correctamente\n");
		else
			System.out.println("\n No existe esa sesion\n");
		System.out.println("**************************************************");
		
	}
	public void visualizarSesiones() {
		List<Sesion> listaSesiones = gestionSesiones.recuperarTodasSesiones();
		for (Sesion s : listaSesiones) {
			System.out.println(s);
		}
	}
	public void mostraMenu() {
		System.out.println("******************************************\n");
		System.out.println("\n* Bienvenido al administrador de cinesaEEP *\n");
		System.out.println("\n******************************************");
		boolean salir=false;
		while(!salir) {
			mostrarOpciones();
			int opcionElegida= 
			escaner.leerOpcion("Introduzca una opcion entre el 1 y el 7", 1, 7);
			switch (opcionElegida) {
			case 1:
				a�adirPelicula();
				break;
			case 2:
				eliminarPelicula();
				break;
			case 3:
				visualizarPelicula();
				break;
			case 4:
				a�adirSesion();
				break;
			case 5:
				eliminarSesion();
				break;
			case 6:
				visualizarSesiones();
				break;
			case 7:
				salir=true;
			}
		}
	}
	public void mostrarOpciones() {
		System.out.println("1. A�adir pelicula");
		System.out.println("2. Eliminar pelicula");
		System.out.println("3. Ver peliculas");
		System.out.println("4. A�adir sesion");
		System.out.println("5. Eliminar sesion");
		System.out.println("6. Ver sesion");
		System.out.println("7. Exit");
	
	}
	public static void  main(String args[]) {
		MenuAdmistrador ma=new MenuAdmistrador();
		ma.mostraMenu();
	}
	public boolean comprobarPelicula(String titulo) {
		if(gestionPeli.comprobarPelicula(titulo))
			return true;
		else
			return false;
	}
	public boolean comprobarSalaHoraFecha(Sala sala, LocalDateTime FechaHora) {
		if(gestionSesiones.comprobarSalaFechaHora(sala, FechaHora)) 
			return true;
		else 
			return false;
	}
}

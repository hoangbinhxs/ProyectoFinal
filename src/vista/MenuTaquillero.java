package vista;





import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import dto.Entrada;
import dto.Pelicula;
import dto.Sesion;
import negocio.GestionEntradas;
import negocio.GestionPeliculas;
import negocio.GestionSesiones;
import vista.utilidades.Escaner;

public class MenuTaquillero {
	GestionEntradas gestionEntrada;
	GestionPeliculas gestionPelicula;
	GestionSesiones gestionSesion;
	Escaner escaner;
	
	public MenuTaquillero() {
		gestionEntrada=new GestionEntradas();
		gestionPelicula=new GestionPeliculas();
		gestionSesion=new GestionSesiones();
		escaner=new Escaner();
	}
	public static void main(String[] args) {
		MenuTaquillero menuTaquillero=new MenuTaquillero();
		menuTaquillero.mostrarMenuPrincipal();
		
	}
	public void mostrarMenuPrincipal() {
		System.out.println("***************************************");
		System.out.println("*       Bienvenido a CinesaEEP        *");
		System.out.println("***************************************");
		System.out.println("* 1. Buscar Sesion por Pelicula       *");
		System.out.println("* 2. Buscar Sesion por Fecha y Hora   *");
		System.out.println("* 3. Exit                             *");
		System.out.println("***************************************");
		int opcion=escaner.leerOpcion("Introduce una opcion", 1, 3);
		switch (opcion) {
		case 1:
			buscarSesionesProximas();
			break;
		case 2:
			buscarSesionesFechaHora();
			break;
		case 3:
			exit();
			break;
		}
		
	}
	public void buscarSesionesProximas() {
		mostrarTodasPeliculas();
	}
	public void buscarSesionesFechaHora() {
			
		mostrarSesionPorFechaHora(escaner.leerFechaHora());
	}
	
	public void mostrarSesionPorFechaHora(LocalDateTime fechaHora) {
			List<Sesion> sesiones=gestionSesion.recuperarSesionPorFechaHora(fechaHora);
			for (Sesion sesion : sesiones) {
				System.out.println(sesion);
			}
			System.out.println("**************************************************");
			System.out.println("*           Seleciona una Opcion                 *");
			System.out.println("**************************************************");
			System.out.println("*  1.Mostrar una Sesion                          *");
			System.out.println("*  2.Volver a Principal                          *");
			System.out.println("**************************************************");
			int opcion=escaner.leerOpcion("Seleciona una Opcion",1,2);
			switch (opcion) {
			case 1:
				pedirIdSesion(sesiones);
			case 2:
				mostrarMenuPrincipal();
				break;
			}
	}
	
	public void mostrarTodasPeliculas(){
		List<Pelicula> listaPeliculas= gestionPelicula.recuperarTodasPeliculas();
		for(Pelicula pelicula : listaPeliculas) {
			System.out.println(pelicula);
		}
		System.out.println("**************************************************");
		System.out.println("*           Seleciona una Opcion                 *");
		System.out.println("**************************************************");
		System.out.println("*  1.Mostrar Sesiones por titulo                 *");
		System.out.println("*  2.Volver a Principal                          *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Selecionar una sesion",1,2);
		switch (opcion) {
		case 1:
			System.out.println("Introduce el titulo de la pelicula");
			String titulo=escaner.leerLinea();
			if(gestionPelicula.comprobarPelicula(titulo)) {
				mostrarSesionPorTitulo(titulo);
			}
			else {
				System.out.println("La Pelicula no existe");
				mostrarMenuPrincipal();
			}
			break;
		case 2:
			mostrarMenuPrincipal();
			break;
		}
	}
	public void mostrarSesionPorTitulo(String titulo){
		List<Sesion> sesiones=gestionSesion.recuperarSesionPorTitulo(titulo);
		for (Sesion sesion : sesiones) {
			System.out.println(sesion);
		}
		System.out.println("**************************************************");
		System.out.println("*           Seleciona una Opcion                 *");
		System.out.println("**************************************************");
		System.out.println("*  1.Mostrar una Sesion                          *");
		System.out.println("*  2.Volver a Principal                          *");
		System.out.println("**************************************************");
		int opcion=escaner.leerOpcion("Seleciona una Opcion",1,2);
		switch (opcion) {
		case 1:
			pedirIdSesion(sesiones);
		case 2:
			mostrarMenuPrincipal();
			break;
		}
	}
	
	public void pedirEntrada(Sesion sesion){
		
		mostrarPlano(sesion);
		System.out.println("");
		System.out.println("¿Cuántas entradas quieres? ");
		int entradasPedido=escaner.leerEntero();
		if(entradasPedido<sesion.entradaDisponible()) {
			System.out.println("¿Qué fila desea?: ");
			int fila = escaner.leerEntero();
			System.out.println("¿Qué asiento desea?: ");
			int asiento=escaner.leerEntero();
			List<Entrada> entradasComprar=new ArrayList<>();
			int entradaRepetido=0;
			for (int i = 0; i <entradasPedido; i++) {
				Entrada entradaCrear =new Entrada(sesion.getId(), fila, asiento+i);
				entradasComprar.add(entradaCrear);
				for (int j = 0; j <sesion.getEntradas().size(); j++)  {
					if(entradaCrear.getNumeroAsiento()==sesion.getEntradas().get(j).getNumeroAsiento()&&entradaCrear.getNumeroFila()==sesion.getEntradas().get(j).getNumeroFila())
						entradaRepetido++;
				}
			}
			if (entradaRepetido==0) {
				System.out.println("Estan disponibles las "+entradasPedido+" entradas continuas en esta fila");
				System.out.println("**************************************************");
				System.out.println("*           ¿Quieres comprar más entradas?       *");
				System.out.println("**************************************************");
				System.out.println("*  1.Sí                                          *");
				System.out.println("*  2.No                                          *");
				System.out.println("**************************************************");
				int opcion=escaner.leerOpcion("Seleciona una opcion", 1,2);
				switch (opcion) {
				case 1:
					imprimirEntrada(entradasComprar, sesion);
					gestionEntrada.guardarEntrada(entradasComprar);
					pedirEntrada(sesion);
					break;
				case 2:
				/*	System.out.println("**************************************************");
					System.out.println("*           ¿Imprimir las entradas?              *");
					System.out.println("**************************************************");
					System.out.println("*  1.Sí                                          *");
					System.out.println("*  2.Cancelar                                    *");
					System.out.println("**************************************************");
					int opcion1=escaner.leerOpcion("Seleciona una opcion", 1,2);
					switch (opcion1) {
					case 1:*/
					System.out.println("**************************************************");
					System.out.println("*         Imprimiendo las entradas               *");
					System.out.println("**************************************************");
						imprimirEntrada(entradasComprar,sesion);
						gestionEntrada.guardarEntrada(entradasComprar);
					System.out.println("**************************************************");
					System.out.println("*  Recoge sus entradas, Gracias por su visita    *");	
					System.out.println("**************************************************");
					//break;
					//case 2:
						mostrarMenuPrincipal();
						//break;
					//}
					
				}
				
			}else {
				System.out.println("No se puede comprar "+entradasPedido+" entradas continuas en esta fila");
				quererComprarEntradas(sesion);
			}
			
			
			
		}else {
			quererComprarEntradas(sesion);
			
		}
	}
	public List<Entrada> entradasAuxiliar(List<Entrada> entradas){
		List<Entrada> entrada=new ArrayList<>();
		entrada.add((Entrada) entradas);
		return null;
	}
	public void quererComprarEntradas(Sesion sesion) {
		System.out.println("**************************************************");
		System.out.println("*   ¿Quieres comprar entradas para esta sesion?  *");
		System.out.println("**************************************************");
		System.out.println("*  1.Sí                                          *");
		System.out.println("*  2.Volver al Principal                         *");
		System.out.println("**************************************************");
		int opiconComprar=escaner.leerOpcion("Seleciona una Opcion",1, 2);
		switch (opiconComprar) {
			case 1:
				pedirEntrada(sesion);
				break;

			case 2:
				mostrarMenuPrincipal();
				break;
			}
	}
	public void pedirIdSesion(List<Sesion> sesiones) {
		System.out.println("Introduce el id de la sesion");
		int idSesion=escaner.leerEntero();
		int index=sesiones.size();
		try {
		for (int i = 0; i < sesiones.size(); i++) {
			if(sesiones.get(i).getId()==idSesion)
				index=i;
		}
		System.out.println(sesiones.get(index));
		quererComprarEntradas(sesiones.get(index));
		}catch (IndexOutOfBoundsException e) {
			System.out.println("El id de la sesion es incorrecta");
			pedirIdSesion(sesiones);
		}
	}
	public void mostrarPlano(Sesion sesion) {
		List<Entrada> entradas=gestionSesion.recuperarEntradas(sesion.getId());
		String espacio="Fila "+sesion.getSala().getFilas()+" ";
		String sala="Sala "+sesion.getSala().getId();
		for (int i = 0; i <(espacio.length()+sesion.getSala().getAsientos()*4)/2; i++) {
			System.out.print(" ");
		}
		System.out.println(sala);
		
		for (int i = 0; i <= espacio.length(); i++) {
			System.out.print(" ");
		}
		for (int asientos = 1; asientos <= sesion.getSala().getAsientos(); asientos++) {
			if (asientos<10) {
				System.out.print("-"+asientos+"- ");
			}else {
				System.out.print("-"+asientos+" ");
			}			
		}
		System.out.println("");
		for (int fila = sesion.getSala().getFilas(); fila >0 ; fila--) { 
			if(fila>9) {
			System.out.print("Fila "+fila+"  ");
			}else {
				System.out.print("Fila "+fila+"   ");
			}
			
			for (int asientos = 1; asientos <=sesion.getSala().getAsientos(); asientos++) {
				if(!entradas.isEmpty()) {	
					for (Entrada entrada : entradas)  {
						if(entrada.getNumeroAsiento()==asientos&&entrada.getNumeroFila()==fila) {
							for (int j = 0; j < 3; j++) {
								System.out.print("*");
							}	
						}else
							System.out.print("");
					}
					
					System.out.print("|");
				
				}else {
					for (int j2 = 0; j2 <3; j2++) {
						System.out.print(" ");
					}
					System.out.print("|");
			}	
				
			}
			System.out.println("");
			for (int espacios = 0; espacios <=espacio.length(); espacios++) {
				System.out.print(" ");
			}
			for (int asientos = 0; asientos <sesion.getSala().getAsientos(); asientos++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.print("-");
				}
				System.out.print(" ");
				
			}
			System.out.println("");
			}
	}
	
	public void imprimirEntrada(List<Entrada> entradas,Sesion sesion)	{
		for (Entrada entrada : entradas) {
			String cadena=entrada.toString();
			cadena+=textoFormateado("Pelicula : "+sesion.getPelicula().getTitulo(),50);
			cadena+=textoFormateado("Fecha : "+sesion.getFechaHora(),50);
			cadena+=textoFormateado("Pelicula : "+sesion.getSala().getId(),50);
			 cadena+= "----------------------------------------------------\n";
			 System.out.println(cadena);

		}
	}
	public String textoFormateado(String texto, int longitud) {
		String cadena= "|"+texto;
		for(int i=0;i<longitud-texto.length();i++) {
			cadena+=" ";
		}
		cadena+="|\n";
		return cadena;
	}
	public void exit() {
		System.out.println("**************************************************");
		System.out.println("*                   CINESA EEP                   *");
		System.out.println("**************************************************");
		gestionEntrada.cerrar();
		gestionPelicula.cerrar();
		gestionSesion.cerrar();
	}
}

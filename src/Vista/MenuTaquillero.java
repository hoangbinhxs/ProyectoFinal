package Vista;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Vista.utilidades.Escaner;
import dto.Entrada;
import dto.Pelicula;
import dto.Sala;
import dto.Sesion;
import negocio.GestionEntradas;
import negocio.GestionPeliculas;
import negocio.GestionSesiones;

public class MenuTaquillero {
	GestionEntradas gestionEntrada;
	GestionPeliculas gestionPelicula;
	GestionSesiones gestionSesion;
	Escaner escaner;
	Connection conexion;
	
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
		
	}
	public void mostrarPlano(Sesion sesion) {
		String espacio="Fila "+sesion.getSala().getFilas()+" ";
		for (int i = 0; i < espacio.length(); i++) {
			System.out.print(" ");
		}
		for (int asientos = 1; asientos < 17; asientos++) {
			if (asientos<10) {
				System.out.print("-"+asientos+"- ");
			}else {
				System.out.print("-"+asientos+" ");
			}			
		}
		System.out.println("");
		for (int fila = sesion.getSala().getFilas(); fila >0 ; fila--) { 
			if(fila>9)
			System.out.print("Fila "+fila+" ");
			else
				System.out.print("Fila "+fila+"  ");
			for (int asientos = 0; asientos <sesion.getSala().getAsientos(); asientos++) {
				for (int i = 0; i <sesion.getEntradas().size() ; i++) {
					if(sesion.getEntradas().get(i).getNumeroAsiento()==asientos&&sesion.getEntradas().get(i).getNumeroFila()==fila) {
						for (int j2 = 0; j2 < 3; j2++) {
							System.out.print("*");
						}
					}else {
						for (int j2 = 0; j2 < 3; j2++) {
							System.out.print(" ");
						}
					}
					
				}
				System.out.println("|");
			}
			System.out.println("");
			for (int espacios = 0; espacios < espacio.length(); espacios++) {
				System.out.print(" ");
			}
			for (int asientos = 0; asientos <sesion.getSala().getAsientos(); asientos++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.print("-");
				}
				System.out.println(" ");
				
			}
			System.out.println("");
			}
	}
	public void buscarSesionesProximas() 
	{
		mostrarTodasPeliculas();
		System.out.println("Introduce un titulo ");
		String titulo=escaner.leerLinea();
		gestionSesion.recuperarSesionPorTitulo(titulo);
		
	}
	public void mostrarTodasPeliculas()
	{
		List<Pelicula> listaPeliculas= gestionPelicula.recuperarTodasPeliculas();
		for(Pelicula pelicula : listaPeliculas)
			System.out.println(pelicula);
		
	}
	public void mostrarSesionPorTitulo(String titulo)
	{
		gestionSesion.recuperarSesionPorTitulo(titulo);
	}
	public void pedirEntrada(Sesion sesion)
	{
		System.out.println("¿Cuántas entradas quieres?: ");
		int numero=escaner.LeerEntero();
		for(int i=0; i<numero; i++)
		{
			System.out.println("¿Qué fila desea?: ");
			int fila = escaner.LeerEntero();
			System.out.println("¿Qué asiento desea?: ");
			int asiento=escaner.LeerEntero();
			Entrada e = new Entrada(fila,asiento);
			gestionEntrada.comprobarEntrada(e, sesion);
			imprimirEntrada();
		}
		
	}
	public String imprimirEntrada()
	{
		Entrada e=new Entrada();
		Pelicula p=new Pelicula();
		Sesion s=new Sesion();
		Sala sa = new Sala();
		
		
		return "-------------------\n|"+e.getIdTicket()+"\n|"+e.getNumeroFila()+"\n|"+e.getNumeroAsiento()+"\n|"+p.getTitulo()+"\n|"+s.getFechaHora()+"\n|"+sa.getId()+"\n----------------------------";
	}
}

package tester;

import java.time.LocalDateTime;
import java.util.List;

import dao.SesionDAO;
import dto.Entrada;
import dto.Pelicula;
import dto.Sala;
import dto.Sesion;


public class testSesion {

	public static void main(String[] args) {
		SesionDAO s= new SesionDAO();
		
		//Sala sala=new Sala(3);
		
		//Pelicula peli=new Pelicula("Moulin Rouge");
		//LocalDateTime now=LocalDateTime.of(2018, 05,23,20, 00);
		//LocalDateTime fechaHora=LocalDateTime.now();
		//System.out.println(s.comprobarSalaFechaHora(sala, now));
		//Sesion sesion=new Sesion(now, peli, sala);
		//s.anadirSesion(sesion);
		//System.out.println(s.eliminarSesion(13));
		/*
		List<Sesion> sesiones=s.recuperarSesionPorTitulo(peli.getTitulo());
		for (Sesion sesion : sesiones) {
			System.out.println(sesion);
		}*/
		//System.out.println(s.comprobarSalaFechaHoraDisponible(sala, now));
		/*
		List<Sesion> sesionFechaHora=s.recuperarSesionPorFechaHora(fechaHora);
		for (Sesion sesion : sesionFechaHora) {
			System.out.println(sesion);
		}*/
		/*List<Sesion> sesionTodas=s.recuperarTodasSesiones();
		for (Sesion sesion : sesionTodas) {
			System.out.println(sesion);
		}*/
		
		//s.(sala, sesionObj.getFechaHora());
		
		List<Entrada> entradas=s.recuperarEntradas(1);
		for (Entrada entrada : entradas) {
			System.out.println(entrada);
		}
	}

}

package Tester;

import dao.SesionDAO;
import dto.Pelicula;
import dto.Sala;
import dto.Sesion;


public class testSesion {

	public static void main(String[] args) {
		SesionDAO s= new SesionDAO();
		Sesion sesionObj= new Sesion();
		//Sala sala=new Sala();
		Pelicula peli=new Pelicula();
		s.anadirSesion(sesionObj);
		s.eliminarSesion(1);
		s.recuperarSesionPorTitulo(peli.getTitulo());
		s.recuperarSesionPorFechaHora(sesionObj.getFechaHora());
		s.recuperarTodasSesiones();
		//s.(sala, sesionObj.getFechaHora());
		s.recuperarEntradas(1);
	}

}

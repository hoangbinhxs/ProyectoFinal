package Tester;

import java.time.LocalDate;
import java.util.List;

import dao.PeliculaDAO;
import dto.Pelicula;

public class TesterPeliculas {

	public static void main(String[] args) {
		PeliculaDAO p=new PeliculaDAO();
		//LocalDate now=LocalDate.of(2018,01,03);
		//LocalDate no1=LocalDate.of(2002,10,19);
		//Pelicula peli=new Pelicula("spiderman 1", no1,now, "Peter Parker un chico que se qued� hu�rfano a una edad muy temprana, es un estudiante que trabaja como fot�grafo del Daily Bugle. Durante una visita del instituto al museo, una ara�a modificada gen�ticamente, escaba del laboratorio y le muerde en la mano, mientras est� realizando unas fotograf�as.  Poco despu�s, descubre que la mordedura de esa ara�a, le han otorgado unos s�per poderes.",2);
		
		System.out.println(p.eliminarPelicula("Origen"));
		//System.out.println(p.anadirPelicula(peli));
		
		//System.out.println(p.comprobarPelicula("titanic"));
		//System.out.println(p.eliminarPelicula("Spiderman 1"));
		/*List<Pelicula> peliculas=p.recuperarTodasPeliculas();
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}*/

	}

}

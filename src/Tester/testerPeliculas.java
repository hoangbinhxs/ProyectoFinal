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
		//Pelicula peli=new Pelicula("spiderman 1", no1,now, "Peter Parker un chico que se quedó huérfano a una edad muy temprana, es un estudiante que trabaja como fotógrafo del Daily Bugle. Durante una visita del instituto al museo, una araña modificada genéticamente, escaba del laboratorio y le muerde en la mano, mientras está realizando unas fotografías.  Poco después, descubre que la mordedura de esa araña, le han otorgado unos súper poderes.",2);
		
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

package Tester;

import dao.PeliculaDAO;
import dto.Pelicula;

public class testerPeliculas {

	public static void main(String[] args) {
		PeliculaDAO p=new PeliculaDAO();
		Pelicula peli=new Pelicula();
		p.anadirPelicula(peli);
		p.comprobarPelicula("titanic");
		p.eliminarPelicula("mou");
		p.recuperarTodasPeliculas();

	}

}

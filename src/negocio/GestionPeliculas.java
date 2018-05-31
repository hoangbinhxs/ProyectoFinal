package negocio;

import java.util.List;

import dao.PeliculaDAO;
import dto.Pelicula;

public class GestionPeliculas {
	PeliculaDAO peliculaDao;
	public GestionPeliculas() {
		peliculaDao=new PeliculaDAO();
	}
	public List<Pelicula> recuperarTodasPeliculas() {
		return peliculaDao.recuperarTodasPeliculas();
	}

	public boolean anadirPelicula(Pelicula p) {
		return peliculaDao.anadirPelicula(p);
	}

	public boolean eliminarPelicula(String titulo) {
		return peliculaDao.eliminarPelicula(titulo);
	}

	public boolean comprobarPelicula(String titulo) {
		return peliculaDao.comprobarPelicula(titulo);
	}

}

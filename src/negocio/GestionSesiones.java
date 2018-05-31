package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.SesionDAO;
import dto.Entrada;
import dto.Sala;
import dto.Sesion;

public class GestionSesiones {
	SesionDAO sesionDao;
	public GestionSesiones() {
		sesionDao=new SesionDAO();
	
	}
	public boolean eliminarSesion(int id) {
		return sesionDao.eliminarSesion(id);
	}
	public boolean anadirSesion(Sesion s) {
		return sesionDao.anadirSesion(s);
	}
	public List<Sesion> recuperarSesionPorTitulo(String titulo) {
		return sesionDao.recuperarSesionPorTitulo(titulo);
	}
	public List<Sesion> recuperarSesionPorFechaHora(LocalDateTime fechaHora) {
		return sesionDao.recuperarSesionPorFechaHora(fechaHora);
	}
	public List<Sesion> recuperarTodasSesiones() {
		return sesionDao.recuperarTodasSesiones();
	}
	public List<Entrada> recuperarEntradas(int idSesion) {
		return sesionDao.recuperarEntradas(idSesion);
	}
	public boolean comprobarSalaFechaHora(Sala sala, LocalDateTime fechaHora) {
		return sesionDao.comprobarSalaFechaHora(sala, fechaHora);
	}
	}
